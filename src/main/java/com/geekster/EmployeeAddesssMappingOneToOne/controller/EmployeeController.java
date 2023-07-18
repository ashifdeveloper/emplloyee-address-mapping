package com.geekster.EmployeeAddesssMappingOneToOne.controller;

import com.geekster.EmployeeAddesssMappingOneToOne.model.Employee;
import com.geekster.EmployeeAddesssMappingOneToOne.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    //Get All Employees
    @GetMapping ("employees")

        public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
        }

        //Add a Employee

    @PostMapping("employee")
    public String addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }


    //Get An Employee By Id

    @GetMapping("employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }


    //Update Employee By Id

    @PutMapping("employee/{id}/{lastName}")

    public String updateEmployeeById(@PathVariable Long id,@PathVariable String lastName){
        return employeeService.updateEmployeeById(id,lastName);
    }

    // Delete An Employee By Id

    @DeleteMapping("employee/{id}")

    public String removeEmployeeById(@PathVariable Long id){
        return employeeService.removeEmployeeById(id);
    }
}
