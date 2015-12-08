package org.npc.models.repositories;

import java.sql.SQLException;
import org.npc.dataaccess.repository.BaseRepository;
import org.npc.dataaccess.repository.DatabaseTable;
import org.npc.dataaccess.repository.helpers.SQLComparisonType;
import org.npc.dataaccess.repository.helpers.where.WhereClause;
import org.npc.dataaccess.repository.helpers.where.WhereContainer;
import org.npc.models.TransactionEntry;
import org.npc.models.fieldnames.TransactionEntryFieldNames;
import org.npc.models.repositories.interfaces.TransactionEntryRepositoryInterface;
import java.util.UUID;

public class TransactionEntryRepository extends BaseRepository<TransactionEntry> implements TransactionEntryRepositoryInterface {
	public TransactionEntry byRecordId(UUID recordId) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					table(this.primaryTable).
					fieldName(TransactionEntryFieldNames.ID).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, recordId);
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
	
	public TransactionEntry byTransactionId(UUID transactionId) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					table(this.primaryTable).
					fieldName(TransactionEntryFieldNames.TRANSACTIONID).
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
	
	public TransactionEntry byProductId(UUID productId) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					table(this.primaryTable).
					fieldName(TransactionEntryFieldNames.PRODUCTID).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, productId);
				} catch (SQLException e) {}

				return ps;
			}
		);
	}

	@Override
	public TransactionEntry createOne() {
		return new TransactionEntry();
	}
	
	public TransactionEntryRepository() {
		super(DatabaseTable.TRANSACTIONENTRY);
	}
}