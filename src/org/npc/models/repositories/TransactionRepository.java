package org.npc.models.repositories;


import java.sql.SQLException;
import java.util.UUID;

import org.npc.dataaccess.repository.BaseRepository;
import org.npc.dataaccess.repository.DatabaseTable;
import org.npc.dataaccess.repository.helpers.SQLComparisonType;
import org.npc.dataaccess.repository.helpers.where.WhereClause;
import org.npc.dataaccess.repository.helpers.where.WhereContainer;

import org.npc.models.Transaction;
import org.npc.models.fieldnames.TransactionFieldNames;
import org.npc.models.repositories.interfaces.TransactionRepositoryInterface;

public class TransactionRepository extends BaseRepository<Transaction> implements TransactionRepositoryInterface {
	@Override
	public Transaction byTransactionId(UUID transactionId) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					table(this.primaryTable).
					fieldName(TransactionFieldNames.ID).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, transactionId);
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
	
	@Override
	public Transaction byEmployeeId(UUID employeeId) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					table(this.primaryTable).
					fieldName(TransactionFieldNames.ID).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, employeeId);
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
	
	@Override
	public Transaction createOne() {
		return new Transaction();
	}
	
	public TransactionRepository() {
		super(DatabaseTable.TRANSACTION);
	}
}
