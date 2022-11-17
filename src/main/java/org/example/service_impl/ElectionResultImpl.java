package org.example.service_impl;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.LookupRequest;
import org.example.data_types.SellerReply;
import org.example.data_types.TransactionReply;
import org.example.data_types.TransactionRequest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ElectionResultImpl extends ReplyServiceGrpc.ReplyServiceImplBase {
    private Peer peer;

    public ElectionResultImpl(Peer peer) {
        this.peer = peer;
    }

    @Override
    public void electLeader(ElectionRequest request, StreamObserver<Empty> responseObserver) {
        List<Integer> path = new ArrayList<>(request.getPathList());
        int seller_id = request.getSellerId();
        long request_id = request.getRequestId();
        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
        if (path.isEmpty()) {
            System.out.println(timeStamp + " >> Availability reply received for requestId " + request_id + " from seller " + seller_id + ", initiating purchase transaction");
            Boolean status = purchaseItem(peer.getId(), seller_id, peer.getProduct(), request_id);
            if(Boolean.TRUE.equals(status)) {
                System.out.println(timeStamp + " >> Purchase transaction failed, starting lookup for request_id " + request_id + " again");
                // if the transaction is successful, we move to the next one by resetting the peer and starting lookup again
                peer.reset();
                // send lookup request to neighbors after completion of a successful transaction
                sendLookupToNeighbors();
            }
        } else {
            // send reply to next member in the path
            int path_size = path.size();
            System.out.println(timeStamp + " >> Propagating reply received from peer " + request.getSellerId() + " to buyer " + path.get(path_size - 1) + ":\n" + request);
            sendAvailabilityReply(request.getSellerId(), path, request_id);
        }

        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    private void sendAvailabilityReply(int peerId, List<Integer> path, long requestId) {
        int destPort = path.get(0);
        path.remove(0);
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", destPort).usePlaintext().build();
        ReplyServiceGrpc.ReplyServiceBlockingStub stub = ReplyServiceGrpc.newBlockingStub(channel);
        stub.reply(SellerReply.newBuilder().addAllPath(path).setSellerId(peerId).setRequestId(requestId).build());
        channel.shutdown();
    }

    private Boolean purchaseItem(int buyerId, int sellerId, String productName, long requestId) {
        if(requestId == peer.getRequestId()) {
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", sellerId).usePlaintext().build();
            TransactionServiceGrpc.TransactionServiceBlockingStub stub = TransactionServiceGrpc.newBlockingStub(channel);
            TransactionReply reply = stub.transact(TransactionRequest.newBuilder().setSellerId(sellerId).setBuyerId(buyerId).setProductName(productName).build());
            Boolean status = reply.getStatusCode();
            channel.shutdown();
            return status;
        } else return false;
    }

    private void sendLookupToNeighbors() {
        for (int neighbor: peer.getNeighbors()) {
            List<Integer> path = new ArrayList<>();
            path.add(peer.getId());
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", neighbor).usePlaintext().build();
            LookupServiceGrpc.LookupServiceBlockingStub stub = LookupServiceGrpc.newBlockingStub(channel);
            stub.lookup(LookupRequest.newBuilder().addAllPath(path).setBuyerId(peer.getId()).setHops(2).setProductName(peer.getProduct()).setRequestId(peer.getRequestId()).build());
            channel.shutdown();
        }
    }
}
