package com.wetrade.assets.defs;

import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType
public class Item {

    @Property
    private int gtin;

    @DefaultDeserialize
    @Deserialize
    public Item(int gtin) {
        this.gtin = gtin;
    }

    public int getGtin() {
        return this.gtin;
    }
}