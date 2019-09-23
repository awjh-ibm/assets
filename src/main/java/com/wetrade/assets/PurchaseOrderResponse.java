package com.wetrade.assets;

import com.wetrade.assets.defs.Identification;
import com.wetrade.assets.defs.OrderIdentification;
import com.wetrade.assets.defs.Party;
import com.wetrade.assets.enums.ResponseStatusCode;
import com.wetrade.ledger_api.Asset;
import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType
public class PurchaseOrderResponse extends Asset {

    @Property
    private OrderIdentification orderResponseIdentification;

    @Property
    private ResponseStatusCode responseStatusCode;

    @Property
    private Party buyer;

    @Property
    private Identification originalOrder;

    public PurchaseOrderResponse(String id, int contentOwnerGln, ResponseStatusCode responseStatusCode, int buyerGln, String originalOrderId) {
        super(id);
        
        this.orderResponseIdentification = new OrderIdentification(id, contentOwnerGln);
        this.responseStatusCode = responseStatusCode;
        this.buyer = new Party(buyerGln);
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
}