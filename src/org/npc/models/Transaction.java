package org.npc.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.npc.dataaccess.model.BaseModel;
import org.npc.models.fieldnames.TransactionFieldNames;
import org.npc.models.repositories.TransactionRepository;


public class Transaction extends BaseModel<Transaction>  {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.cashierid = ((UUID) rs.getObject(TransactionFieldNames.CASHIERID));
		this.amount = rs.getInt(TransactionFieldNames.AMOUNT);
		this.transactiontype = rs.getString(TransactionFieldNames.TRANSACTIONTYPE);
		this.parentid = ((UUID) rs.getObject(TransactionFieldNames.PARENTID));
		this.transactiondate = rs.getTimestamp(TransactionFieldNames.TRANSACTIONDATE).toLocalDateTime();
	}
	
	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionFieldNames.CASHIERID, this.cashierid);
		record.put(TransactionFieldNames.AMOUNT, this.amount);
		record.put(TransactionFieldNames.TRANSACTIONTYPE, this.transactiontype);
		record.put(TransactionFieldNames.PARENTID, this.parentid);
		record.put(TransactionFieldNames.TRANSACTIONDATE, Timestamp.valueOf(this.transactiondate));
		return record;
	}
	
	
private UUID cashierid;
	public UUID getCashierid() {
		return this.cashierid;
	}

public void setcashierid(UUID cashierid){
	this.cashierid = cashierid;
	
}

private double amount;
	public double getAmount(){
		return amount;
	}
	public void setAmount(double amount){
		this.amount = amount;	
	}
	
private String transactiontype;
	public String getTransactionType(){
		return transactiontype;
	}
	public void SetTransactionType(String transactiontype)	{
		this.transactiontype = transactiontype;
		this.propertyChanged(TransactionFieldNames.TRANSACTIONTYPE);
	}	
	
private UUID parentid;	
	public UUID getParentid(){
		return this.parentid;
	}
	public void setParentid(UUID parentid){
		this.parentid = parentid;
	}

private LocalDateTime transactiondate;
	public LocalDateTime getTransactionDate(){
		return this.transactiondate;
	}
	// DONE IN THE CONSTRUCTOR
	//public void setTransactionDate(LocalDateTime transactiondate){
	//	this.transactiondate = transactiondate;
	//}
	
	
	public org.npc.models.api.Transaction synchronize(org.npc.models.api.Transaction apiTransaction) {
		this.setcashierid(apiTransaction.getCashierid());
		this.setAmount(apiTransaction.getAmount());
		this.SetTransactionType(apiTransaction.getTransactionType());
		this.setParentid(apiTransaction.getParentid());
		apiTransaction.setLocalDate(this.transactiondate);
		
		return apiTransaction;
	}
	
// TRANSACTION DEFAULT CONSTRUCTOR
	public Transaction() {
		super(new TransactionRepository());
		
		//this.cashierid = UUID.fromString("");
		this.amount = 0;
		this.transactiontype = "";
		//this.parentid = UUID.fromString("");
		this.transactiondate = LocalDateTime.now();
	}
	
// TRANSACTION NON DEFAULT CONSTRUCTOR
	public Transaction(UUID id) {
		super(id, new TransactionRepository());
		this.cashierid = UUID.fromString("");
		this.amount = 0;
		this.transactiontype = "";
		this.parentid = UUID.fromString("");
		this.transactiondate = LocalDateTime.now();
	}
	
	
	public Transaction(org.npc.models.api.Transaction apiTransaction) {
		super(apiTransaction.getId(), new TransactionRepository());
		
		this.id = apiTransaction.getId();
		this.cashierid = apiTransaction.getCashierid();
		this.amount = apiTransaction.getAmount();
		this.transactiontype = apiTransaction.getTransactionType();
		this.parentid = apiTransaction.getParentid();

		this.transactiondate = LocalDateTime.now();
	}		
}