package org.npc.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.npc.dataaccess.model.BaseModel;
import org.npc.models.fieldnames.EmployeeFieldNames;
import org.npc.models.repositories.EmployeeRepository;

public class Employee extends BaseModel<Employee>{
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.firstName = rs.getString(EmployeeFieldNames.FIRST_NAME);
		this.lastName = rs.getString(EmployeeFieldNames.LAST_NAME);
		this.employeeId = rs.getString(EmployeeFieldNames.EMPLOYEE_ID);
		this.isActive = rs.getBoolean(EmployeeFieldNames.ACTIVE);
		this.classification = rs.getString(EmployeeFieldNames.CLASSIFICATION);
		this.manager = ((UUID) rs.getObject(EmployeeFieldNames.MANAGER));
		this.password = rs.getString(EmployeeFieldNames.PASSWORD);
		this.createdOn = rs.getTimestamp(EmployeeFieldNames.CREATED_ON).toLocalDateTime();
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(EmployeeFieldNames.FIRST_NAME, this.firstName);
		record.put(EmployeeFieldNames.LAST_NAME, this.lastName);
		record.put(EmployeeFieldNames.EMPLOYEE_ID, this.employeeId);
		record.put(EmployeeFieldNames.ACTIVE, this.isActive);
		record.put(EmployeeFieldNames.CLASSIFICATION, this.classification);
		record.put(EmployeeFieldNames.MANAGER, this.manager);
		record.put(EmployeeFieldNames.PASSWORD, this.password);
		record.put(EmployeeFieldNames.CREATED_ON, Timestamp.valueOf(this.createdOn));
		
		return record;
	}

	private String firstName;
	public String getFirstName() {
		return this.firstName;
	}
	public Employee setFirstName(String firstName) {
		//if (!StringUtils.equals(this.firstName, firstName)) {
			this.firstName = firstName;
			this.propertyChanged(EmployeeFieldNames.FIRST_NAME);
		//}		
		return this;
	}

	private String lastName;
	public String getLastName() {
		return this.lastName;
	}
	public Employee setLastName(String lastName) {
		//if (!StringUtils.equals(this.lastName, lastName)) {
			this.lastName = lastName;
			this.propertyChanged(EmployeeFieldNames.LAST_NAME);
		//}		
		return this;
	}

	private String employeeId;
	public String getEmployeeId() {
		return this.employeeId;
	}
	public Employee setEmployeeId(String string) {
		//if (!StringUtils.equals(this.employeeId, string)) {
			this.employeeId = string;
			this.propertyChanged(EmployeeFieldNames.EMPLOYEE_ID);
		//}		
		return this;
	}
	
	private Boolean isActive;
	public Boolean getActive() {
		return this.isActive;
	}
	public Employee setIsActive(Boolean isActive) {
		if (this.isActive != isActive) {
			this.isActive = isActive;
			this.propertyChanged(EmployeeFieldNames.ACTIVE);
		}		
		return this;
	}
	
	private String classification;
	public String getClassification() {
		return this.classification;
	}
	public Employee setClassification(String classification) {
		//if (!StringUtils.equals(this.classification, classification)) {
			this.classification = classification;
			this.propertyChanged(EmployeeFieldNames.CLASSIFICATION);
		//}		
		return this;
	}
	
	private UUID manager;
	public UUID getManager() {
		return this.manager;
	}
	public Employee setManager(UUID manager) {
//		if (!StringUtils.equals(this.manager, manager)) {
			this.manager = manager;
			this.propertyChanged(EmployeeFieldNames.MANAGER);
//		}		
		return this;
	}
	
	private String password;
	public String getPassword() {
		return this.password;
	}
	public Employee setPassword(String password) {
		//if (!StringUtils.equals(this.password, password)) {
			this.password = password;
			this.propertyChanged(EmployeeFieldNames.PASSWORD);
		//}		
		return this;
	}

	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	
	public org.npc.models.api.Employee synchronize(org.npc.models.api.Employee apiEmployee) {
		this.setFirstName(apiEmployee.getFirstName());
		this.setLastName(apiEmployee.getLastName());
		this.setEmployeeId(apiEmployee.getEmployeeId());
		this.setIsActive(apiEmployee.getIsActive());
		this.setClassification(apiEmployee.getClassification());
		this.setManager(apiEmployee.getManager());
		this.setPassword(apiEmployee.getPassword());
		apiEmployee.setCreatedOn(this.createdOn);
		
		return apiEmployee;
	}
	
	public Employee() {
		super(new EmployeeRepository());

		this.firstName = "";
		this.lastName = "";
		this.employeeId = "";
		this.isActive = false;
		this.classification = "";
		//this.manager = UUID.fromString("");
		this.password = "";	
		this.createdOn = LocalDateTime.now();
	}
	
	public Employee(UUID id) {
		super(id, new EmployeeRepository());

		this.firstName = "";
		this.lastName = "";
		this.employeeId = "";
		this.isActive = false;
		this.classification = "";
		this.manager = UUID.fromString("");
		this.password = "";	
		this.createdOn = LocalDateTime.now();
	}

	public Employee(org.npc.models.api.Employee apiEmployee) {
		super(apiEmployee.getId(), new EmployeeRepository());
		
		this.id = apiEmployee.getId();
		this.firstName = apiEmployee.getFirstName();
		this.lastName = apiEmployee.getLastName();
		this.employeeId = apiEmployee.getEmployeeId();
		this.isActive = apiEmployee.getIsActive();
		this.classification = apiEmployee.getClassification();
		this.manager = apiEmployee.getManager();
		this.password = apiEmployee.getPassword();	

		this.createdOn = LocalDateTime.now();
	}	
}
