package com.wetrade.assets.defs;

import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;
import com.wetrade.ledger_api.annotations.OptionalParam;
import com.wetrade.ledger_api.states.Concept;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType
public class Party extends Concept {

    @Property
    private long gln;

    @Property
    private String additionalPartyIdentification;

    public Party() {}

    public Party(long gln) {
        this.gln = gln;
    }

    @DefaultDeserialize
    public Party(long gln, @OptionalParam String additionalPartyIdentification) {
        this.gln = gln;
        this.additionalPartyIdentification = additionalPartyIdentification;
    }

    public long getGln() {
        return this.gln;
    }

    public String getAdditionalPartyIdentification() {
        return this.additionalPartyIdentification;
    }
}