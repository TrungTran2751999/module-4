package com.example.service;

import com.example.model.Customer;

import java.util.HashMap;
import java.util.List;

public class CustomerService implements ICustomerService {
    public static HashMap<Integer, Customer> listCustomer;
    public static boolean init;

    @Override
    public HashMap<Integer, Customer> findAll() {
        return listCustomer;
    }

    @Override
    public void save(Customer customer) {
        listCustomer.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return listCustomer.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        listCustomer.put(id,customer);
    }

    @Override
    public void remove(int id) {
        listCustomer.remove(id);
    }

}
