package com.example.onetoonedemo.dao;

import com.example.onetoonedemo.ds.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<Address, Integer> {

}
