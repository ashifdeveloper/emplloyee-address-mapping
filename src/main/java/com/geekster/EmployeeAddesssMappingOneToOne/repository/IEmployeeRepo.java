package com.geekster.EmployeeAddesssMappingOneToOne.repository;

import com.geekster.EmployeeAddesssMappingOneToOne.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeRepo extends CrudRepository<Employee,Long> {
}
