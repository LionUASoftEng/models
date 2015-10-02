package org.npc.models.repositories.interfaces;

import org.npc.dataaccess.repository.BaseRepositoryInterface;
import org.npc.models.Employee;

public interface EmployeeRepositoryInterface extends BaseRepositoryInterface<Employee>{
	Employee byEmployeeId(int employeeId);
}
