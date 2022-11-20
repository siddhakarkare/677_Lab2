package org.example.service_impl;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.ElectionReply;
import org.example.data_types.ElectionRequest;
import org.example.data_types.ElectionResultDeclaration;
import org.example.data_types.LeaderInitializationRequest;
import org.example.services.ElectionRequestServiceGrpc;
import org.example.services.ElectionResultServiceGrpc;
import org.example.services.LeaderInitializationServiceGrpc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ElectionRequestServiceImpl extends ElectionRequestServiceGrpc.ElectionRequestServiceImplBase {

    private Peer peer;

    public ElectionRequestServiceImpl(Peer peer) {
        this.peer = peer;
    }

    @Override
    public void electLeader(ElectionRequest request, StreamObserver<ElectionReply> responseObserver) {
        List<Integer> path = new ArrayList<>(request.getPathList());
        ElectionReply reply = null;
        int contenderId = request.getContenderId();
        int contenderVoterId = request.getContenderVoterId();

        if(path.contains(this.peer.getId()) || (contenderVoterId == this.peer.getLeaderVoterId() && contenderVoterId != this.peer.getVoterId())){
//            System.out.println(this.peer.getId()+","+path+","+contenderVoterId+","+this.peer.getLeaderVoterId());
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
            return;
        }
//        System.out.println(this.peer.getId()+" not in "+path);
//        System.out.println("IsInitiator:"+request.getIsInitiator());


//        System.out.println(this.peer.getId()+"ContenderId:"+contenderId+" ContenderVoterId:"+contenderVoterId);


        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
        if (contenderVoterId > this.peer.getLeaderVoterId()) { // found bully
//            System.out.println(this.peer.getId()+"Found Bully");
            this.peer.setLeader(contenderId, contenderVoterId);
            path.add(this.peer.getId());
        }
        else {
            //be the bully
//            System.out.println(this.peer.getId()+"Be the bully with voter id"+this.peer.getLeaderVoterId());
//            System.out.println("Bullying over"+contenderVoterId);
            path = new ArrayList<>(); // Clear path
            path.add(this.peer.getId());
        }

        for (int neighbor : this.peer.getNeighbors()) {
            if (!path.contains(neighbor)) {//don't process if already visited at this peer
                reply = sendElectionToNeighbor(neighbor, this.peer.getLeaderId(), this.peer.getLeaderVoterId(), path);
                if(reply != null) {
                    int electedLocalLeaderId = reply.getContenderId();
                    int electedLocalLeaderVoterId = reply.getContenderVoterId();

                    if (electedLocalLeaderVoterId > this.peer.getLeaderVoterId()) { // found bully
//                        System.out.println(this.peer.getId() + "Found bully in reply");
                        this.peer.setLeader(electedLocalLeaderId, electedLocalLeaderVoterId);
                    }
                }
            }
        }


        if (this.peer.getLeaderId() == this.peer.getId()) { //new leader found
            System.out.println("LOCAL LEADER FOUND:"+this.peer.getId());
            //Send I won Message to network
            path = new ArrayList<>(this.peer.getId());
            for (int neighbor : peer.getNeighbors()) {
                declareResult(neighbor, path);
            }
            reply = null;
        } else {
            reply = ElectionReply.newBuilder()
                .setContenderId(this.peer.getLeaderId()) //contender who is now the local winner (might change if a bully found on the way back)
                .setContenderVoterId(this.peer.getLeaderVoterId())
                .addAllPath(path)
                .setChildId(this.peer.getId()) //so that parent can track who all replied to the election
                .build();

            System.out.println("Returning leader:"+this.peer.getLeaderId()+" with voter id:"+this.peer.getLeaderVoterId());
        }
        if (request.getIsInitiator()) { //if this peer initiated the election
            System.out.println("****************Inform new leader to read the file****************");
//            assignTrader(this.peer.getId(), this.peer.getLeaderId());
        }
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    private ElectionReply sendElectionToNeighbor(int neighborId, int contenderId, int contenderVoterId, List<Integer> path) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", neighborId).usePlaintext().build();
        ElectionRequestServiceGrpc.ElectionRequestServiceBlockingStub stub = ElectionRequestServiceGrpc.newBlockingStub(channel);
//        System.out.println("LeaderId: " + contenderId + " sending election to neighbor: " + neighborId);
        ElectionReply reply = stub.electLeader(ElectionRequest.newBuilder()
            .addAllPath(path)
            .setContenderVoterId(contenderVoterId)
            .setContenderId(contenderId)
            .build());
        channel.shutdown();

        return reply;
    }

    private void declareResult(int neighborId, List<Integer> path) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", neighborId).usePlaintext().build();
        ElectionResultServiceGrpc.ElectionResultServiceBlockingStub stub = ElectionResultServiceGrpc.newBlockingStub(channel);
//        System.out.println("Current Node" + this.peer.getId() + " local leader: " + this.peer.getId());
        stub.declareResult(ElectionResultDeclaration.newBuilder()
            .setLeaderId(this.peer.getLeaderId())
            .addAllPath(path)
            .build());
        channel.shutdown();
    }

    private void assignTrader(int initiator, int trader) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", trader).usePlaintext().build();
        LeaderInitializationServiceGrpc.LeaderInitializationServiceBlockingStub stub = LeaderInitializationServiceGrpc.newBlockingStub(channel);
        System.out.println("Initializing new trader: " + trader + ", initiator node is: " + initiator);
        stub.initiateLeader(LeaderInitializationRequest.newBuilder().setInitiatorId(initiator).build());
        channel.shutdown();
    }

}