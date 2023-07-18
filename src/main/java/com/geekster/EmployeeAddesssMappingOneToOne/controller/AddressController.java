package com.geekster.EmployeeAddesssMappingOneToOne.controller;

import com.geekster.EmployeeAddesssMappingOneToOne.model.Address;
import com.geekster.EmployeeAddesssMappingOneToOne.model.Employee;
import com.geekster.EmployeeAddesssMappingOneToOne.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;


    //Get All Addresses
    @GetMapping("Addresses")

    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    //Add a Address

    @PostMapping("address")
    public String addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }


    //Get An Address By Id

    @GetMapping("address/{id}")
    public Address getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }


    //Update Address By Id

    @PutMapping("address/{id}/{city}")

    public String updateAddressById(@PathVariable Long id,@PathVariable String city){
        return addressService.updateAddressById(id,city);
    }

    // Delete An Address By Id

    @DeleteMapping("address/{id}")

    public String removeAddressById(@PathVariable Long id){
        return addressService.removeAddressById(id);
    }
}
