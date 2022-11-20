package org.example.service_impl;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.LeaderInitializationRequest;
import org.example.services.LeaderInitializationServiceGrpc;

import java.text.SimpleDateFormat;

public class LeaderInitializationServiceImpl extends LeaderInitializationServiceGrpc.LeaderInitializationServiceImplBase {
    private Peer peer;

    public LeaderInitializationServiceImpl(Peer peer) {
        this.peer = peer;
    }

    @Override
    public void initiateLeader(LeaderInitializationRequest request, StreamObserver<Empty> responseObserver) {
        long clock = request.getClock();
        this.peer.updateClock(clock);

        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
        System.out.println(timeStamp + " >> Assigning new leader with ID: " + peer.getId());
        peer.assignLeadership();

        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
