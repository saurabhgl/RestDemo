package com.accenturedemo.rest.dao;

import org.springframework.stereotype.Repository;

import com.accenturedemo.rest.model.Employee;
import com.accenturedemo.rest.model.Employees;

@Repository
public class EmployeeDAO 
{
    private static Employees list = new Employees();
    
    // Add static data
    static 
    {
        list.getEmployeeList().add(new Employee(1, "Saurabh", "Goel", "saurabhgoel@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Alex", "Das", "abc@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "David", "Gupta", "titanic@gmail.com"));
    }
    
    public Employees getAllEmployees() 
    {
        return list;
    }
    
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
