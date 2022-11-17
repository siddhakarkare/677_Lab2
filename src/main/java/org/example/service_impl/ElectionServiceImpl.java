package org.example.service_impl;


import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.LookupRequest;
import org.example.data_types.SellerReply;
import org.example.services.ElectionServiceGrpc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElectionServiceImpl extends ElectionServiceGrpc.ElectionServiceImplBase {

    private Peer peer;

    public ElectionServiceImpl(Peer peer) {
        this.peer = peer;
    }

    @Override
    public void lookup(LookupRequest request, StreamObserver<Empty> responseObserver) {

        int buyer_id = request.getBuyerId();
        String product = request.getProductName();
        List<Integer> path = new ArrayList<>(request.getPathList());

        int hops = request.getHops();
        long request_id = request.getRequestId();
        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
        System.out.println(timeStamp + " >> RequestId: " + request_id + " \nLookup request received at peer " + peer.getId() + ":\n" + request);
        if(!path.contains(peer.getId())) {
            if (product.equals(peer.getProduct()) && peer.getQuantity() > 0) {
                sendAvailabilityReply(peer.getId(), path, request_id);
            } else {
                if (request.getHops() != 0) {
                    System.out.println(timeStamp + " >> Product not available for RequestId: " + request_id + ", propagating lookup requests to neighbors");
                    for (int neighbor: peer.getNeighbors()) {
                        if(!path.contains(neighbor)) {
                            sendLookupToNeighbor(neighbor, hops, buyer_id, product, path, request_id);
                        }
                    }
                }
            }
        }

        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    private void sendAvailabilityReply(int sellerId, List<Integer> path, long requestId) {
        System.out.println("Product available for RequestId: " + requestId + ", sending availability reply to buyer");
        Collections.reverse(path);
        int destPort = path.get(0);
        path.remove(0);
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", destPort).usePlaintext().build();

        ReplyServiceGrpc.ReplyServiceBlockingStub stub = ReplyServiceGrpc.newBlockingStub(channel);
        stub.reply(SellerReply.newBuilder().addAllPath(path).setSellerId(sellerId).setRequestId(requestId).build());
        channel.shutdown();
    }

    private void sendLookupToNeighbor(int neighborId, int hops, int buyerId, String product, List<Integer> path, long requestId) {
        path.add(peer.getId());
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", neighborId).usePlaintext().build();
        LookupServiceGrpc.LookupServiceBlockingStub stub = LookupServiceGrpc.newBlockingStub(channel);
        System.out.println("RequestId: " + requestId + " sending lookup to neighbor: " + neighborId);
        stub.lookup(LookupRequest.newBuilder()
                .addAllPath(path)
                .setBuyerId(buyerId).setHops(hops - 1)
                .setProductName(product)
                .setRequestId(requestId)
                .build());
        channel.shutdown();
    }
}
