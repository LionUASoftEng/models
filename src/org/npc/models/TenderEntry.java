package org.npc.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.npc.dataaccess.model.BaseModel;
import org.npc.models.fieldnames.TenderEntryFieldNames;
import org.npc.models.repositories.TenderEntryRepository;

public class TenderEntry extends BaseModel<TenderEntry> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.transID = (UUID)rs.getObject(TenderEntryFieldNames.TRANSID);
		this.tendertype = rs.getString(TenderEntryFieldNames.TENDERTYPE);
		this.amount = rs.getDouble(TenderEntryFieldNames.AMOUNT);
		this.createdOn = rs.getTimestamp(TenderEntryFieldNames.CREATED_ON).toLocalDateTime();
		
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TenderEntryFieldNames.TRANSID, this.transID);
		record.put(TenderEntryFieldNames.TENDERTYPE, this.tendertype);
		record.put(TenderEntryFieldNames.AMOUNT, this.amount);
		record.put(TenderEntryFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
		
		return record;
	}

	private UUID transID;
	public UUID gettransID() {
		return this.transID;
	}
	public TenderEntry settransID(UUID transID) { 
			this.transID = transID;
			this.propertyChanged(TenderEntryFieldNames.TRANSID);
		
		return this;
	}

	private String tendertype;
	public String gettendertype() {
		return this.tendertype;
	}
	public TenderEntry settendertype(String tendertype) { 
		if (!StringUtils.equals(this.tendertype, tendertype))
		{
			this.tendertype = tendertype;
			this.propertyChanged(TenderEntryFieldNames.TENDERTYPE);
		}
		
		return this;
	}
	
	private double amount;
	public double getamount() {
		return this.amount;
	}
	public TenderEntry setamount(double amount) { 
			this.amount = amount;
			this.propertyChanged(TenderEntryFieldNames.AMOUNT);
		
		return this;
	}

	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	
	public org.npc.models.api.TenderEntry synchronize(org.npc.models.api.TenderEntry apiTenderEntry) {
		this.settransID(apiTenderEntry.gettransID());
		this.settendertype(apiTenderEntry.gettendertype());
		this.setamount(apiTenderEntry.getamount());
		apiTenderEntry.setCreatedOn(this.createdOn);
		
		return apiTenderEntry;
	}
	
	public TenderEntry() {
		super(new TenderEntryRepository());

		// this.transID = UUID.fromString("");
		this.tendertype = "";
		this.amount = 0.00;	
		this.createdOn = LocalDateTime.now();
	}
	
	public TenderEntry(UUID id) {
		super(id, new TenderEntryRepository());
		
		this.transID = UUID.fromString("");
		this.tendertype = "";
		this.amount = 0;
		this.createdOn = LocalDateTime.now();
	}
	
	public TenderEntry(org.npc.models.api.TenderEntry apiTenderEntry){
		super(apiTenderEntry.getId(), new TenderEntryRepository());
		this.id = apiTenderEntry.getId();
		this.tendertype = apiTenderEntry.gettendertype();
		this.amount = apiTenderEntry.getamount();
		this.createdOn = apiTenderEntry.getCreatedOn();
	}
}