package com.example.service;

import com.example.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {
    List<Customer> findAll();
    Customer findOne(long id);
    Customer save(Customer customer);
    List<Customer> save(List<Customer> customers);
    boolean exist(Long id);
    List<Customer> findAll(List<Long> id);
    int count();
    void delete(Long id);
    void delete(Customer customer);
    void delete(List<Customer> customers);
    void deleteAll();
}
