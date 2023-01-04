package com.example.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name="provinces")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customers;

    public Province(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Province() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
