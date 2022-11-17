package org.example.service_impl;


import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.ElectionReply;
import org.example.data_types.ElectionRequest;
import org.example.services.ElectionServiceGrpc;

import java.text.SimpleDateFormat;

public class ElectionServiceImpl extends ElectionServiceGrpc.ElectionServiceImplBase {

    private Peer peer;

    public ElectionServiceImpl(Peer peer) {
        this.peer = peer;
    }

    @Override
    public void electLeader(ElectionRequest request, StreamObserver<ElectionReply> responseObserver) {

        int buyer_id = request.getInitiatorId();
//        List<Integer> path = new ArrayList<>(request.);

        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
        System.out.println(timeStamp + " \nLookup request received at peer " + peer.getId() + ":\n" + request);
//        if(!path.contains(peer.getId())) {
//            if (product.equals(peer.getProduct()) && peer.getQuantity() > 0) {
//                sendAvailabilityReply(peer.getId(), path, request_id);
//            } else {
//                if (request.getHops() != 0) {
//                    System.out.println(timeStamp + " >> Product not available for RequestId: " + request_id + ", propagating lookup requests to neighbors");
//                    for (int neighbor: peer.getNeighbors()) {
//                        if(!path.contains(neighbor)) {
//                            sendLookupToNeighbor(neighbor, hops, buyer_id, product, path, request_id);
//                        }
//                    }
//                }
//            }
//        }

//        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

}
