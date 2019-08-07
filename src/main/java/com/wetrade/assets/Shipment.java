package com.wetrade.assets;

import com.wetrade.ledger_api.Asset;

public abstract class Shipment extends Asset {

    private String purchaseOrderId;

    private Integer units;

    public Shipment(String id, String purchaseOrderId, int units) {
        super(id);

        this.purchaseOrderId = purchaseOrderId;
        this.units = units;
    }

    public Shipment(String id, String hash) {
        super(id, hash);
    }

    public String getPurchaseOrderId() {
        return this.purchaseOrderId;
    }

    public Integer getUnits() {
        return this.units;
    }
}