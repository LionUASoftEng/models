package org.npc.models.repositories;

import java.sql.SQLException;

import org.npc.dataaccess.repository.BaseRepository;
import org.npc.dataaccess.repository.DatabaseTable;
import org.npc.dataaccess.repository.helpers.PostgreFunctionType;
import org.npc.dataaccess.repository.helpers.SQLComparisonType;
import org.npc.dataaccess.repository.helpers.where.WhereClause;
import org.npc.dataaccess.repository.helpers.where.WhereContainer;
import org.npc.models.Product;
import org.npc.models.fieldnames.ProductFieldNames;
import org.npc.models.repositories.interfaces.ProductRepositoryInterface;

public class ProductRepository extends BaseRepository<Product> implements ProductRepositoryInterface {
	@Override
	public Product byItemLookupCode(String itemlookupCode) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					postgreFunction(PostgreFunctionType.LOWER).
					table(this.primaryTable).
					fieldName(ProductFieldNames.ITEM_LOOKUP_CODE).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, itemlookupCode.toLowerCase());
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
	
	@Override
	public Product createOne() {
		return new Product();
	}
	
	public ProductRepository() {
		super(DatabaseTable.PRODUCT);
	}
}