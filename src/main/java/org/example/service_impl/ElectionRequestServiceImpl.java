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

        int contenderId = request.getContenderId();
        int contenderVoterId = request.getContenderVoterId();
        List<Integer> path = new ArrayList<>(request.getPathList());

        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
        System.out.println(timeStamp + " \nElection request received at peer " + peer.getId() + ":\n" + request);

        if( contenderVoterId > this.peer.getLeaderVoterId()){ // found bully
            this.peer.setLeader(contenderId,contenderVoterId);
            path = new ArrayList<>(Arrays.asList()); // Clear path
        }


        path.add( this.peer.getId() );
        boolean isLeaf = false;

        for (int neighbor : peer.getNeighbors()) {
            if(!path.contains(neighbor)) {//don't process if already visited at this peer
                ElectionReply reply = sendElectionToNeighbor(neighbor, this.peer.getLeaderId(), this.peer.getLeaderVoterId(), path);

                int electedLocalLeaderId = reply.getContenderId();
                int electedLocalLeaderVoterId = reply.getContenderVoterId();


                isLeaf = true;
            }
        }

        if( isLeaf ){ //no unvisited neighbors found. return result for self

            sendElectionReply(this.peer.getLeaderId(),this.peer.getLeaderVoterId(),path);
        }
//        responseObserver.onNext(responseObserver);
        responseObserver.onCompleted();
    }

    private void sendElectionReply(int contenderId, int contenderVoterId, List<Integer> path) {

        Collections.reverse(path);
        int destPort = path.get(0);
        path.remove(0);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", destPort).usePlaintext().build();
        ElectionServiceReplyGrpc.ElectionServiceReplyBlockingStub stub = ElectionServiceReplyGrpc.newBlockingStub(channel);
        System.out.println("Current Node" +this.peer.getId() + " local leader: " + contenderId);
        stub.sendElectionReply(ElectionReply.newBuilder()
                .setContenderId(contenderId) //contender who is now the local winner (might change if a bully found on the way back)
                .setContenderVoterId(contenderVoterId)
                .addAllPath(path)
                .setChildId(this.peer.getId()) //so that parent can track who all replied to the election

                .build());
        channel.shutdown();

    }


    private ElectionReply sendElectionToNeighbor(int neighborId, int contenderId, int contenderVoterId, List<Integer> path) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", neighborId).usePlaintext().build();
        ElectionRequestServiceGrpc.ElectionRequestServiceBlockingStub stub = ElectionRequestServiceGrpc.newBlockingStub(channel);
        System.out.println("LeaderId: " + contenderId + " sending lookup to neighbor: " + neighborId);
        ElectionReply reply = stub.electLeader(ElectionRequest.newBuilder()
                .addAllPath(path)
                        .addAllPath(path)
                        .setContenderVoterId(contenderVoterId)
                        .setContenderId(contenderId)
                .build());
        channel.shutdown();

        return reply;
    }
}

// Siddharth:
    // Complete transaction service
    // Notify Service
    // Write to file
    // Leader resignation

//Siddha:
    // Leader Election initiation
    // Result Declaration