package com.wetrade.assets.defs;

import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType
public class OrderIdentification extends Identification {
    @Property
    private Party contentOwner;

    public OrderIdentification(String entityIdentification, int contentOwnerGln) {
        super(entityIdentification);
        this.contentOwner = new Party(contentOwnerGln);
    }

    @DefaultDeserialize
    @Deserialize
    public OrderIdentification(String entityIdentification, Party contentOwner) {
        super(entityIdentification);
        this.contentOwner = contentOwner;
    }
}