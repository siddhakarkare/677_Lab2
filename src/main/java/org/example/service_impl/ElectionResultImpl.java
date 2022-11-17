package org.example.service_impl;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.*;
import org.example.services.ElectionServiceGrpc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ElectionResultImpl extends ElectionServiceGrpc.ElectionServiceImplBase {
    private Peer peer;

    public ElectionResultImpl(Peer peer) {
        this.peer = peer;
    }

    @Override
    public void electLeader(ElectionRequest request, StreamObserver<ElectionReply> responseObserver) {
//        List<Integer> path = new ArrayList<>(request.getPathList());
//        int seller_id = request.getSellerId();
//        long request_id = request.getRequestId();
//        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
//        if (path.isEmpty()) {
//            System.out.println(timeStamp + " >> Availability reply received for requestId " + request_id + " from seller " + seller_id + ", initiating purchase transaction");
//            Boolean status = purchaseItem(peer.getId(), seller_id, peer.getProduct(), request_id);
//            if(Boolean.TRUE.equals(status)) {
//                System.out.println(timeStamp + " >> Purchase transaction failed, starting lookup for request_id " + request_id + " again");
//                // if the transaction is successful, we move to the next one by resetting the peer and starting lookup again
//                peer.reset();
//                // send lookup request to neighbors after completion of a successful transaction
//                sendLookupToNeighbors();
//            }
//        } else {
//            // send reply to next member in the path
//            int path_size = path.size();
//            System.out.println(timeStamp + " >> Propagating reply received from peer " + request.getSellerId() + " to buyer " + path.get(path_size - 1) + ":\n" + request);
//            sendAvailabilityReply(request.getSellerId(), path, request_id);
//        }
//
//        responseObserver.onNext(Empty.getDefaultInstance());
//        responseObserver.onCompleted();
    }
}
