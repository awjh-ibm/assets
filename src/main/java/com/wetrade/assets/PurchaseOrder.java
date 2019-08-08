package com.wetrade.assets;

import com.wetrade.assets.utils.Constants;
import com.wetrade.ledger_api.Asset;
import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;
import com.wetrade.ledger_api.annotations.Private;
import com.wetrade.ledger_api.annotations.VerifyHash;

import org.hyperledger.fabric.contract.annotation.Property;

public class PurchaseOrder extends Asset {

    @Property
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    private String buyerId;

    @Property
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    private String sellerId;

    @Property
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    private Double price;

    @Property
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    private Integer units;

    @Property
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    private String productDescriptor;

    @VerifyHash
    @Deserialize(collections = Constants.PRIVATE_COLLECTIONS)
    public PurchaseOrder(String id, String buyerId, String sellerId, Double price, int units, String productDescriptor){
        super(id);

        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.price = price;
        this.units = units;
        this.productDescriptor = productDescriptor;
    }

    @DefaultDeserialize
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
