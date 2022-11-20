package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Peer {
    private int leaderTransactions = 0;
    private static final HashSet<Boolean> ROLES = new HashSet<>((Arrays.asList(true, false)));
    private static final HashSet<String> PRODUCTS = new HashSet<>((Arrays.asList("fish", "boar", "salt")));
    private static final Map<String, Integer> priceMap = new HashMap<String, Integer>()
    {{
            put("fish", 10);
            put("boar", 10);
            put("salt", 10);
    }};

    private Map<String, Integer> leaderMap = new HashMap<String, Integer>()
    {{
        put("id", -1);
        put("voterId", -1);
    }};

    private static final int MAX_QUANTITY = 100;
    private final int peerId;
    private int voterId = 0;
    private final int port;
    private List<Integer> neighbors;
    private boolean buyerRole;
    private String buyerProduct;
    private int buyerQuantity = MAX_QUANTITY;
    private boolean sellerRole;
    private String sellerProduct;
    private int sellerQuantity = MAX_QUANTITY;
    private int sellerPrice = 0;
    private long request_id = 1;
    private static int ctr = 0;

    private int replyCtr = 0;
    // schema: peerId, seller_prod, seller_qty, seller_price
    Map<Integer, List<String>> sellerStockRecord;

    public Peer(int port, List<Integer> neighbors) {
        this.peerId = port;
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

        this.voterId = getNextCount();
        //set leaderid and leadervoteid
    }

    public void reset(int code) {
        leaderTransactions = 0;
        if(isLeader()) {
            // write the records to the file
            writeSellerStocktoFile(sellerStockRecord, "leader.properties");
            // remove the leader thing and reset the whole peer
            code = 2;
        }
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
        return peerId;
    }

    public List<Integer> getNeighbors() {
        return neighbors;
    }

    public String getSellerProduct() {
        return this.sellerProduct;
    }

    public int getSellerQuantity() {
        return this.sellerQuantity;
    }

    public int getSellerPrice() {
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

    public void setVoterId(int voterId){
        this.voterId = voterId;
    }

    public int getVoterId(){
        return this.voterId;
    }
    private Boolean getRandomRoleFromSet(HashSet<Boolean> elements) {
        return elements.stream().skip(new Random().nextInt(elements.size())).findFirst().get();
    }

    private String getRandomProdFromSet(HashSet<String> elements) {
        return elements.stream().skip(new Random().nextInt(elements.size())).findFirst().get();
    }

    private int getRandomQty(){
        return new Random().nextInt(MAX_QUANTITY);
    }

    private int getProductPrice(){
        return priceMap.get(this.getSellerProduct());
    }

    private static int getNextCount(){
        return ctr ++ ; // return and then increment
    }

    // set this peer as the leader => this peer will perform all transactions moving forward
    public void assignLeadership() {
        this.buyerRole = false;
        this.sellerRole = false;

        // load the table written by the previous leader from the file
        sellerStockRecord = readSellerStockFromFile("leader.properties");
    }

    public Boolean isLeader() {
        return !isSeller() & !isBuyer();
    }

    public Map<Integer, List<String>> getSellerStockRecord() {
        return this.sellerStockRecord;
    }

    public void setSellerStockRecord(Map<Integer, List<String>> stock) {
        this.sellerStockRecord = stock;
    }

    public static Map<Integer, List<String>> readSellerStockFromFile(String path) {
        Properties prop = new Properties();
        Map<Integer, List<String>> map = new HashMap<>();
        try (FileInputStream inputStream = new FileInputStream(path)) {
            prop.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not load the leader properties file at: " + path + "\nError message: " + e.getMessage());
        }
        for (final Map.Entry<Object, Object> entry : prop.entrySet()) {
            String propValue = (String) entry.getValue();
            map.put((Integer) entry.getKey(), Arrays.asList(propValue.split("::")));
        }
        return map;
    }

    public static void writeSellerStocktoFile(Map<Integer, List<String>> sellerStockRecord, String path) {
        Map<Integer, String> prop = new HashMap<>();
        for (final Map.Entry<Integer, List<String>> entry : sellerStockRecord.entrySet()) {
            List<String> propValue = entry.getValue();
            String newValue = String.join("::", propValue);
            prop.put(entry.getKey(), newValue);
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(path));
            oos.writeObject(prop);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not write the updated leader properties file at: " + path + "\nError message: " + e.getMessage());
        }
    }

    public void setLeader(int leaderId, int voterId) {
        this.leaderMap.put("id", leaderId);
        this.leaderMap.put("voterId", voterId);
    }

    public int getLeaderId() {
        return this.leaderMap.get("id");
    }

    public int setLeaderId(int id) {
        return this.leaderMap.put("id", id);
    }

    public int getLeaderVoterId() {
        return this.leaderMap.get("voterId");
    }

    public void incrementTransactions() {
        this.leaderTransactions++;
    }

    public int getLeaderTransactionCount() {
        return this.leaderTransactions;
    }
}
