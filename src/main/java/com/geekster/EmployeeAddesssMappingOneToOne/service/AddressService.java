package com.geekster.EmployeeAddesssMappingOneToOne.service;

import com.geekster.EmployeeAddesssMappingOneToOne.model.Address;
import com.geekster.EmployeeAddesssMappingOneToOne.model.Employee;
import com.geekster.EmployeeAddesssMappingOneToOne.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public List<Address> getAllAddress() {
        return (List<Address>)addressRepo.findAll();
    }

    public String addAddress(Address address) {
        addressRepo.save(address);
        return "Address Added Successful";
    }

    public Address getAddressById(Long id) {
        Optional<Address> optionalAddress =addressRepo.findById(id);
        if(optionalAddress.isEmpty()){
            return null;
        }
        return optionalAddress.get();
    }

    public String updateAddressById(Long id, String city) {
        Optional<Address> myAddressOpt = addressRepo.findById(id);
        Address myAddress = null;
        if(myAddressOpt.isPresent()){
            myAddress = myAddressOpt.get();
        }
        else{
            return "Id Not Found";
        }
        myAddress.setCity(city);
        addressRepo.save(myAddress);
        return "City Updated";
    }

    public String removeAddressById(Long id) {
        addressRepo.deleteById(id);
        return "Address Deleted Successful";
    }
}
