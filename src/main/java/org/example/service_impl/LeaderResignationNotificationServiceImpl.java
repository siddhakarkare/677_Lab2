package org.example.service_impl;

import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.LeaderResignationNotification;
import org.example.services.LeaderResignationNotificationServiceGrpc;
import com.google.protobuf.Empty;
import java.text.SimpleDateFormat;

public class LeaderResignationNotificationServiceImpl extends LeaderResignationNotificationServiceGrpc.LeaderResignationNotificationServiceImplBase {
    private Peer peer;

    public LeaderResignationNotificationServiceImpl(Peer peer) {
        this.peer = peer;
    }

    @Override
    public void resignLeader(LeaderResignationNotification request, StreamObserver<Empty> responseObserver) {
        //Current peer resigns as the leader
        long clock = request.getClock();
        this.peer.updateClock(clock);

        System.out.println(getTimeStamp()+ " >> Leader has resigned, setting leaderId value to -1 till new leader is not elected: " + request);
        peer.setLeaderId(-1);

        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    private static String getTimeStamp(){
        String timestamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss.SSS").format(new java.util.Date());
        return "["+timestamp+"] ";
    }
}
