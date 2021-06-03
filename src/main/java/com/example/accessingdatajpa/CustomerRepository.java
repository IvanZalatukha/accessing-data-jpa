package com.example.accessingdatajpa;

import java.util.List;

import com.example.accessingdatajpa.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByPassword(String password);

    Customer findById(long id);
}