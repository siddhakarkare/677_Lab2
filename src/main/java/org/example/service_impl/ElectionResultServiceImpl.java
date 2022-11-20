package org.example.service_impl;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.*;
import org.example.services.ElectionResultServiceGrpc;

import java.util.ArrayList;
import java.util.List;

public class ElectionResultServiceImpl extends ElectionResultServiceGrpc.ElectionResultServiceImplBase {
    private Peer peer;

    public ElectionResultServiceImpl(Peer peer) {
        this.peer = peer;
    }

    @Override
    public void declareResult(ElectionResultDeclaration request, StreamObserver<Empty> responseObserver) {


        List<Integer> path = new ArrayList<>(request.getPathList());
        if(path.contains(this.peer.getId())){
            responseObserver.onNext(Empty.getDefaultInstance());
            responseObserver.onCompleted();
            return;
        }
        int leaderId = request.getLeaderId();

        System.out.println("At peer"+this.peer.getId()+"Declaring leader:"+leaderId);
        int leaderVoterId = request.getLeaderVoterId();

        if( leaderVoterId > this.peer.getLeaderVoterId() ) { //declare further only if bullier found
            this.peer.setLeader(leaderId,leaderVoterId);
            for (int neighbor : this.peer.getNeighbors()) {
                if (!path.contains(neighbor)) {//don't process if already visited at this peer
                    path.add(neighbor);
                    propagateResult(neighbor, this.peer.getLeaderId(), this.peer.getLeaderVoterId(), path);
                }
            }
        }

        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    private void propagateResult(int destPort, int leaderId, int leaderVoterId, List<Integer> path){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", destPort).usePlaintext().build();
        ElectionResultServiceGrpc.ElectionResultServiceBlockingStub stub = ElectionResultServiceGrpc.newBlockingStub(channel);
        System.out.println("Current Node" +this.peer.getId() + " local leader: " + this.peer.getLeaderId());
        stub.declareResult(ElectionResultDeclaration.newBuilder()
                .setLeaderId(this.peer.getLeaderId())
                .addAllPath(path)
                        .setLeaderVoterId(this.peer.getLeaderVoterId())
                .build());
        channel.shutdown();
    }
}
