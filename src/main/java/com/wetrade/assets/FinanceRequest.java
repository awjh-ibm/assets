package com.wetrade.assets;

import java.util.Date;

import com.wetrade.ledger_api.Asset;

public abstract class FinanceRequest extends Asset {
    private String requesterId;

    private String financierId;

    private String purchaseOrderId;

    private Double amount;

    private Double interest;

    private Date completionDate;

    public FinanceRequest(String id, String requesterId, String financierId, String purchaseOrderId, Double amount, Double interest, Date completionDate) {
        super(id);

        this.requesterId = requesterId;
        this.financierId = financierId;
        this.purchaseOrderId = purchaseOrderId;
        this.amount = amount;
        this.interest = interest;
        this.completionDate = completionDate;
    }

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