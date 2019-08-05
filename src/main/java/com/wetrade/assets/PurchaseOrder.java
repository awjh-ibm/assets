package com.wetrade.assets;

import com.wetrade.assets.utils.Constants;
import com.wetrade.ledger_api.Asset;
import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;
import com.wetrade.ledger_api.annotations.Private;
import com.wetrade.ledger_api.annotations.VerifyHash;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType()
public class PurchaseOrder extends Asset {
    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    String buyerId;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    String sellerId;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    Double price;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    int units;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    String productDescriptor;

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
    private PurchaseOrder(String id, String hash) {
        super(id, hash);
    }
}
