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

        if(path.contains(this.peer.getId())){
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
//        System.out.println(this.peer.getId()+" not in "+path);
        int contenderId = request.getContenderId();
        int contenderVoterId = request.getContenderVoterId();

        System.out.println("ContenderId:"+contenderId+" ContenderVoterId:"+contenderVoterId);


        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
//        System.out.println(timeStamp + " \nElection request received at peer " + this.peer.getId());
//        System.out.println("Request Body:"+request);

        if (contenderVoterId > this.peer.getLeaderVoterId()) { // found bully
            this.peer.setLeader(contenderId, contenderVoterId);
        } else { //be the bully
            path = new ArrayList<>(); // Clear path
        }


        path.add(this.peer.getId());
//        System.out.println("New Path:"+path);
        for (int neighbor : this.peer.getNeighbors()) {
            if (!path.contains(neighbor)) {//don't process if already visited at this peer
                reply = sendElectionToNeighbor(neighbor, this.peer.getLeaderId(), this.peer.getLeaderVoterId(), path);

                int electedLocalLeaderId = reply.getContenderId();
                int electedLocalLeaderVoterId = reply.getContenderVoterId();

                if (electedLocalLeaderVoterId > this.peer.getLeaderVoterId()) { // found bully
                    this.peer.setLeader(electedLocalLeaderId, electedLocalLeaderVoterId);
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
//            Collections.reverse(path);
//            int destPort = path.get(path.size() - 1);
//            path.remove(0);

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
        System.out.println("LeaderId: " + contenderId + " sending election to neighbor: " + neighborId);
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
        System.out.println("Current Node" + this.peer.getId() + " local leader: " + this.peer.getId());
        stub.declareResult(ElectionResultDeclaration.newBuilder()
                .setLeaderId(this.peer.getLeaderId())
                .addAllPath(path)
                .build());
        channel.shutdown();
    }
}