package edu.uark.uarkregisterapp.models.api;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import edu.uark.uarkregisterapp.models.api.enums.TransactionType;
import edu.uark.uarkregisterapp.models.api.fields.TransactionFieldName;
import edu.uark.uarkregisterapp.models.api.interfaces.ConvertToJsonInterface;
import edu.uark.uarkregisterapp.models.api.interfaces.LoadFromJsonInterface;

/**
 * Created by me or you on 6/25/2017.
 */

public class Transaction implements ConvertToJsonInterface, LoadFromJsonInterface<Transaction> {
    @Override
    public JSONObject convertToJson() {
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put(TransactionFieldName.ID.getFieldName(),this.id.toString());
            jsonObject.put(TransactionFieldName.CASHIER_ID.getFieldName(),this.cashierId);
            jsonObject.put(TransactionFieldName.TOTAL_AMOUNT.getFieldName(),this.totalAmount);
            jsonObject.put(TransactionFieldName.TRANSACTION_TYPE.getFieldName(),this.transactionType);
            jsonObject.put(TransactionFieldName.REFERENCE_ID.getFieldName(),this.referenceId);
            jsonObject.put(TransactionFieldName.CREATED_ON.getFieldName(),this.createdOn);
        }catch(JSONException e){
            e.printStackTrace();
        }
        return jsonObject;
    }
    @Override
    public Transaction loadFromJson(JSONObject rawJsonObject) {
        String value = rawJsonObject.optString(TransactionFieldName.ID.getFieldName());
        if (!StringUtils.isBlank(value)) {
            this.id = UUID.fromString(value);
        }
        this.cashierId = rawJsonObject.optString( TransactionFieldName.CASHIER_ID.getFieldName());
        this.referenceId = rawJsonObject.optString(TransactionFieldName.REFERENCE_ID.getFieldName());
        this.transactionType = TransactionType.mapName(
                rawJsonObject.optString(TransactionFieldName.TRANSACTION_TYPE.getFieldName())
        );
        this.totalAmount = rawJsonObject.optInt( TransactionFieldName.TOTAL_AMOUNT.getFieldName());
        value = rawJsonObject.optString(TransactionFieldName.CREATED_ON.getFieldName()
        );

        if (!StringUtils.isBlank(value)) {
            try {
                this.createdOn = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US).parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return this;
    }

    public Transaction(){
        this.id = new UUID (0,0);
        this.cashierId = StringUtils.EMPTY;
        this.referenceId = StringUtils.EMPTY;
        this.totalAmount = 0;
        this.transactionType = TransactionType.NOT_DEFINED;
    }

    private UUID id;
    private String cashierId;
    private String referenceId;
    private int totalAmount;
    private TransactionType transactionType;
    private Date createdOn;


    public UUID getId() { return this.id;}
    public String getCashierId() {return this.cashierId;}
    public String getReferenceId() {return this.referenceId;}
    public int getTotalAmount(){return this.totalAmount;}
    public TransactionType getTransactionType(){return this.transactionType;}
    public Date getCreatedOn() {
        return this.createdOn;
    }


    public Transaction setId( UUID id ) {
        this.id = id;
        return this;
    }
    public Transaction setCashierId(String cashierId) {
        this.cashierId = cashierId;
        return this;
    }
    public Transaction setReferenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }
    public Transaction setTotalAmount( int totalAmount){
        this.totalAmount = totalAmount;
        return this;
    }
    public Transaction setTransactionType( TransactionType transactionType){
        this.transactionType = transactionType;
        return this;
    }
    public Transaction setCreatedOn(Date createdOn){
     this.createdOn = createdOn;
        return this;
    }

}
