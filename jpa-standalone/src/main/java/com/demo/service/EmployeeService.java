package com.demo.service;

import com.demo.dao.EmployeeDao;
import com.demo.entity.Employee;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public  Iterable<Employee> listEmployee(){
        return employeeDao.findAll();
    }
    public Employee findEmployeeByEmail(String email){
        return employeeDao.findEmployeeByEmail(email)
                .orElseThrow(EntityExistsException::new);

    }

    public Iterable groupByEmployee(){
        return employeeDao.employeeGroupBySalary(2000);
    }
    public Iterable<Employee> findEmployeeFirstNameAndSalary(String firstName, double salary){
        return employeeDao.findEmployeeBFirstNameAndSalary(firstName, salary);
    }
    public Employee findEmployeeByFirstAndLastName(String firstName, String lastName){
       return employeeDao.findEmployeeByFirstNameAndLastName(firstName, lastName)
               .orElseThrow(EntityExistsException::new);
    }

    public Iterable<Employee> findEmployeeBySalaryGreaterThan(double salary) {
        return employeeDao.findEmployeeBySalaryGreaterThan(salary);
    }
    public Employee maxSalary(){
        return employeeDao.findMaxSalaryEmployee()
                .orElseThrow(EntityExistsException::new);
    }


}
