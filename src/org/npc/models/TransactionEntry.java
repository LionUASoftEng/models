package org.npc.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import org.npc.dataaccess.model.BaseModel;
import org.npc.models.fieldnames.TransactionEntryFieldNames;
import org.npc.models.repositories.TransactionEntryRepository;

public class TransactionEntry extends BaseModel<TransactionEntry> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.transactionId = ((UUID)rs.getObject(TransactionEntryFieldNames.TRANSACTIONID));
		this.productId = ((UUID)rs.getObject(TransactionEntryFieldNames.PRODUCTID));
		this.price = rs.getDouble(TransactionEntryFieldNames.PRICE);
		this.quantity = rs.getInt(TransactionEntryFieldNames.QUANTITY);
	}
		
	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionEntryFieldNames.TRANSACTIONID, this.transactionId);
		record.put(TransactionEntryFieldNames.PRODUCTID, this.productId);
		record.put(TransactionEntryFieldNames.PRICE, this.price);
		record.put(TransactionEntryFieldNames.QUANTITY, this.quantity);
		
		return record;
	}

	private UUID transactionId;
	public UUID getTransactionId() {
		return this.transactionId;
	}
	public TransactionEntry setTransactionId(UUID transactionId) {
		if( this.transactionId != transactionId){
			this.transactionId = transactionId;
			this.propertyChanged(TransactionEntryFieldNames.TRANSACTIONID);
		}
		return this;
	}
	
	private UUID productId;
	public UUID getProductId(){
		return this.productId;
	}
	public TransactionEntry setProductId(UUID productId){
		if(this.productId != productId){
			this.productId = productId;
			this.propertyChanged(TransactionEntryFieldNames.PRODUCTID);
		}
		return this;
	}
	
	private double price;
	public double getPrice(){
		return this.price;
	}
	public TransactionEntry setPrice(double price){
		if(this.price != price){
			this.price = price;
			this.propertyChanged(TransactionEntryFieldNames.PRICE);
		}
		return this;
	}
	
	private int quantity;
	public int getQuantity(){
		return this.quantity;		
	}
	public TransactionEntry setQuantity(int quantity){
		if(this.quantity != quantity){
			this.quantity = quantity;
			this.propertyChanged(TransactionEntryFieldNames.QUANTITY);
		}
		return this;
	}
	
	public org.npc.models.api.TransactionEntry synchronize(org.npc.models.api.TransactionEntry apiTransactionEntry){
		this.setTransactionId(apiTransactionEntry.getTransactionId());
		this.setProductId(apiTransactionEntry.getProductId());
		this.setPrice(apiTransactionEntry.getPrice());
		this.setQuantity(apiTransactionEntry.getQuantity());
		
		return apiTransactionEntry;
	}
	
	public TransactionEntry(){
		super(new TransactionEntryRepository());
		
		//this.transactionId = UUID.fromString("");
		//this.productId = UUID.fromString("");
		this.price = -.9999;
		this.quantity = -1;		
	}
	
	public TransactionEntry (UUID id){
		super(id, new TransactionEntryRepository());
		
		this.transactionId = UUID.fromString("");
		this.productId = UUID.fromString("");
		this.price = -.9999;
		this.quantity = -1;
	}
}