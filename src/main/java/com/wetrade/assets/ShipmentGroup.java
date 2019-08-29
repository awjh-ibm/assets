package com.wetrade.assets;

import com.wetrade.assets.utils.Constants;
import com.wetrade.ledger_api.Asset;
import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;
import com.wetrade.ledger_api.annotations.Private;
import com.wetrade.ledger_api.annotations.VerifyHash;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType
public class ShipmentGroup extends Asset {

    @Property
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    private String[] shipmentIds;

    @VerifyHash
    @Deserialize(collections = Constants.PRIVATE_COLLECTIONS)
    public ShipmentGroup(String id, String[] shipmentIds) {
        super(id);

        this.shipmentIds = shipmentIds;
    }

    @DefaultDeserialize
    public ShipmentGroup(String id, String hash) {
        super(id, hash);
    }

    public String[] getShipmentIds() {
        return this.shipmentIds;
    }

    public void addShipmentId(String id) {
        String[] newShipmentIds = new String[shipmentIds.length + 1];
        System.arraycopy(this.shipmentIds, 0, newShipmentIds, 0, shipmentIds.length);
        newShipmentIds[shipmentIds.length] = id;
        this.shipmentIds = newShipmentIds;
    }
}