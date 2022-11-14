package org.example;


import com.google.protobuf.Any;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Peer {
    private static final HashSet<Boolean> ROLES = new HashSet<>((Arrays.asList(true, false)));
    private static final HashSet<String> PRODUCTS = new HashSet<>((Arrays.asList("fish", "boar", "salt")));
    private static final int MAX_QUANTITY = 100;
    private final int peer_id;
    private final int port;
    private ArrayList<Integer> neighbors;
    private boolean buyerRole;
    private String buyerProduct;
    private int buyerQuantity = MAX_QUANTITY;

    private boolean sellerRole;
    private String sellerProduct;
    private int sellerQuantity = MAX_QUANTITY;



    private long request_id = 1;

    public Peer(int port, ArrayList<Integer> neighbors) {
        this.peer_id = port;
        this.port = port;
        this.neighbors = neighbors;
        this.buyerRole = getRandomRoleFromSet(ROLES);
        this.buyerProduct = getRandomProdFromSet(PRODUCTS);
        this.buyerQuantity = getRandomQty();

        this.sellerRole = getRandomRoleFromSet(ROLES);
        this.sellerProduct = getRandomProdFromSet(PRODUCTS);
        this.sellerQuantity = getRandomQty();
    }

    public void reset() {
        if( this.buyerQuantity == 0 ) {
            this.buyerProduct = getRandomProdFromSet(PRODUCTS);
            this.buyerQuantity = getRandomQty();
            this.request_id++;
        }else if ( this.sellerQuantity == 0){
            this.sellerProduct = getRandomProdFromSet(PRODUCTS);
            this.sellerQuantity = getRandomQty();
            this.request_id++;
        }
        else{
            System.out.println("***********************************");
            System.out.println("DID NOT RESET!!! HANDLE THIS CASE!!!");
            System.out.println("***********************************");
        }
    }

    public void setBuyerRole(Boolean role) {
        this.buyerRole = role;
    }
    public void setSellerRole(Boolean role) {
        this.sellerRole = role;
    }

    public int getPort() {
        return port;
    }

    public int getId() {
        return peer_id;
    }

    public ArrayList<Integer> getNeighbors() {
        return neighbors;
    }

    public Boolean getSellerRole() {
        return this.buyerRole;
    }

    public String getSellerProduct() {
        return this.buyerProduct;
    }

    public int getSellerQuantity() {
        return this.buyerQuantity;
    }

    public Boolean getBuyerRole() {
        return this.buyerRole;
    }

    public String getBuyerProduct() {
        return this.buyerProduct;
    }

    public int getBuyerQuantity() {
        return this.buyerQuantity;
    }

    public long getRequestId() { return request_id; }

    public void addNeighbor(int neighborId) {
        this.neighbors.add(neighborId);
    }

    public void decrementBuyerQuantity() {
        this.buyerQuantity--;
    }

    public void decrementSellerQuantity() {
        this.sellerQuantity--;
    }

    public Boolean isBuyer() {
        return this.getBuyerRole();
    }

    private Boolean getRandomRoleFromSet(HashSet<Boolean> elements) {
        return elements.stream().skip(new Random().nextInt(elements.size())).findFirst().get();
    }

    private String getRandomProdFromSet(HashSet<String> elements) {
        return elements.stream().skip(new Random().nextInt(elements.size())).findFirst().get();
    }

    private int getRandomQty(){
        return new Random().nextInt(this.MAX_QUANTITY);
    }

}
