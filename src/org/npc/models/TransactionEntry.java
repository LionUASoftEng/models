package org.npc.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.npc.dataaccess.model.BaseModel;
import org.npc.models.fieldnames.TransactionEntryFieldNames;
import org.npc.models.repositories.TransactionEntryRepository;

public class TransactionEntry extends BaseModel<TransactionEntry>
{
	private UUID recordId;
	private UUID transactionId;
	private UUID productId;
	private float price;
	private int quantity;
	
	
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException 
	{
		this.recordId = rs.getUUID(TransactionEntryFieldNames.RECORD_ID);
		this.transactionId = rs.getUUID(TransactionEntryFieldNames.TRANSACTION_ID);
		this.productId = rs.getUUID(TransactionEntryFieldNames.PRODUCT_ID);
		this.price = rs.getFloat(TransactionEntryFieldNames.PRICE);
		this.quantity = rs.getInteger(TransactionEntryFieldNames.QUANTITY);
	}

	
	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) 
	{
		record.put(TransactionEntryFieldNames.RECORD_ID, this.recordId);
		record.put(TransactionEntryFieldNames.TRANSACTION_ID, this.transactionId);
		record.put(TransactionEntryFieldNames.PRODUCT_ID, this.productId);
		record.put(TransactionEntryFieldNames.PRICE, this.price);
		record.put(TransactionEntryFieldNames.QUANTITY, this.quantity);
		
		return record;
	}

	public UUID getRecordId() 
	{
		return this.recordId;
	}
	public TransactionEntry setRecordId(UUID recordId) 
	{
		//if (!StringUtils.equals(this.firstName, firstName)) {
			this.recordId = recordId;
			this.propertyChanged(TransactionEntryFieldNames.RECORD_ID);
		//}		
		return this;
	}

	
	public UUID getTransactionId() 
	{
		return this.transactionId;
	}
	public TransactionEntry setTransactionId(UUID transactionId) 
	{
		//if (!StringUtils.equals(this.lastName, lastName)) {
			this.transactionId = transactionId;
			this.propertyChanged(TransactionEntryFieldNames.TRANSACTION_ID);
		//}		
		return this;
	}


	public UUID getProductId() 
	{
		return this.productId;
	}
	public TransactionEntry setProductId(UUID productId) 
	{
		//if (!StringUtils.equals(this.employeeId, string)) {
			this.productId = productId;
			this.propertyChanged(TransactionEntryFieldNames.PRODUCT_ID);
		//}		
		return this;
	}
	
	

	public float getPrice() 
	{
		return this.price;
	}
	public TransactionEntry setPrice(float price) 
	{
		//if (!StringUtils.equals(this.employeeId, string)) {
		this.price = price;
		this.propertyChanged(TransactionEntryFieldNames.PRICE);
		//}		
		return this;
	}
	

	public int getQuantity() 
	{
		return this.quantity;
	}
	public TransactionEntry setQuantity(int quantity) 
	{
		//if (!StringUtils.equals(this.classification, classification)) {
			this.quantity = quantity;
			this.propertyChanged(TransactionEntryFieldNames.QUANTITY);
		//}		
		return this;
	}
	
	
	public org.npc.models.api.TransactionEntry synchronize(org.npc.models.api.TransactionEntry apiTransactionEntry) {
		this.setRecordId(apiTransactionEntry.getRecordId());
		this.setTransactionId(apiTransactionEntry.getTransactionId());
		this.setProductId(apiTransactionEntry.getProductId());
		this.setPrice(apiTransactionEntry.getPrice());
		this.setQuantity(apiTransactionEntry.getQuantity());
		
		return apiTransactionEntry;
	}
	
	public TransactionEntry() 
	{
		super(new TransactionEntryRepository());

		this.recordId = UUID.fromString("");
		this.transactionId = UUID.fromString("");
		this.productId = UUID.fromString("");
		this.price = 0;
		this.quantity = 0;
	}
	
	public TransactionEntry(UUID id) 
	{
		super(id, new TransactionEntryRepository());

		this.recordId = UUID.fromString("");
		this.transactionId = UUID.fromString("");
		this.productId = UUID.fromString("");
		this.price = 0;
		this.quantity = 0;
	}

	public TransactionEntry(org.npc.models.api.TransactionEntry apiTransactionEntry) 
	{
		super(apiTransactionEntry.getId(), new TransactionEntryRepository());
		
		this.recordId = apiTransactionEntry.getId();
		this.transactionId = apiTransactionEntry.getFirstName();
		this.productId = apiTransactionEntry.getLastName();
		this.price = apiTransactionEntry.getTransactionEntryId();
		this.quantity = apiTransactionEntry.getIsActive();

	}	
}