package org.npc.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.StringUtils;
import org.npc.models.enums.TransactionApiRequestStatus;

@XmlRootElement
public class Transaction {
	
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Transaction setId(UUID id) {
		this.id = id;
		return this;
	}

	
	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public Transaction setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}
	
	
	private UUID cashierid;
	public UUID getCashierid() {
		return cashierid;
	}
	public void setCashierid(UUID cashierid) {
		this.cashierid = cashierid;
	}
	
	
	private double amount;
	public double getAmount(){
		return this.amount;
	}
	public void setAmount(double amount){
		this.amount = amount;
	}
	
	
	private String transactiontype; 
	public String getTransactionType(){
		return this.transactiontype;
	}
	public void setTransactionType(String transactiontype){
		this.transactiontype = transactiontype;
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
	public Transaction setLocalDate(LocalDateTime transactiondate){
		this.transactiondate = transactiondate;
		return this;
	}
	
	
	private TransactionApiRequestStatus apiRequestStatus;
	public TransactionApiRequestStatus getApiRequestStatus() {
		return this.apiRequestStatus;
	}
	public Transaction setApiRequestStatus(TransactionApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this.apiRequestStatus = apiRequestStatus;
		}		
		return this;
	}
	
	private String apiRequestMessage;
	public String getApiRequestMessage() {
		return this.apiRequestMessage;
	}
	public Transaction setApiRequestMessage(String apiRequestMessage) {
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
			this.apiRequestMessage = apiRequestMessage;
		}
		
		return this;
	}
	
	
	public Transaction() {
		this.id = new UUID(0, 0);
		this.cashierid = UUID.fromString("");
		this.amount = 0;
		this.transactiontype = "";
		this.parentid = UUID.fromString("");
		this.transactiondate = LocalDateTime.now();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TransactionApiRequestStatus.OK;
	}
	
	
	public Transaction(org.npc.models.Transaction modelTransaction) {
		this.id = modelTransaction.getId();
		this.cashierid = modelTransaction.getCashierid();
		this.amount = modelTransaction.getAmount();
		this.transactiontype = modelTransaction.getTransactionType();
		this.parentid = modelTransaction.getParentid();
		this.transactiondate = modelTransaction.getTransactionDate();
		
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TransactionApiRequestStatus.OK;
	}
	
}
