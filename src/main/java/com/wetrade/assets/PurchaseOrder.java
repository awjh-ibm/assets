package com.wetrade.assets;

import com.wetrade.ledger_api.Asset;

public abstract class PurchaseOrder extends Asset {

    private String buyerId;

    private String sellerId;

    private Double price;

    private Integer units;

    private String productDescriptor;

    public PurchaseOrder(String id, String buyerId, String sellerId, Double price, int units, String productDescriptor){
        super(id);

        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.price = price;
        this.units = units;
        this.productDescriptor = productDescriptor;
    }

    public PurchaseOrder(String id, String hash) {
        super(id, hash);
    }

    public String getBuyerId() {
        return this.buyerId;
    }

    public String getSellerId() {
        return this.sellerId;
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getUnits() {
        return this.units;
    }

    public String getProductDescriptor() {
        return this.productDescriptor;
    }
}
