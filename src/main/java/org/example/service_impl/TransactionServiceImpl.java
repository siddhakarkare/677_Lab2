package org.example.service_impl;

import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.TransactionReply;
import org.example.data_types.TransactionRequest;
import org.example.services.TransactionServiceGrpc;

import java.text.SimpleDateFormat;

public class TransactionServiceImpl extends TransactionServiceGrpc.TransactionServiceImplBase {
    private Peer peer;

    public TransactionServiceImpl(Peer peer) {
        this.peer = peer;
    }

    @Override
    public void transact(TransactionRequest request, StreamObserver<TransactionReply> responseObserver) {
//        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
//        if(peer.getQuantity() > 0) {
//            System.out.println(timeStamp + " >> Selling product " + peer.getProduct() + " to buyer " + request.getBuyerId());
//            peer.decrementQuantity();
//            responseObserver.onNext(TransactionReply.newBuilder().setStatusCode(Boolean.TRUE).build());
//        } else if(peer.getQuantity() == 0) {
//            System.out.println(timeStamp + " >> Can't selling product " + peer.getProduct() + " to buyer " + request.getBuyerId() + " as quantity is not available, resetting seller");
//            peer.reset();
//            responseObserver.onNext(TransactionReply.newBuilder().setStatusCode(Boolean.FALSE).build());
//        }
//
//        responseObserver.onCompleted();
    }
}
