package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.enums.TransactionType;

public class Transaction {

	public Transaction(){
		this.id = new UUID (0,0);
		this.cashierId = StringUtils.EMPTY;
		this.referenceId = new UUID (0,0);
		this.totalAmount = 0;
		this.transactionType = TransactionType.NOT_DEFINED;
	}
	
public Transaction(TransactionEntity transactionEntity){
	this.id = transactionEntity.getId();
	this.cashierId = transactionEntity.getCashierId();
	this.referenceId = transactionEntity.getReferenceId();
	this.totalAmount = transactionEntity.getTotalAmount();
	this.transactionType = transactionEntity.getTransactionType();
}
	
	
	
	
	private UUID id;
	private String cashierId;
	private UUID referenceId;
	private int totalAmount;
	private TransactionType transactionType;
	private LocalDateTime createdOn;
	
	
	public UUID getId() { return this.id;}
	public String getCashierId() {return this.cashierId;}
	public UUID getReferenceId() {return this.referenceId;}
	public int getTotalAmount(){return this.totalAmount;}
	public TransactionType getTransactionType(){return this.transactionType;}
	public LocalDateTime getCreateOn(){return this.createdOn;}
	
	public Transaction setId( UUID id ) { 
		this.id = id;
		return this;
		}
	public Transaction setCashierId(String cashierId) {
		this.cashierId = cashierId;
		return this;
		}
	public Transaction setReferenceId(UUID referenceId) {
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
	public Transaction setCreateOn(LocalDateTime createdOn){
		this.createdOn = createdOn;
		return this;
		}
}
