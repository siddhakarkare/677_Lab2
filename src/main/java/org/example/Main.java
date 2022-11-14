package org.example;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.data_types.LookupRequest;
import org.example.service_impl.LookupServiceImpl;
import org.example.service_impl.ReplyServiceImpl;
import org.example.service_impl.TransactionServiceImpl;
import org.example.services.LookupServiceGrpc;

import java.io.IOException;
import java.util.*;

import static java.lang.Thread.sleep;

public class Main {
    public static final int N = 6; //Number of peers
    private static final int HOP_COUNT = 3;

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
        Peer[] peers = new Peer[N];
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

            if(Boolean.FALSE.equals(buyer) && Boolean.FALSE.equals(peer.isBuyer())) {
                peer.setRole("buyer");
                buyer = true;
            }

            if(Boolean.FALSE.equals(seller) && Boolean.TRUE.equals(peer.isBuyer())) {
                peer.setRole("seller");
                seller = true;
            }

            new Thread(() -> {
                try {
                    Server server = ServerBuilder.forPort(peer.getPort()).addService(new LookupServiceImpl(peer))
                            .addService(new ReplyServiceImpl(peer))
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
            System.out.println("\nPeer:"+i+"\n  Port:"+peers[i].getPort()+"\n  Role:"+peers[i].getRole()+"\n  Product:"+peers[i].getProduct()+"\n  Quantity:"+peers[i].getQuantity());
            System.out.print("  Neighbors: ");
            for(int neigh : peers[i].getNeighbors()){
                System.out.print(" "+portPeerMap.get(neigh)+" ");
            }
        }
        System.out.println("\n----------------------------- ");
        for(int i = 0; i < N ; i++) { //Let the trades begin!
            Peer peer = peers[i];
            if(peer.getRole() == "buyer") { //initiate first trade

                ArrayList<Integer> neighbors = peers[i].getNeighbors();
                new Thread(() -> {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    for(int j = 0; j < neighbors.size(); j++) {
                        Peer neigh = peers[portPeerMap.get(neighbors.get(j))];
                        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", neigh.getPort()).usePlaintext().build();
                        LookupServiceGrpc.LookupServiceBlockingStub stub = LookupServiceGrpc.newBlockingStub(channel);
                        System.out.println("Triggering lookup for"+peer.getId());
                        stub.lookup(LookupRequest.newBuilder()
                                .setBuyerId(peer.getId())
                                .setProductName(peer.getProduct())
                                .setHops(HOP_COUNT)
                                .setRequestId(peer.getRequestId())
                                .addPath(peer.getPort())
                                .build());

                        channel.shutdown();
                    }

                }).start();
            }

        }


    }
}