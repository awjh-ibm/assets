package com.wetrade.assets.defs;

import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType
public class Party {

    @Property
    private int gln;

    @DefaultDeserialize
    @Deserialize
    public Party(int gln) {
        this.gln = gln;
    }

    public int getGln() {
        return this.gln;
    }
}