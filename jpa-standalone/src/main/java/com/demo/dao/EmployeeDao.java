package com.demo.dao;

import com.demo.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Optional;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    Optional<Employee> findEmployeeByFirstNameAndLastName(String firstName, String lastName);
    Optional<Employee> findEmployeeByEmail(String email);

    @Query("select e from Employee e where e.firstName =?1 or e.salary > ?2")
    Iterable<Employee> findEmployeeBFirstNameAndSalary(String firstName, double salary);

    @Query("select e.salary, count(e) from Employee e group by e.salary having e.salary > ?1")
    Iterable employeeGroupBySalary(double salary);
    Iterable<Employee> findEmployeeBySalaryGreaterThan(double salary);
    @Query(" select a from Employee a where a.salary = (select max  (e.salary) from Employee e)")
    Optional<Employee> findMaxSalaryEmployee();
}
