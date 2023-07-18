package com.geekster.EmployeeAddesssMappingOneToOne.repository;

import com.geekster.EmployeeAddesssMappingOneToOne.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface IAddressRepo extends CrudRepository<Address,Long> {
}
