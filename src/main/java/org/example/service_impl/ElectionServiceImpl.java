package org.example.service_impl;


import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.ElectionReply;
import org.example.data_types.ElectionRequest;
import org.example.services.ElectionServiceGrpc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ElectionServiceImpl extends ElectionServiceGrpc.ElectionServiceImplBase {

    private Peer peer;

    public ElectionServiceImpl(Peer peer) {
        this.peer = peer;
    }

    @Override
    public void electLeader(ElectionRequest request, StreamObserver<ElectionReply> responseObserver) {

        int initiatorId = request.getInitiatorId();
        List<Integer> path = new ArrayList<>(request.getPathList());

        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
        System.out.println(timeStamp + " \nElection request received at peer " + peer.getId() + ":\n" + request);
        if(!path.contains(peer.getId())) { //don't process if already visited at this peer

            if( initiatorId > this.peer.getVoterId() ) {//Tell all the neighbors about the bully
                path.add(peer.getId());

                for (int neighbor : peer.getNeighbors()) {

                    sendElectionToNeighbor(neighbor, initiatorId, path);


                }
            }
            else{
                //Be the Bully
                    //Send response to the initiator to suppress
                    //send election leader message to all my neighbors

            }
        }

//        responseObserver.onNext(responseObserver);
        responseObserver.onCompleted();
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
