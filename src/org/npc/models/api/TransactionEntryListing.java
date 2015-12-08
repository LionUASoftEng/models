package org.npc.models.api;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransactionEntryListing {
	private List<TransactionEntry> transactionEntries;
	public List<TransactionEntry> getTransactionEntries() {
		return this.transactionEntries;
	}
	public TransactionEntryListing setTransactionEntries(List<TransactionEntry> transactionEntries) {
		this.transactionEntries = transactionEntries;
		return this;
	}
	public TransactionEntryListing addTransactionEntry(TransactionEntry transactionEntry) {
		this.transactionEntries.add(transactionEntry);
		return this;
	}
	
	public TransactionEntryListing() {
		this.transactionEntries = new LinkedList<TransactionEntry>();
	}
}