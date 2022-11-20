package org.example;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.data_types.ElectionRequest;
import org.example.data_types.TransactionRequest;
import org.example.service_impl.*;
import org.example.services.ElectionRequestServiceGrpc;
import org.example.services.TransactionServiceGrpc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Thread.sleep;

public class Main {
    public static final int N = 6; //Number of peers

    private static HashMap<Integer,Integer> portPeerMap;

    private static Peer[] peers;
    private static void electLeaderBully(int initiatorId, int voterId) {
        List<Integer> path = new ArrayList<>(initiatorId);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", initiatorId).usePlaintext().build();
        ElectionRequestServiceGrpc.ElectionRequestServiceBlockingStub stub = ElectionRequestServiceGrpc.newBlockingStub(channel);
        System.out.println("LeaderId: " + initiatorId + " sending lookup to neighbor: " + initiatorId);
        stub.electLeader(ElectionRequest.newBuilder()
                .addAllPath(path)
                        .setIsInitiator(true)
                .setContenderVoterId(voterId)
                .setContenderId(initiatorId)
                .build());
        channel.shutdown();
    }
    public static void main(String[] args) {

        System.out.println(getTimeStamp()+"Starting initialization");
        Boolean seller = false, buyer = false;
        Integer[] ports = new Integer[]{8999,8998,8997,8996,8995,8994,8993,8992}; //makes sure at least N ports are present here
        ArrayList<Integer> portList = new ArrayList<>(Arrays.asList(ports));
        Collections.shuffle(portList);

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

            new Thread(() -> {
                try {
                    Server server = ServerBuilder.forPort(peer.getPort()).addService(new ElectionRequestServiceImpl(peer))
                            .addService(new ElectionRequestServiceImpl(peer))
                            .addService(new LeaderResignationNotificationServiceImpl(peer))
                            .addService(new SellerOutOfStockNotificationImpl(peer))
                            .addService(new ElectionResultServiceImpl(peer))
                            .addService(new TransactionServiceImpl(peer))
                            .addService(new LeaderInitializationServiceImpl(peer))
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
        writeStocksToFile();

        System.out.println(getTimeStamp()+"Network Initialized");

        electLeaderBully( peers[0].getId(), peers[0].getVoterId() );

        System.out.println(getTimeStamp()+"Leader Elected");
        System.out.println("\nCurrent System:");
        System.out.println("----------------------------- ");
        for(int i = 0; i < N; i++){

            String neighStr = "";
            for(int neigh : peers[i].getNeighbors()){
               neighStr += " "+portPeerMap.get(neigh)+" ";
            }
            System.out.println("\n Peer:" + i + "  [ Port: " + peers[i].getPort() + "\t  BuyerRole:" + peers[i].isBuyer()
                    + "\t  SellerRole: " + peers[i].isSeller() + "\t  BuyerProduct:" + peers[i].getBuyerProduct()
                    + "\t  SellerProduct:" + peers[i].getSellerProduct() + "\t  BuyerQuantity:" + peers[i].getBuyerQuantity()
                    + "\t  SellerQuantity:" + peers[i].getSellerQuantity()+"\t Leader:"+peers[i].getLeaderId()+"\t VoterId:"+peers[i].getVoterId()
                    + "\t  Neighbors: {" + neighStr +"} ]");
        }
        System.out.println("\n----------------------------- \n");

        System.out.println(getTimeStamp()+"Starting Trade");
        System.out.println("\n----------------------------- \n");
        for(int i = 0; i < N ; i++) { //Let the trades begin!
            Peer peer = peers[i];

            new Thread(() -> {
                while( true ) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (peer.isBuyer()) { // submit purchase request to the trader
                        System.out.println("Asking Leader:"+peer.getLeaderId());
                        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", peer.getLeaderId()).usePlaintext().build(); //submit request only to leader
                        TransactionServiceGrpc.TransactionServiceBlockingStub stub = TransactionServiceGrpc.newBlockingStub(channel);
                        System.out.println("Triggering transaction by" + peer.getId());
                        stub.transact(TransactionRequest.newBuilder()
                            .setBuyerId(peer.getId())
                            .setProductName(peer.getBuyerProduct())
                            .setQty(peer.getBuyerQuantity())
                            .build());

                        channel.shutdown();

                        peer.reset(0); //Trade complete, reset buyer
                    }
                }

            }).start();
        }
    }

    private static void writeStocksToFile(){
//        peers
        String path = "leader.properties";
        Map<Integer, String> stock = new HashMap<>();
        for ( int i = 0; i<peers.length; i++ ) {
            Peer peer = peers[i];
            int key = peer.getId();
            String value = peer.getSellerProduct()+"::"+peer.getSellerQuantity()+"::"+peer.getSellerPrice();

            stock.put(key,value);
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(path));
            oos.writeObject(stock);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Main.java: Could not write the updated leader properties file at: " + path + "\nError message: " + e.getMessage());
        }
    }
    private static String getTimeStamp(){
        String timestamp = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss.SSS").format(new java.util.Date());
        return "["+timestamp+"] ";
    }
}