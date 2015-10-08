package org.npc.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.StringUtils;
import org.npc.models.api.TenderEntry;
import org.npc.models.enums.TenderEntryApiRequestStatus;
import org.npc.models.fieldnames.TenderEntryFieldNames;

@XmlRootElement
public class TenderEntry {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public TenderEntry setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private UUID transID;
	public UUID gettransID() {
		return transID;
	}
	public void settransID(UUID transID) {
		this.transID = transID;
	}
	
	private String tendertype;
	public String gettendertype() {
		return tendertype;
	}
	public void settendertype(String tendertype) {
		this.tendertype = tendertype;
	}
	
	private double amount;	
	public double getamount() {
		return amount;
	}
	public void setamount(double amount) {
		this.amount = amount;
	}

	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public TenderEntry setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	private TenderEntryApiRequestStatus apiRequestStatus;
	public TenderEntryApiRequestStatus getApiRequestStatus() {
		return this.apiRequestStatus;
	}
	public TenderEntry setApiRequestStatus(TenderEntryApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this.apiRequestStatus = apiRequestStatus;
		}
		
		return this;
	}
	
	private String apiRequestMessage;
	public String getApiRequestMessage() {
		return this.apiRequestMessage;
	}
	public TenderEntry setApiRequestMessage(String apiRequestMessage) {
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
			this.apiRequestMessage = apiRequestMessage;
		}
		
		return this;
	}
	
	public TenderEntry() {
		this.id = new UUID(0, 0);
		this.transID = new UUID (0,0);
		this.tendertype = "";
		//this.amount = "";	
		this.createdOn = LocalDateTime.now();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TenderEntryApiRequestStatus.OK;
	}
	
	public TenderEntry(org.npc.models.TenderEntry modelTenderEntry) {
		this.id = new UUID(0, 0);
		this.transID = new UUID (0,0);
		this.tendertype = "";
		//this.amount = "";		
		this.createdOn = modelTenderEntry.getCreatedOn();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = TenderEntryApiRequestStatus.OK;
	}
	
}
