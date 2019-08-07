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
    private String requesterId;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    private String financierId;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    private String purchaseOrderId;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    private Double amount;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    private Double interest;

    @Property()
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    private Date completionDate;

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
    public FinanceRequest(String id, String hash) {
        super(id, hash);
    }

    public String getRequesterId() {
        return this.requesterId;
    }

    public String getFinancierId() {
        return this.financierId;
    }

    public String getPurchaseOrderId() {
        return this.purchaseOrderId;
    }

    public Double getAmount() {
        return this.amount;
    }

    public Double getInterest() {
        return this.interest;
    }

    public Date getCompletionDate() {
        return this.completionDate;
    }
}