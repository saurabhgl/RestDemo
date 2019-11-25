package com.accenturedemo.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenturedemo.rest.dao.EmployeeDAO;
import com.accenturedemo.rest.model.Employee;
import com.accenturedemo.rest.model.Employees;

@RestController
@RequestMapping(path = "/employees" , produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController 
{
    @Autowired
    private EmployeeDAO employeeDao;
    
    @GetMapping(path="/")
    public Employees getEmployees() 
    {
        return employeeDao.getAllEmployees();
    }
    
    @PostMapping(path= "/", consumes = "application/json")
    public Employees addEmployee(@RequestBody Employee employee)
    {
    	 //Generate resource id
        Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);
        
        //add resource
        employeeDao.addEmployee(employee);
        
        return employeeDao.getAllEmployees();
    }
}
