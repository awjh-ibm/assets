package com.wetrade.assets;

import com.wetrade.ledger_api.Asset;
import com.wetrade.ledger_api.annotations.DefaultDeserialize;
import com.wetrade.ledger_api.annotations.Deserialize;
import com.wetrade.ledger_api.annotations.Private;
import com.wetrade.ledger_api.annotations.VerifyHash;
import com.wetrade.assets.utils.Constants;

import org.hyperledger.fabric.contract.annotation.Property;

public class FinanceRequestGroup extends Asset {

    @Property
    @Private(collections = Constants.PRIVATE_COLLECTIONS)
    private String[] requestIds;

    @VerifyHash
    @Deserialize(collections = Constants.PRIVATE_COLLECTIONS)
    public FinanceRequestGroup(String id, String[] requestIds) {
        super(id);

        this.requestIds = requestIds;
    }

    @DefaultDeserialize
    public FinanceRequestGroup(String id, String hash) {
        super(id, hash);
    }

    public String[] getRequestIds() {
        return this.requestIds;
    }
}