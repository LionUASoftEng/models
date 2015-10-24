package org.npc.models.repositories;

import java.sql.SQLException;
import java.util.UUID;

import org.npc.dataaccess.repository.BaseRepository;
import org.npc.dataaccess.repository.DatabaseTable;
import org.npc.dataaccess.repository.helpers.PostgreFunctionType;
import org.npc.dataaccess.repository.helpers.SQLComparisonType;
import org.npc.dataaccess.repository.helpers.where.WhereClause;
import org.npc.dataaccess.repository.helpers.where.WhereContainer;
import org.npc.models.TenderEntry;
import org.npc.models.fieldnames.TenderEntryFieldNames;
import org.npc.models.repositories.interfaces.TenderEntryRepositoryInterface;

public class TenderEntryRepository extends BaseRepository<TenderEntry> implements TenderEntryRepositoryInterface {
	
	public TenderEntry byTransactionId(UUID transactionId) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					postgreFunction(PostgreFunctionType.LOWER).
					table(this.primaryTable).
					fieldName(TenderEntryFieldNames.TRANSID).
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
	public TenderEntry createOne() {
		return new TenderEntry();
	}
	
	public TenderEntryRepository() {
		super(DatabaseTable.TENDERENTRY);
	}
}