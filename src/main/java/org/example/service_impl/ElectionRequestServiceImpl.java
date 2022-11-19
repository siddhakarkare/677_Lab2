package org.example.service_impl;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.ElectionReply;
import org.example.data_types.ElectionRequest;
import org.example.services.ElectionRequestServiceGrpc;
import org.example.services.ElectionServiceGrpc;
import org.example.services.ElectionServiceReplyGrpc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ElectionRequestServiceImpl extends ElectionRequestServiceGrpc.ElectionRequestServiceImplBase {

    private Peer peer;

    public ElectionRequestServiceImpl(Peer peer) {
        this.peer = peer;
    }

    @Override
    public void electLeader(ElectionRequest request, StreamObserver<ElectionReply> responseObserver) {

        int initiatorId = request.getInitiatorId();
        int initiatorVoterId = request.getVoterId();
        List<Integer> path = new ArrayList<>(request.getPathList());

        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
        System.out.println(timeStamp + " \nElection request received at peer " + peer.getId() + ":\n" + request);

        if( initiatorVoterId > this.peer.getLeaderVoterId()){ // found bully
            this.peer.setLeader(initiatorId,initiatorVoterId);
            path = new ArrayList<>(Arrays.asList()); // Clear path
        }


        path.add(this.peer.getId());
        boolean isLeaf = false;
        for (int neighbor : peer.getNeighbors()) {
            if(!path.contains(neighbor)) {//don't process if already visited at this peer
                sendElectionToNeighbor(neighbor, initiatorId, path);
                isLeaf = true;
            }
        }

            if(isLeaf){ //no unvisited neighbors found. return result for self

                sendElectionReply(initiatorId,peer.getId(),initiatorId);
            }


            sendElectionToNeighbor(neighbor, initiatorId, path);


        }

//        responseObserver.onNext(responseObserver);
        responseObserver.onCompleted();
    }

    private void sendElectionReply(int initiatorId, int id, int leaderId) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", initiatorId).usePlaintext().build();
        ElectionServiceReplyGrpc.ElectionServiceReplyBlockingStub stub = ElectionServiceReplyGrpc.newBlockingStub(channel);
        System.out.println("InitiatorId: " + initiatorId + " local leader: " + leaderId);
        stub.sendElectionReply(ElectionRequest.newBuilder()
                .setInitiatorId(initiatorId)
                .build());
        channel.shutdown();

    }


    private void sendElectionToNeighbor(int neighborId, int initiatorId, List<Integer> path) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", neighborId).usePlaintext().build();
        ElectionServiceGrpc.ElectionServiceBlockingStub stub = ElectionServiceGrpc.newBlockingStub(channel);
        System.out.println("InitiatorId: " + initiatorId + " sending lookup to neighbor: " + neighborId);
        stub.electLeader(ElectionRequest.newBuilder()
                .addAllPath(path)
                .setInitiatorId(initiatorId)
                .build());
        channel.shutdown();
    }
}
