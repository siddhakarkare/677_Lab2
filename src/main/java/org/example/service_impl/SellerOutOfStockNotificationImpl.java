package org.example.service_impl;

import io.grpc.stub.StreamObserver;
import org.example.Peer;
import org.example.data_types.SellerOutOfStockNotification;
import org.example.data_types.SellerOutOfStockNotificationReply;
import org.example.services.ResetSellerOnOutOfStockGrpc;

import java.text.SimpleDateFormat;

public class SellerOutOfStockNotificationImpl extends ResetSellerOnOutOfStockGrpc.ResetSellerOnOutOfStockImplBase {
    private Peer peer;

    public SellerOutOfStockNotificationImpl(Peer peer) {
        this.peer = peer;
    }

    @Override
    public void resetSeller(SellerOutOfStockNotification request, StreamObserver<SellerOutOfStockNotificationReply> responseObserver) {
        long clock = request.getClock();
        this.peer.updateClock(clock);

        String timeStamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss").format(new java.util.Date());
        System.out.println(timeStamp + " >> Resetting seller with seller id " + peer.getId());
        peer.reset(1);
        SellerOutOfStockNotificationReply reply = SellerOutOfStockNotificationReply.newBuilder()
                .setSellerId(peer.getId())
                .setProductName(peer.getSellerProduct())
                .setPrice(peer.getSellerPrice())
                .setQty(peer.getSellerQuantity())
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
