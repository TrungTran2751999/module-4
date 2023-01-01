package com.example.service;

import com.example.model.Customer;
import com.example.model.EntityCustomer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Service
public class HibernateCustomerServiceImp implements CustomerService {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;
    static{
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (
                HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Customer> findAll() {
        String queryStr = "SELECT c FROM Customer as c ";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findOne(long id) {
        String queryStr = "SELECT c FROM Customer as c WHERE c.id=:id";
        TypedQuery<Customer> query=entityManager.createQuery(queryStr, Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public Customer save(Customer customer) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            customer.setName(customer.getName());
            customer.setAddress(customer.getAddress());
            customer.setEmail(customer.getEmail());
            session.save(customer);
            transaction.commit();
            return customer;
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }finally {
            if(session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return Collections.emptyList();
    }

    @Override
    public boolean exist(Long id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Long> id) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void delete(List<Customer> customers) {

    }

    @Override
    public void deleteAll() {

    }

}
