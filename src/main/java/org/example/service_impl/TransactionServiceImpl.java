package org.example.service_impl;

import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.SellerOutOfStockNotificationReply;
import org.example.data_types.TransactionReply;
import org.example.data_types.TransactionRequest;
import org.example.services.TransactionServiceGrpc;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl extends TransactionServiceGrpc.TransactionServiceImplBase {
    private Peer peer;

    public TransactionServiceImpl(Peer peer) {
        this.peer = peer;
    }

    // TODO: Handle its response at the buyer's end
    @Override
    public void transact(TransactionRequest request, StreamObserver<TransactionReply> responseObserver) {

        // if item is available, perform transaction, otherwise send failure in reply
        int buyer = request.getBuyerId();
        String product = request.getProductName();
        int quantity = request.getQty();

        // schema: peerId => [seller_prod, seller_qty, seller_price]
        Map<Integer, List<String>> totalStock = peer.getSellerStockRecord();
        Map<Integer, Integer> sellerStockMap = new HashMap<>();
        int availableQuantity = 0;

        for (int seller : totalStock.keySet()) {
            List<String> details = totalStock.get(seller);
            if(details.get(0).equals(product)) {
                int quan = Integer.valueOf(details.get(1));
                sellerStockMap.put(seller, quan);
                availableQuantity += quan;
            }
        }

        // TODO: FIX THIS THING
        // purchase will be successful, start deducting quantity from the peers.
        if(availableQuantity >= quantity) {
//            while(oldQuan >= quantity) {
//
//            }
            for (int seller : sellerStockMap.keySet()) {
                int oldQuan = sellerStockMap.get(seller);
                // transaction done, update map and return success status
                if(oldQuan >= quantity) {
                    List<String> oldDetails = totalStock.get(seller);
                    oldDetails.remove(1);
                    oldDetails.add(1, String.valueOf(oldQuan - quantity));
                    if(oldQuan == quantity) {
                        // TODO: Notify and initiate seller reset
                    }
                    totalStock.replace(seller, oldDetails);
                    peer.setSellerStockRecord(totalStock);
                    TransactionReply reply = TransactionReply.newBuilder().setStatusCode(true).build();
                    responseObserver.onNext(reply);
                    responseObserver.onCompleted();
                }
            }
        } else {
            TransactionReply reply = TransactionReply.newBuilder().setStatusCode(false).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }



    }
}
