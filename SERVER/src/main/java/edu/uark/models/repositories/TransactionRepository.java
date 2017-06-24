package edu.uark.models.repositories;

import java.sql.SQLException;
import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionRepository extends BaseRepository<TransactionEntity> implements TransactionRepositoryInterface {



	@Override
	public boolean cashierIdExists(String cashierId) {
		// TODO Auto-generated method stub
		return this.existsWhere(
				new WhereContainer(
						(new WhereClause()).
						table(this.primaryTable).
						fieldName(TransactionFieldNames.CASHIER_ID).
						comparison(SQLComparisonType.EQUALS)
						), 
				(ps) ->{
					try {
						ps.setObject(1, cashierId);
					} catch (SQLException e){}
					return ps;
				}
				);
		
	}

	@Override
	public TransactionEntity createOne() {
		// TODO Auto-generated method stub
		return new TransactionEntity();
	}

	public TransactionRepository() {
		super(DatabaseTable.TRANSACTION);
		// TODO Auto-generated constructor stub
	}
	
	
}
