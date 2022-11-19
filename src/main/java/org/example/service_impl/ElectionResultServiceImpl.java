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
        int leaderId = request.getLeaderId();
        int leaderVoterId = request.getLeaderVoterId();

        if( leaderVoterId > this.peer.getLeaderVoterId() ) { //declare further only if bullier found
            for (int neighbor : this.peer.getNeighbors()) {
                if (!path.contains(neighbor)) {//don't process if already visited at this peer
                    path.add(neighbor);
                    propagateResult(neighbor, this.peer.getLeaderId(), this.peer.getLeaderVoterId(), path);
                }
            }
        }
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
