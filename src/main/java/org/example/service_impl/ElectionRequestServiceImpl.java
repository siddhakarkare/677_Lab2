package org.example.service_impl;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.ElectionReply;
import org.example.data_types.ElectionRequest;
import org.example.data_types.ElectionResultDeclaration;
import org.example.services.ElectionRequestServiceGrpc;
import org.example.services.ElectionResultServiceGrpc;

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
        ElectionReply reply;

        List<Integer> path = new ArrayList<>(request.getPathList());

        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
        System.out.println(timeStamp + " \nElection request received at peer " + this.peer.getId() + ":\n" + request);

        if( contenderVoterId > this.peer.getLeaderVoterId()){ // found bully
            this.peer.setLeader(contenderId,contenderVoterId);
            path = new ArrayList<>(Arrays.asList()); // Clear path
        }


        path.add( this.peer.getId() );
//        boolean isLeaf = false;

        for (int neighbor : this.peer.getNeighbors()) {
            if(!path.contains(neighbor)) {//don't process if already visited at this peer
                reply = sendElectionToNeighbor(neighbor, this.peer.getLeaderId(), this.peer.getLeaderVoterId(), path);

                int electedLocalLeaderId = reply.getContenderId();
                int electedLocalLeaderVoterId = reply.getContenderVoterId();

                if( electedLocalLeaderVoterId > this.peer.getLeaderVoterId()) { // found bully
                    this.peer.setLeader(electedLocalLeaderId, electedLocalLeaderVoterId);
                }

//                isLeaf = true;
            }
        }


        if( this.peer.getLeaderId() == this.peer.getId()){ //new leader found
            //Send I won Message to network
            path = new ArrayList<>(this.peer.getId());
            for (int neighbor : peer.getNeighbors()) {
                declareResult(neighbor,path);
            }
            reply = null;
        }
        else {
            Collections.reverse(path);
            int destPort = path.get(path.size() - 1);
            path.remove(0);

            reply = ElectionReply.newBuilder()
                    .setContenderId(this.peer.getLeaderId()) //contender who is now the local winner (might change if a bully found on the way back)
                    .setContenderVoterId(this.peer.getLeaderVoterId())
                    .addAllPath(path)
                    .setChildId(this.peer.getId()) //so that parent can track who all replied to the election
                    .build();
        }

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
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

    private void declareResult(int neighborId, List<Integer> path){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", neighborId).usePlaintext().build();
        ElectionResultServiceGrpc.ElectionResultServiceBlockingStub stub = ElectionResultServiceGrpc.newBlockingStub(channel);
        System.out.println("Current Node" +this.peer.getId() + " local leader: " + this.peer.getId());
        stub.declareResult(ElectionResultDeclaration.newBuilder()
                        .setLeaderId(this.peer.getLeaderId())
                .addAllPath(path)
                .build());
        channel.shutdown();
    }

//    private void sendElectionReply(int contenderId, int contenderVoterId, List<Integer> path) {
//
//        Collections.reverse(path);
//        int destPort = path.get(0);
//        path.remove(0);
//
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", destPort).usePlaintext().build();
//        ElectionServiceReplyGrpc.ElectionServiceReplyBlockingStub stub = ElectionServiceReplyGrpc.newBlockingStub(channel);
//        System.out.println("Current Node" +this.peer.getId() + " local leader: " + contenderId);
//        stub.sendElectionReply(ElectionReply.newBuilder()
//                .setContenderId(contenderId) //contender who is now the local winner (might change if a bully found on the way back)
//                .setContenderVoterId(contenderVoterId)
//                .addAllPath(path)
//                .setChildId(this.peer.getId()) //so that parent can track who all replied to the election
//
//                .build());
//        channel.shutdown();
//
//    }
}



// Siddharth:
    // Complete transaction service
    // Notify Service
    // Write to file
    // Leader resignation

//Siddha:
    // Leader Election initiation
    // Result Declaration