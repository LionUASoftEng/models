package org.npc.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.StringUtils;
import org.npc.models.enums.TransactionEntryApiRequestStatus;

@XmlRootElement
public class TransactionEntry 
{
	private UUID recordId;
	private UUID transactionId;
	private UUID productId;
	private float price;
	private int quantity;
	private TransactionEntryApiRequestStatus apiRequestStatus;
	private String apiRequestMessage;
	
	public UUID getRecordId() 
	{
		return this.recordId;
	}
	public TransactionEntry setRecordId(UUID recordId) 
	{
		this.recordId = recordId;
		return this;
	}
	
	public UUID getTransactionId() 
	{
		return this.transactionId;
	}
	public void setTransactionId(UUID transactionId) 
	{
		this.transactionId = transactionId;
	}
	
	public UUID getProductId() 
	{
		return this.productId;
	}
	public void setProductId(UUID productId) 
	{
		this.productId = productId;
	}
		
	public float getPrice() 
	{
		return price;
	}
	public void setPrice(float price) 
	{
		this.price = price;
	}
	
	public int getQuantity() 
	{
		return quantity;
	}
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	
	public TransactionEntryApiRequestStatus getApiRequestStatus() {
		return this.apiRequestStatus;
	}
	public TransactionEntry setApiRequestStatus(TransactionEntryApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this.apiRequestStatus = apiRequestStatus;
		}
		
		return this;
	}
	
	public String getApiRequestMessage() {
		return this.apiRequestMessage;
	}
	public TransactionEntry setApiRequestMessage(String apiRequestMessage) {
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
			this.apiRequestMessage = apiRequestMessage;
		}
		
		return this;
	}
	
	public TransactionEntry() {
		this.recordId = new UUID(0, 0);
		this.transactionId = new UUID(0, 0);
		this.productId = new UUID(0, 0);
		this.price = 0;
		this.quantity = 0;
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TransactionEntryApiRequestStatus.OK;
	}
	
	public TransactionEntry(org.npc.models.TransactionEntry modelTransactionEntry) {
		this.recordId = modelTransactionEntry.getRecordId();
		this.transactionId = modelTransactionEntry.getTransactionId();
		this.productId = modelTransactionEntry.getProductId();
		this.price = modelTransactionEntry.getPrice();
		this.quantity = modelTransactionEntry.getQuantity();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TransactionEntryApiRequestStatus.OK;
	}
}