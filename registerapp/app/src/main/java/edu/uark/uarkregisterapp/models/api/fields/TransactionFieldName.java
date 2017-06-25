package edu.uark.uarkregisterapp.models.api.fields;

/**
 * Created by me or you on 6/25/2017.
 */

public enum TransactionFieldName {
    ID("id"),
    CASHIER_ID("cashierid"),
    TOTAL_AMOUNT("totalamount"),
    TRANSACTION_TYPE("transactiontype"),
    REFERENCE_ID ("referenceid"),
    CREATED_ON("createdon");

    private String fieldName;
    public String getFieldName() {
        return this.fieldName;
    }
    TransactionFieldName (String fieldName) {
        this.fieldName = fieldName;
    }
}
