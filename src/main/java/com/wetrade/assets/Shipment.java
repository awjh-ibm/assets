package com.wetrade.assets;

import com.wetrade.assets.enums.ShipmentStatus;
import com.wetrade.ledger_api.Asset;
import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;
import com.wetrade.ledger_api.annotations.Private;
import com.wetrade.ledger_api.annotations.VerifyHash;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType
public class Shipment extends Asset {

    @Property
    @Private
    private String purchaseOrderId;

    @Property
    @Private
    private Integer units;

    @Property
    @Private
    private String senderId;

    @Property
    @Private
    private String receiverId;

    @Property
    @Private
    private ShipmentStatus status;

    @VerifyHash
    @Deserialize
    public Shipment(String id, String purchaseOrderId, int units, String senderId, String receiverId, ShipmentStatus status) {
        super(id);

        this.purchaseOrderId = purchaseOrderId;
        this.units = units;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.status = status;
    }

    @DefaultDeserialize
    public Shipment(String id, String hash) {
        super(id, hash);
    }

    public String getPurchaseOrderId() {
        return this.purchaseOrderId;
    }

    public Integer getUnits() {
        return this.units;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public String getReceiverId() {
        return this.receiverId;
    }

    public ShipmentStatus getStatus() {
        return this.status;
    }

    public void setStatus(ShipmentStatus newStatus) {
        if (this.status.compareTo(newStatus) > 0) {
            throw new RuntimeException("Status cannot go backwards");
        }

        this.status = newStatus;
    }
}
