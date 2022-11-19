package org.example;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.service_impl.ElectionRequestServiceImpl;
import org.example.service_impl.ElectionResultServiceImpl;
import org.example.service_impl.TransactionServiceImpl;

import java.io.IOException;
import java.util.*;

import static java.lang.Thread.sleep;

public class Main {
    public static final int N = 6; //Number of peers
    private static final int HOP_COUNT = 3;

    private static int leader = -1; //Leader Id

    private static HashMap<Integer,Integer> portPeerMap;

    private static Peer[] peers;
    private static void electLeaderBully(int initiator){
        //If initiator not supplied select any node randomly to initiate
        if(initiator == -1){
            Random rand = new Random();
            int a = rand.nextInt(6); //pick any of the
        }

        //Initiator sends request to its neighbors to declare self as the new leader and waits for response

//        ArrayList<Integer> neighbors = peers[initiator].getNeighbors();
//        new Thread(() -> {
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            for(int j = 0; j < neighbors.size(); j++) {
//                Peer neigh = peers[portPeerMap.get(neighbors.get(j))];
//                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", neigh.getPort()).usePlaintext().build();
//                LookupServiceGrpc.LookupServiceBlockingStub stub = LookupServiceGrpc.newBlockingStub(channel);
//                System.out.println("Triggering lookup for"+peer.getId());
//                stub.lookup(LookupRequest.newBuilder()
//                        .setBuyerId(peer.getId())
//                        .setProductName(peer.getBuyerProduct())
//                        .setHops(HOP_COUNT)
//                        .setRequestId(peer.getRequestId())
//                        .addPath(peer.getPort())
//                        .build());
//
//                channel.shutdown();
//            }
//
//        }).start();
        //current node send request to its neighbors
    }





    public static void main(String[] args) {
        Boolean seller = false, buyer = false;
        Integer[] ports = new Integer[]{8999,8998,8997,8996,8995,8994,8993,8992}; //makes sure at least N ports are present here
        ArrayList<Integer> portList = new ArrayList<>(Arrays.asList(ports));
        Collections.shuffle(portList);

        Random rand = new Random();
        boolean[][] adj = {
                {false,true,true,true,false,false}, //0
                {true,false,false,true,true,false}, //1
                {true,false,false,false,true,true}, //2
                {true,false,false,false,true,true}, //3
                {false,true,true,true,false,false}, //4
                {false,false,true,true,false,false} //5
        };
        HashMap<Integer,Integer> portPeerMap = new HashMap<>();
        peers = new Peer[N];
        for(int i = 0;i < N; i++){ //Create N peers
            int port = portList.get(i);
            portPeerMap.put(port,i);
            boolean[] curr_adj = adj[i];
            ArrayList<Integer> neighbors = new ArrayList<Integer>();
            for(int k =0; k<N; k++){
                if(curr_adj[k])
                    neighbors.add(portList.get(k));
            }

            peers[i] = new Peer(port, neighbors);
            Peer peer = peers[i];

            if(Boolean.FALSE.equals(buyer) && Boolean.FALSE.equals(peer.isBuyer())) { //Ensure at least one buyer
                peer.setBuyerRole(true);
                buyer = true;
            }

            if(Boolean.FALSE.equals(seller) && Boolean.TRUE.equals(peer.isBuyer())) { //Ensure at least one seller
                peer.setSellerRole(true);
                seller = true;
            }

            new Thread(() -> {
                try {
                    Server server = ServerBuilder.forPort(peer.getPort()).addService(new ElectionRequestServiceImpl(peer))
                            .addService(new ElectionResultServiceImpl(peer))
                            .addService(new TransactionServiceImpl(peer))
                            .build();

                    server.start();
                    System.out.println("Server started at " + server.getPort());
                    server.awaitTermination();

                } catch (IOException e) {
                    System.out.println("Error: " + e);
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            }).start();
        }

        System.out.println("Current System:");
        System.out.println("----------------------------- ");
        for(int i = 0; i < N; i++){
            System.out.println("\n Peer:" + i + "\n  Port: " + peers[i].getPort() + "\n  BuyerRole:" + peers[i].isBuyer()
                    + "\n  SellerRole: " + peers[i].isSeller() + "\n  BuyerProduct:" + peers[i].getBuyerProduct() +
                    "\n  SellerProduct:" + peers[i].getSellerProduct() + "\n  BuyerQuantity:" + peers[i].getBuyerQuantity()
                    + "\n  SellerQuantity:" + peers[i].getSellerQuantity());
            System.out.print("  Neighbors: ");
            for(int neigh : peers[i].getNeighbors()){
                System.out.print(" "+portPeerMap.get(neigh)+" ");
            }
        }
        System.out.println("\n----------------------------- ");
        for(int i = 0; i < N ; i++) { //Let the trades begin!
            Peer peer = peers[i];
//            if(peer.getBuyerRole() == true) { //initiate first trade
//
//                ArrayList<Integer> neighbors = peers[i].getNeighbors();
//                new Thread(() -> {
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    for(int j = 0; j < neighbors.size(); j++) {
//                        Peer neigh = peers[portPeerMap.get(neighbors.get(j))];
//                        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", neigh.getPort()).usePlaintext().build();
//                        LookupServiceGrpc.LookupServiceBlockingStub stub = LookupServiceGrpc.newBlockingStub(channel);
//                        System.out.println("Triggering lookup for"+peer.getId());
//                        stub.lookup(LookupRequest.newBuilder()
//                                .setBuyerId(peer.getId())
//                                .setProductName(peer.getBuyerProduct())
//                                .setHops(HOP_COUNT)
//                                .setRequestId(peer.getRequestId())
//                                .addPath(peer.getPort())
//                                .build());
//
//                        channel.shutdown();
//                    }
//
//                }).start();
//            }

        }


    }
}