package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;
import edu.uark.models.enums.TransactionType;
import edu.uark.models.repositories.TransactionRepository;

public class TransactionEntity extends BaseEntity <TransactionEntity> {



	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		this.cashierId = rs.getString(TransactionFieldNames.CASHIER_ID);
		this.referenceId = ((UUID)rs.getObject(TransactionFieldNames.REFERENCE_ID));
		this.totalAmount = rs.getInt(TransactionFieldNames.TOTAL_AMOUNT);
		this.transactionType = TransactionType.map(rs.getInt(TransactionFieldNames.TRANSACTION_TYPE));
		this.createdOn = rs.getTimestamp(EmployeeFieldNames.CREATED_ON).toLocalDateTime();
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		// TODO Auto-generated method stub
		record.put(TransactionFieldNames.CASHIER_ID, this.cashierId);
		record.put(TransactionFieldNames.REFERENCE_ID, this.referenceId);
		record.put(TransactionFieldNames.TOTAL_AMOUNT, this.totalAmount);
		record.put(TransactionFieldNames.TRANSACTION_TYPE , this.transactionType.getValue());
		record.put(EmployeeFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));		
		return record;
	}
	
	public Transaction synchronize(Transaction apiTransaction){
		this.setCashierId(apiTransaction.getCashierId());
		this.setReferenceId(apiTransaction.getReferenceId());
		this.setTotalAmount(apiTransaction.getTotalAmount());
		this.setTransactionType(apiTransaction.getTransactionType());
		return apiTransaction;
	}
	
	public TransactionEntity(){
		super(new TransactionRepository());
		this.cashierId = StringUtils.EMPTY;
		this.referenceId = new UUID(0,0);
		this.totalAmount = 0;
		this.transactionType = TransactionType.NOT_DEFINED;
		this.createdOn = LocalDateTime.now();
	}
	
	public TransactionEntity(UUID id){
	super (id, new TransactionRepository());
	this.cashierId = StringUtils.EMPTY;
	this.referenceId = new UUID(0,0);
	this.totalAmount = 0;
	this.transactionType = TransactionType.NOT_DEFINED;
	this.createdOn = LocalDateTime.now();
	}
	
	public TransactionEntity(Transaction apiTransaction){
		super(apiTransaction.getId(), new TransactionRepository());
		this.cashierId = apiTransaction.getCashierId();
		this.referenceId = apiTransaction.getReferenceId();
		this.totalAmount = apiTransaction.getTotalAmount();
		this.transactionType = apiTransaction.getTransactionType();
		this.createdOn = apiTransaction.getCreateOn();
	}
	
	
	
	
	private String cashierId;
	private UUID referenceId;
	private int totalAmount;
	private TransactionType transactionType;
	private LocalDateTime createdOn;
	
	public String getCashierId() {return this.cashierId;}
	public UUID getReferenceId() {return this.referenceId;}
	public int getTotalAmount(){return this.totalAmount;}
	public TransactionType getTransactionType(){return this.transactionType;}
	public LocalDateTime getCreateOn(){return this.createdOn;}
	
	public TransactionEntity setCashierId(String cashierId) {
		this.cashierId = cashierId;
		return this;
		}
	public TransactionEntity setReferenceId(UUID referienceId) {
		this.referenceId = referienceId;
		return this;
		}
	public TransactionEntity setTotalAmount(int totalAmount){
		this.totalAmount = totalAmount;
		return this;
		}
	public TransactionEntity setTransactionType(TransactionType transactionType){
		this.transactionType = transactionType;
		return this;
		}

	
}
