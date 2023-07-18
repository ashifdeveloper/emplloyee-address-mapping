package com.geekster.EmployeeAddesssMappingOneToOne.service;

import com.geekster.EmployeeAddesssMappingOneToOne.model.Employee;
import com.geekster.EmployeeAddesssMappingOneToOne.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees() {
        return (List<Employee>)employeeRepo.findAll();
    }

    public String addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "Employee Added Successful";
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee =employeeRepo.findById(id);
        if(optionalEmployee.isEmpty()){
            return null;
        }
        return optionalEmployee.get();    }

    public String updateEmployeeById(Long id,String lastName) {
        Optional<Employee> myEmployeeOpt = employeeRepo.findById(id);
        Employee myEmployee = null;
        if(myEmployeeOpt.isPresent()){
            myEmployee = myEmployeeOpt.get();
        }
        else{
            return "Id Not Found";
        }
        myEmployee.setLastName(lastName);
        employeeRepo.save(myEmployee);
        return "Employee Last Name  Updated";
    }

    public String removeEmployeeById(Long id) {
        employeeRepo.deleteById(id);
        return "Employee Deleted Successful";
    }
}
