package com.wetrade.assets;

import java.util.Date;

import com.wetrade.assets.utils.Constants;
import com.wetrade.ledger_api.Asset;
import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;
import com.wetrade.ledger_api.annotations.Private;
import com.wetrade.ledger_api.annotations.VerifyHash;

import org.hyperledger.fabric.contract.annotation.Property;

public class FinanceRequest extends Asset {
    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    String requesterId;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    String financierId;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    String purchaseOrderId;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    Double amount;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    Double interest;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    Date completionDate;

    @VerifyHash
    @Deserialize(collections = Constants.PRIVATE_COLLECTIONS)
    public FinanceRequest(String id, String requesterId, String financierId, String purchaseOrderId, Double amount, Double interest, Date completionDate) {
        super(id);

        this.requesterId = requesterId;
        this.financierId = financierId;
        this.purchaseOrderId = purchaseOrderId;
        this.amount = amount;
        this.interest = interest;
        this.completionDate = completionDate;
    }

    @DefaultDeserialize
    private FinanceRequest(String id, String hash) {
        super(id, hash);
    }
}