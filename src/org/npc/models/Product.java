package org.npc.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.npc.dataaccess.model.BaseModel;
import org.npc.models.fieldnames.ProductFieldNames;
import org.npc.models.repositories.ProductRepository;

public class Product extends BaseModel<Product> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.description = rs.getString(ProductFieldNames.DESCRIPTION);
		this.itemLookupCode = rs.getString(ProductFieldNames.ITEM_LOOKUP_CODE);
		this.price = rs.getDouble(ProductFieldNames.PRICE);
		this.cost = rs.getDouble(ProductFieldNames.COST);
		this.quantity = rs.getInt(ProductFieldNames.QUANTITY);
		this.reorderPoint = rs.getInt(ProductFieldNames.REORDER_POINT);
		this.restockLevel = rs.getInt(ProductFieldNames.RESTOCK_LEVEL);
		this.parentItem = ((UUID)rs.getObject(ProductFieldNames.PARENT_ITEM));
		this.extendedDescription = rs.getString(ProductFieldNames.EXTENDED_DESCRIPTION);
		this.inactive = rs.getBoolean(ProductFieldNames.INACTIVE);
		this.MSRP = rs.getDouble(ProductFieldNames.MSRP);
		this.dateCreated = rs.getTimestamp(ProductFieldNames.DATE_CREATED).toLocalDateTime();
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(ProductFieldNames.DESCRIPTION, this.description);
		record.put(ProductFieldNames.ITEM_LOOKUP_CODE, this.itemLookupCode);
		record.put(ProductFieldNames.PRICE, this.price);	
		record.put(ProductFieldNames.ITEM_TYPE, this.itemType);
		record.put(ProductFieldNames.COST, this.cost);
		record.put(ProductFieldNames.QUANTITY, this.quantity);
		record.put(ProductFieldNames.REORDER_POINT, this.reorderPoint);
		record.put(ProductFieldNames.RESTOCK_LEVEL, this.restockLevel);
		record.put(ProductFieldNames.PARENT_ITEM, this.parentItem);
		record.put(ProductFieldNames.EXTENDED_DESCRIPTION, this.extendedDescription);
		record.put(ProductFieldNames.INACTIVE, this.inactive);
		record.put(ProductFieldNames.MSRP, this.MSRP);
		record.put(ProductFieldNames.DATE_CREATED, Timestamp.valueOf(this.dateCreated));
		
		return record;
	}

	private String description;
	public String getDescription() {
		return this.description;
	}
	public Product setDescription(String description) {
		if (!StringUtils.equals(this.description, description)) {
			this.description = description;
			this.propertyChanged(ProductFieldNames.DESCRIPTION);
		}
		
		return this;
	}	

	private String itemLookupCode;
	public String getItemLookupCode() {
		return this.itemLookupCode;
	}
	public Product setItemLookupCode(String itemLookupCode) {
		if (!StringUtils.equals(this.itemLookupCode, itemLookupCode)) {
			this.itemLookupCode = itemLookupCode;
			this.propertyChanged(ProductFieldNames.ITEM_LOOKUP_CODE);
		}
		
		return this;
	}

	private double price;
	public double getPrice() {
		return this.price;
	}
	public Product setPrice(double price) {
		if (this.price != price) {
			this.price = price;
			this.propertyChanged(ProductFieldNames.PRICE);
		}
		
		return this;
	}

	private int itemType;
	public int getItemType() {
		return this.itemType;
	}
	public Product setItemType(int itemType) {
		if (this.itemType != itemType) {
			this.itemType = itemType;
			this.propertyChanged(ProductFieldNames.ITEM_TYPE);
		}
		
		return this;
	}

	private double cost;
	public double getCost() {
		return this.cost;
	}
	public Product setCost(double cost) {
		if (this.cost != cost) {
			this.cost = cost;
			this.propertyChanged(ProductFieldNames.COST);
		}
		
		return this;
	}

	private int quantity;
	public int getQuantity() {
		return this.quantity;
	}
	public Product setQuantity(int quantity) {
		if (this.quantity != quantity) {
			this.quantity = quantity;
			this.propertyChanged(ProductFieldNames.QUANTITY);
		}
		
		return this;
	}

	private int reorderPoint;
	public int getReorderPoint() {
		return this.reorderPoint;
	}
	public Product setReorderPoint(int reorderPoint) {
		if (this.reorderPoint != reorderPoint) {
			this.reorderPoint = reorderPoint;
			this.propertyChanged(ProductFieldNames.REORDER_POINT);
		}
		
		return this;
	}

	private int restockLevel;
	public int getRestockLevel() {
		return this.restockLevel;
	}
	public Product setRestockLevel(int restockLevel) {
		if (this.restockLevel != restockLevel) {
			this.restockLevel = restockLevel;
			this.propertyChanged(ProductFieldNames.RESTOCK_LEVEL);
		}
		
		return this;
	}

	private UUID parentItem;
	public UUID getParentItem() {
		return this.parentItem;
	}
	public Product setParentItem(UUID parentItem) {
		if (this.parentItem != parentItem) {
			this.parentItem = parentItem;
			this.propertyChanged(ProductFieldNames.PARENT_ITEM);
		}
		
		return this;
	}

	private String extendedDescription;
	public String getExtendedDescription() {
		return this.extendedDescription;
	}
	public Product setExtendedDescription(String extendedDescription) {
		if (!StringUtils.equals(this.extendedDescription, extendedDescription)) {
			this.extendedDescription = extendedDescription;
			this.propertyChanged(ProductFieldNames.EXTENDED_DESCRIPTION);
		}
		
		return this;
	}

	private boolean inactive;
	public boolean getInactive() {
		return this.inactive;
	}
	public Product setInactive(boolean inactive) {
		if (this.inactive != inactive) {
			this.inactive = inactive;
			this.propertyChanged(ProductFieldNames.INACTIVE);
		}
		
		return this;
	}

	private double MSRP;
	public double getMSRP() {
		return this.MSRP;
	}
	public Product setMSRP(double MSRP) {
		if (this.MSRP != MSRP) {
			this.MSRP = MSRP;
			this.propertyChanged(ProductFieldNames.MSRP);
		}
		
		return this;
	}

	private LocalDateTime dateCreated;
	public LocalDateTime getDateCreated() {
		return this.dateCreated;
	}


	public org.npc.models.api.Product synchronize(org.npc.models.api.Product apiProduct) {
		this.setDescription(apiProduct.getDescription());
		this.setItemLookupCode(apiProduct.getItemLookupCode());
		this.setPrice(apiProduct.getPrice());
		this.setItemType(apiProduct.getItemType());
		this.setCost(apiProduct.getCost());
		this.setQuantity(apiProduct.getQuantity());
		this.setReorderPoint(apiProduct.getReorderPoint());
		this.setRestockLevel(apiProduct.getRestockLevel());
		this.setParentItem(apiProduct.getParentItem());
		this.setExtendedDescription(apiProduct.getExtendedDescription());
		this.setInactive(apiProduct.getInactive());
		this.setMSRP(apiProduct.getMSRP());
		
		apiProduct.setDateCreated(this.dateCreated);
		
		return apiProduct;
	}
	
	public Product() {
		super(new ProductRepository());
		
		this.description = StringUtils.EMPTY;
		this.itemLookupCode = StringUtils.EMPTY;
		this.price = -1.00;
		this.itemType = 0;
		this.cost = -1.00;
		this.quantity = -1;
		this.reorderPoint = 0;
		this.restockLevel = 0;
		//this.parentItem = = UUID.fromString("");
		this.extendedDescription = StringUtils.EMPTY;
		this.inactive = false;
		this.MSRP = -1.00;
		this.dateCreated = LocalDateTime.now();
	}

	public Product(UUID id) {
		super(id, new ProductRepository());
		
		this.description = StringUtils.EMPTY;
		this.itemLookupCode = StringUtils.EMPTY;
		this.price = -1.00;
		this.itemType = 0;
		this.cost = -1.00;
		this.quantity = -1;
		this.reorderPoint = 0;
		this.restockLevel = 0;
		this.parentItem = UUID.fromString("");
		this.extendedDescription = StringUtils.EMPTY;
		this.inactive = false;
		this.MSRP = -1.00;
		this.dateCreated = LocalDateTime.now();
	}

	public Product(org.npc.models.api.Product apiProduct) {
		super(apiProduct.getId(), new ProductRepository());
		
		this.description = apiProduct.getDescription();
		this.itemLookupCode = apiProduct.getItemLookupCode();
		this.price = apiProduct.getPrice();
		this.itemType = apiProduct.getItemType();
		this.cost = apiProduct.getCost();
		this.quantity = apiProduct.getQuantity();
		this.reorderPoint = apiProduct.getReorderPoint();
		this.restockLevel = apiProduct.getRestockLevel();
		this.parentItem = apiProduct.getParentItem();
		this.extendedDescription = apiProduct.getExtendedDescription();
		this.inactive = apiProduct.getInactive();
		this.MSRP = apiProduct.getMSRP();
		this.dateCreated = LocalDateTime.now();
	}
}