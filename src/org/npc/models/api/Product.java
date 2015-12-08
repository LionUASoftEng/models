package org.npc.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.npc.models.enums.ProductApiRequestStatus;

@XmlRootElement
public class Product {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Product setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private String description;
	public String getDescription() {
		return this.description;
	}
	public Product setDescription(String description) {
		this.description = description;
		return this;
	}

	private String itemLookupCode;
	public String getItemLookupCode() {
		return this.itemLookupCode;
	}
	public Product setItemLookupCode(String itemlookupCode) {
		this.itemLookupCode = itemlookupCode;
		return this;
	}
	
	private double price;
	public double getPrice() {
		return this.price;
	}
	public Product setPrice(double price) {
		this.price = price;
		return this;
	}

	private int itemType;
	public int getItemType() {
		return this.itemType;
	}
	public Product setItemType(int itemType) {
		this.itemType = itemType;
		return this;
	}

	private double cost;
	public double getCost() {
		return this.cost;
	}
	public Product setCost(double cost) {
		this.cost = cost;
		return this;
	}

	private int quantity;
	public int getQuantity() {
		return this.quantity;
	}
	public Product setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	private int reorderPoint;
	public int getReorderPoint() {
		return this.reorderPoint;
	}
	public Product setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
		return this;
	}

	private int restockLevel;
	public int getRestockLevel() {
		return this.restockLevel;
	}
	public Product setRestockLevel(int restockLevel) {
		this.restockLevel = restockLevel;
		return this;
	}

	private UUID parentItem;
	public UUID getParentItem() {
		return this.parentItem;
	}
	public Product setParentItem(UUID parentItem) {
		this.parentItem = parentItem;
		return this;
	}

	private String extendedDescription;
	public String getExtendedDescription() {
		return this.extendedDescription;
	}
	public Product setExtendedDescription(String extendedDescription) {
		this.extendedDescription = extendedDescription;
		return this;
	}

	private boolean inactive;
	public boolean getInactive() {
		return this.inactive;
	}
	public Product setInactive(boolean inactive) {
		this.inactive = inactive;
		return this;
	}

	private double MSRP;
	public double getMSRP() {
		return this.MSRP;
	}
	public Product setMSRP(double MSRP) {
		this.MSRP = MSRP;
		return this;
	}
	
	private LocalDateTime dateCreated;
	public LocalDateTime getDateCreated() {
		return this.dateCreated;
	}
	public Product setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
		return this;
	}
	
	private ProductApiRequestStatus apiRequestStatus;
	public ProductApiRequestStatus getApiRequestStatus() {
		return this.apiRequestStatus;
	}
	public Product setApiRequestStatus(ProductApiRequestStatus apiRequestStatus) {
		if (this.apiRequestStatus != apiRequestStatus) {
			this.apiRequestStatus = apiRequestStatus;
		}
		
		return this;
	}
	
	private String apiRequestMessage;
	public String getApiRequestMessage() {
		return this.apiRequestMessage;
	}
	public Product setApiRequestMessage(String apiRequestMessage) {
		if (!StringUtils.equalsIgnoreCase(this.apiRequestMessage, apiRequestMessage)) {
			this.apiRequestMessage = apiRequestMessage;
		}
		
		return this;
	}
	
	public Product() {
		this.id = new UUID(0, 0);
		this.itemLookupCode = "";
		this.price = -1.00;
		this.itemType = 0;
		this.cost = -1.00;
		this.quantity = -1;
		this.reorderPoint = -1;
		this.restockLevel = -1;
		this.extendedDescription = "";
		this.inactive = false;
		this.MSRP = -1.00;		
		this.dateCreated = LocalDateTime.now();
		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = ProductApiRequestStatus.OK;
	}
	
	public Product(org.npc.models.Product modelProduct) {
		this.id = modelProduct.getId();
		this.description = modelProduct.getDescription();
		this.itemLookupCode = modelProduct.getItemLookupCode();
		this.price = modelProduct.getPrice();
		this.itemType = modelProduct.getItemType();
		this.cost = modelProduct.getCost(); 
		this.quantity = modelProduct.getQuantity();
		this.reorderPoint = modelProduct.getReorderPoint();
		this.restockLevel = modelProduct.getRestockLevel();
		this.parentItem = modelProduct.getParentItem();
		this.extendedDescription = modelProduct.getExtendedDescription();
		this.inactive = modelProduct.getInactive();
		this.MSRP = modelProduct.getMSRP();
		this.dateCreated = modelProduct.getDateCreated();

		this.apiRequestMessage = StringUtils.EMPTY;
		this.apiRequestStatus = ProductApiRequestStatus.OK;
	}
}