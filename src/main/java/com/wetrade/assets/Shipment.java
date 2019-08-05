package com.wetrade.assets;

import com.wetrade.assets.utils.Constants;
import com.wetrade.ledger_api.Asset;
import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;
import com.wetrade.ledger_api.annotations.Private;
import com.wetrade.ledger_api.annotations.VerifyHash;

import org.hyperledger.fabric.contract.annotation.Property;

public class Shipment extends Asset {
    @Property
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    String purchaseOrderId;

    @Property
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    int units;

    @VerifyHash
    @Deserialize(collections = Constants.PRIVATE_COLLECTIONS)
    public Shipment(String id, String purchaseOrderId, int units) {
        super(id);

        this.purchaseOrderId = purchaseOrderId;
        this.units = units;
    }

    @DefaultDeserialize
    public Shipment(String id, String hash) {
        super(id, hash);
    }
}