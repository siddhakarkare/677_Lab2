package org.example;

import java.util.*;

public class Peer {
    private static final HashSet<Boolean> ROLES = new HashSet<>((Arrays.asList(true, false)));
    private static final HashSet<String> PRODUCTS = new HashSet<>((Arrays.asList("fish", "boar", "salt")));
    private static final Map<String, Integer> priceMap = new HashMap<String, Integer>()
    {{
            put("fish", 10);
            put("boar", 10);
            put("salt", 10);
    }};
    private static final int MAX_QUANTITY = 100;
    private final int peer_id;
    private int voter_id = 0;
    private final int port;
    private ArrayList<Integer> neighbors;
    private boolean buyerRole;
    private String buyerProduct;
    private int buyerQuantity = MAX_QUANTITY;
    private boolean sellerRole;
    private String sellerProduct;
    private int sellerQuantity = MAX_QUANTITY;
    private double sellerPrice = 0;
    private long request_id = 1;
    private static int ctr = 0;

    public Peer(int port, ArrayList<Integer> neighbors) {
        this.peer_id = port;
        this.port = port;
        this.neighbors = neighbors;

        this.buyerRole = getRandomRoleFromSet(ROLES);
        if(this.isBuyer()) {
            this.buyerProduct = getRandomProdFromSet(PRODUCTS);
            this.buyerQuantity = getRandomQty();
            this.sellerRole = getRandomRoleFromSet(ROLES);
        }
        else {
            this.sellerRole = true;
        }
        if(this.isSeller()) {
            this.sellerProduct = getRandomProdFromSet(PRODUCTS);
            this.sellerQuantity = getRandomQty();
            this.sellerPrice = getProductPrice();
        }

        this.voter_id = getNextCount();
    }

    public void reset(int code) {
        if(code == 0) {
            // reset only the buyer part of the peer
            this.buyerProduct = getRandomProdFromSet(PRODUCTS);
            this.buyerQuantity = getRandomQty();
        } else if (code == 1) {
            // reset only the seller part of the peer
            this.sellerProduct = getRandomProdFromSet(PRODUCTS);
            this.sellerQuantity = getRandomQty();
            this.sellerPrice = getProductPrice();
        }
        else{
            // reset the whole thing
            this.buyerRole = getRandomRoleFromSet(ROLES);
            if(this.isBuyer()) {
                this.buyerProduct = getRandomProdFromSet(PRODUCTS);
                this.buyerQuantity = getRandomQty();
                this.sellerRole = getRandomRoleFromSet(ROLES);
            }
            else {
                this.sellerRole = true;
            }
            if(this.isSeller()) {
                this.sellerProduct = getRandomProdFromSet(PRODUCTS);
                this.sellerQuantity = getRandomQty();
                this.sellerPrice = getProductPrice();
            }
        }
    }

    public void setBuyerRole(Boolean role) {
        this.buyerRole = role;
    }

    public void setSellerRole(Boolean role) {
        this.sellerRole = role;
    }

    public boolean isBuyer() {
        return this.buyerRole;
    }

    public boolean isSeller() {
        return this.sellerRole;
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

    public String getSellerProduct() {
        return this.sellerProduct;
    }

    public int getSellerQuantity() {
        return this.sellerQuantity;
    }

    public double getSellerPrice() {
        return this.sellerPrice;
    }

    public String getBuyerProduct() {
        return this.buyerProduct;
    }

    public int getBuyerQuantity() {
        return this.buyerQuantity;
    }

    public long getRequestId() {
        return request_id;
    }

    public void addNeighbor(int neighborId) {
        this.neighbors.add(neighborId);
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

    private double getProductPrice(){
        return priceMap.get(this.getSellerProduct());
    }

    private int getNextCount(){
        return this.ctr ++ ; // return and then increment
    }
}
