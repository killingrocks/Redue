package edu.uark.uarkregisterapp.models.transition;

import android.os.Parcel;
import android.os.Parcelable;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.UUID;

import edu.uark.uarkregisterapp.commands.converters.ByteToUUIDConverterCommand;
import edu.uark.uarkregisterapp.commands.converters.UUIDToByteConverterCommand;

import edu.uark.uarkregisterapp.models.api.Transaction;
import edu.uark.uarkregisterapp.models.api.enums.TransactionType;

/**
 * Created by me or you on 6/27/2017.
 */

public class TransactionTransition implements Parcelable {

    public static final Creator<TransactionTransition> CREATOR = new Creator<TransactionTransition>() {
        @Override
        public TransactionTransition createFromParcel(Parcel transactionTransitionParcel) {
            return new TransactionTransition(transactionTransitionParcel);
        }

        @Override
        public TransactionTransition[] newArray(int size) {return new TransactionTransition[size];}
    };

    @Override
    public int describeContents() {return 0; }
    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeByteArray((new UUIDToByteConverterCommand()).setValueToConvert(this.id).execute());
        destination.writeString(this.cashierId);
        destination.writeString(this.referenceId);
        destination.writeInt(this.totalAmount);
        destination.writeInt(this.transactionType.getValue());

        destination.writeLong(this.createdOn.getTime());
    }

    public TransactionTransition(){
        this.id = new UUID (0,0);
        this.cashierId = StringUtils.EMPTY;
        this.referenceId = StringUtils.EMPTY;
        this.totalAmount = 0;
        this.transactionType = TransactionType.NOT_DEFINED;
        this.createdOn = new Date();
    }

    public TransactionTransition(Transaction transaction){
        this.id = transaction.getId();
        this.cashierId = transaction.getCashierId();
        this.referenceId = transaction.getReferenceId();
        this.transactionType = transaction.getTransactionType();
        this.totalAmount = transaction.getTotalAmount();
        this.createdOn = transaction.getCreatedOn();
    }

    public TransactionTransition (Parcel transactionTransitionParcel){
        this.id = (new ByteToUUIDConverterCommand()).setValueToConvert( transactionTransitionParcel.createByteArray()).execute();
        this.cashierId = transactionTransitionParcel.readString();
        this.transactionType =TransactionType.mapValue(transactionTransitionParcel.readInt());
        this.totalAmount = transactionTransitionParcel.readInt();
        this.referenceId = transactionTransitionParcel.readString();

        this.createdOn = new Date();
        this.createdOn.setTime(transactionTransitionParcel.readLong());
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


    public TransactionTransition setId(UUID id ) {
        this.id = id;
        return this;
    }
    public TransactionTransition setCashierId(String cashierId) {
        this.cashierId = cashierId;
        return this;
    }
    public TransactionTransition setReferenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }
    public TransactionTransition setTotalAmount( int totalAmount){
        this.totalAmount = totalAmount;
        return this;
    }
    public TransactionTransition setTransactionType( TransactionType transactionType){
        this.transactionType = transactionType;
        return this;
    }
    public TransactionTransition setCreatedOn(Date createdOn){
        this.createdOn = createdOn;
        return this;
    }




}
