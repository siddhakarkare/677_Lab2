package org.example.service_impl;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.ElectionReply;
import org.example.data_types.ElectionRequest;
import org.example.services.ElectionReplyServiceGrpc;
import org.example.services.ElectionServiceGrpc;
import org.example.services.ElectionServiceReplyGrpc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ElectionReplyServiceImpl  extends ElectionReplyServiceGrpc.ElectionReplyServiceImplBase{

    private Peer peer;

    public ElectionReplyServiceImpl(Peer peer) {
        this.peer = peer;
    }

    @Override
    public void sendElectionReply(ElectionReply request, StreamObserver<Empty> responseObserver) {
        int leaderid = request.getLeaderId();

        if(leaderid != this.peer.getId()){
            //found at least one bully
            //1. self.leaderId = max(self.leaderId,leaderId)

        }

        //if response from all neighbors received,

    }


}

