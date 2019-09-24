package com.wetrade.assets;

import com.wetrade.assets.defs.Identification;
import com.wetrade.assets.defs.OrderIdentification;
import com.wetrade.assets.defs.Party;
import com.wetrade.assets.enums.ResponseStatusCode;
import com.wetrade.ledger_api.Asset;
import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;
import com.wetrade.ledger_api.annotations.Private;
import com.wetrade.ledger_api.annotations.VerifyHash;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType
public class PurchaseOrderResponse extends Asset {

    @Property
    @Private
    private OrderIdentification orderResponseIdentification;

    @Property
    @Private
    private ResponseStatusCode responseStatusCode;

    @Property
    @Private
    private Party buyer;

    @Property
    @Private
    private Identification originalOrder;

    @VerifyHash
    public PurchaseOrderResponse(String id, long contentOwnerGln, ResponseStatusCode responseStatusCode, Party buyer, String originalOrderId) {
        super(id);
        
        this.orderResponseIdentification = new OrderIdentification(id, contentOwnerGln);
        this.responseStatusCode = responseStatusCode;
        this.buyer = buyer;
        this.originalOrder = new Identification(originalOrderId);
    }

    @Deserialize
    public PurchaseOrderResponse(OrderIdentification orderResponseIdentification, ResponseStatusCode responseStatusCode, Party buyer, Identification originalOrder) {
        super(orderResponseIdentification.getEntityIdentification());

        this.orderResponseIdentification = orderResponseIdentification;
        this.responseStatusCode = responseStatusCode;
        this.buyer = buyer;
        this.originalOrder = originalOrder;
    }

    @DefaultDeserialize
    public PurchaseOrderResponse(String id, String hash) {
        super(id, hash);
    }

    public OrderIdentification getOrderResponseIdentification() {
        return this.orderResponseIdentification;
    }

    public ResponseStatusCode getResponseStatusCode() {
        return this.responseStatusCode;
    }

    public Party getBuyer() {
        return this.buyer;
    }

    public Identification getOriginalOrder() {
        return this.originalOrder;
    }
}