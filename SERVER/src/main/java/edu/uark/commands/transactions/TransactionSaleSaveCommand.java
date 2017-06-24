package edu.uark.commands.transactions;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionSaleSaveCommand implements ResultCommandInterface<Transaction> {

	public Transaction execute(){
		TransactionEntity tranenterEntity = new TransactionEntity(apiTransaction);					
		tranenterEntity.save();
		this.apiTransaction.setId(tranenterEntity.getId());
		return this.apiTransaction;
	}
	
	public TransactionSaleSaveCommand() {
		this.transactionRepository = new TransactionRepository();
	}
	
	// Properties
	private Transaction apiTransaction;
	private TransactionRepositoryInterface transactionRepository;
	
	public Transaction getApiTransaction(){ return this.apiTransaction; }
	public TransactionRepositoryInterface getTransactionRepository(){ return this.transactionRepository;	}
	
	public TransactionSaleSaveCommand setApiTransaction(Transaction apiTransaction){
		this.apiTransaction = apiTransaction;
		return this;
	}
	public TransactionSaleSaveCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository){
		this.transactionRepository = transactionRepository;
		return this;
	}
}
