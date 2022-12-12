package com.example.onetoonedemo.dao;

import com.example.onetoonedemo.ds.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer,Integer> {
}
