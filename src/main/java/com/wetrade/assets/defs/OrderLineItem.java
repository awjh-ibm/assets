package com.wetrade.assets.defs;

import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType
public class OrderLineItem {

    @Property
    private int lineItemNumber;

    @Property
    private int requestedQuantity;

    @Property
    private double netPrice;

    @Property
    private double netAmount;

    @Property
    private Item transactionalTradeItem;

    public OrderLineItem(int lineItemNumber, int requestedQuantity, double netPrice, int gtin) {
        this.lineItemNumber = lineItemNumber;
        this.requestedQuantity = requestedQuantity;
        this.netPrice = netPrice;
        this.netAmount = netPrice * requestedQuantity;
        this.transactionalTradeItem = new Item(gtin);
    }

    @DefaultDeserialize
    @Deserialize
    public OrderLineItem(int lineItemNumber, int requestedQuantity, double netPrice, Item transactionalTradeItem) {
        this.lineItemNumber = lineItemNumber;
        this.requestedQuantity = requestedQuantity;
        this.netPrice = netPrice;
        this.netAmount = netPrice * requestedQuantity;
        this.transactionalTradeItem = transactionalTradeItem;
    }
}