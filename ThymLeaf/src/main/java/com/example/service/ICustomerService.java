package com.example.service;

import com.example.model.Customer;

import java.util.HashMap;

public interface ICustomerService {
    HashMap<Integer, Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
