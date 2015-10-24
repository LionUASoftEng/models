package org.npc.models.api;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.StringUtils;
import org.npc.models.api.TransactionEntry;
import org.npc.models.enums.TransactionEntryApiRequestStatus;

@XmlRootElement
public class TransactionEntry {
	
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public TransactionEntry setId(UUID id) {
		this.id = id;
		return this;
	}

	private UUID transactionId;
	public UUID getTransactionId(){
		return this.transactionId;
	}
	public TransactionEntry setTransactionId(UUID transactionId){
		this.transactionId = transactionId;
		return this;
	}
	
	private UUID productId;
	public UUID getProductId(){
		return this.productId;
	}
	public TransactionEntry setProductId(UUID productId){
		this.productId = productId;
		return this;
	}

	private double price;
	public double getPrice() {
		return this.price;
	}
	public TransactionEntry setPrice(double price) {
		this.price = price;
		return this;
	}

	private int quantity;
	public int getQuantity() {
		return this.quantity;
	}
	public TransactionEntry setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	private TransactionEntryApiRequestStatus apiRequestStatus;
	public TransactionEntryApiRequestStatus getApiRequestStatus() {
		return this.apiRequestStatus;
	}
	public TransactionEntry setApiRequestStatus(TransactionEntryApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this.apiRequestStatus = apiRequestStatus;
		}
			
		return this;
	}

	private String apiRequestMessage;
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
		this.id = new UUID(0, 0);
		this.transactionId = new UUID(0, 0);
		this.productId = new UUID(0, 0);
		this.price = -0.9999;
		this.quantity = -1;
	}
		
	public TransactionEntry(org.npc.models.TransactionEntry modelTransactionEntry){
		this.id = modelTransactionEntry.getId();
		this.transactionId = modelTransactionEntry.getTransactionId();
		this.productId = modelTransactionEntry.getProductId();
		this.price = modelTransactionEntry.getPrice();
		this.quantity = modelTransactionEntry.getQuantity();
			
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TransactionEntryApiRequestStatus.OK;
	}
}