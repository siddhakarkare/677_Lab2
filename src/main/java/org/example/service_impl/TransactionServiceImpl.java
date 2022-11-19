package org.example.service_impl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.*;
import org.example.services.ResetSellerOnOutOfStockGrpc;
import org.example.services.TransactionServiceGrpc;

import java.text.SimpleDateFormat;
import java.util.*;

public class TransactionServiceImpl extends TransactionServiceGrpc.TransactionServiceImplBase {
    private Peer peer;

    public TransactionServiceImpl(Peer peer) {
        this.peer = peer;
    }

    // TODO: Handle its response at the buyer's end
    @Override
    public void transact(TransactionRequest request, StreamObserver<TransactionReply> responseObserver) {
        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
        // if item is available, perform transaction, otherwise send failure in reply
        System.out.println(timeStamp + ">> Initializing trade for request:\n " + request);
        String product = request.getProductName();
        int quantity = request.getQty();

        // schema: peerId => [seller_prod, seller_qty, seller_price]
        Map<Integer, List<String>> totalStock = peer.getSellerStockRecord();
        Map<Integer, Integer> sellerStockMap = new HashMap<>();
        int availableQuantity = 0;

        for (int seller : totalStock.keySet()) {
            List<String> details = totalStock.get(seller);
            if(details.get(0).equals(product)) {
                int quan = Integer.parseInt(details.get(1));
                sellerStockMap.put(seller, quan);
                availableQuantity += quan;
            }
        }

        // purchase will be successful, start deducting quantity from the peers.
        if(availableQuantity >= quantity) {
            Iterator<Integer> iterator = sellerStockMap.keySet().iterator();
            while(quantity > 0) {
                int seller = iterator.next();
                int sellerQuantity = sellerStockMap.get(seller);

                if(sellerQuantity >= quantity) {
                    System.out.println(timeStamp + ">> Selling amount:\n " + quantity + " from seller: " + seller + "\nTrade is complete!");
                    sellerQuantity -= quantity;
                    quantity = 0;
                } else {
                    // quantity - sellerQuantity and sellerQuantity - quantity we move to the next seller
                    quantity -= sellerQuantity;
                    System.out.println(timeStamp + ">> Selling amount:\n " + sellerQuantity + " from seller: " + seller + "\nSeller now out of stock\n Remaining quantity: " + quantity);
                    sellerQuantity = 0;
                }

                if(sellerQuantity == 0) {
                    List<String> newDetails = sendOutOfStockNotification(peer.getId(), seller);
                    totalStock.replace(seller, newDetails);
                } else {
                    List<String> oldDetails = totalStock.get(seller);
                    List<String> newDetails = new ArrayList<>();
                    newDetails.add(oldDetails.get(0));
                    newDetails.add(String.valueOf(sellerQuantity));
                    newDetails.add(String.valueOf(oldDetails.get(2)));
                    totalStock.replace(seller, newDetails);
                }
            }

            peer.setSellerStockRecord(totalStock);
            TransactionReply reply = TransactionReply.newBuilder().setStatusCode(true).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } else {
            TransactionReply reply = TransactionReply.newBuilder().setStatusCode(false).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

    private List<String> sendOutOfStockNotification(int traderId, int sellerId) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", sellerId).usePlaintext().build();
        ResetSellerOnOutOfStockGrpc.ResetSellerOnOutOfStockBlockingStub stub = ResetSellerOnOutOfStockGrpc.newBlockingStub(channel);
        System.out.println("Initiating seller reset as it is out of stock: " + sellerId);
        SellerOutOfStockNotificationReply reply = stub.resetSeller(SellerOutOfStockNotification.newBuilder().setTraderId(traderId).build());
        channel.shutdown();
        String newSellerProduct = reply.getProductName();
        int newQty = reply.getQty();
        int newPrice = reply.getPrice();
        List<String> newDetails = new ArrayList<>();
        newDetails.add(newSellerProduct);
        newDetails.add(String.valueOf(newQty));
        newDetails.add(String.valueOf(newPrice));

        return newDetails;
    }
}
