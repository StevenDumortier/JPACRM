package org.example.dao;

import org.example.entity.Customer;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CustomerDAO {

    public static void create(Customer customerToCreate) {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(customerToCreate);
        tx.commit();
    }

    public static Customer findById(long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Customer customer = entityManager.find(Customer.class, id);
        return customer;

    }
    public static List<Customer> findAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Query findAllQuery = entityManager.createQuery("select c from Customer c");
        return findAllQuery.getResultList();
    }
    public static void delete(Customer customer) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(customer);
        tx.commit();
    }
    public static void deleteCustomerById(long id) {
        //EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        //Customer customer = entityManager.find(Customer.class, id);
        //EntityTransaction tx = entityManager.getTransaction();
        //tx.begin();
        //entityManager.remove(customer);
        //tx.commit();
        Customer customerToDelete = findById(id); //on utilise les fonctions au dessus donc pas besoin de faire transaction et entitymanager
        delete(customerToDelete);
    }
//    public static void deleteCustomerByidV2(long id) {
//        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
//        EntityTransaction tx = entityManager.getTransaction();
//        tx.begin();
//        Query deleteQuery = entityManager.createQuery("delete from Customer c where c.id");
//        deleteQuery.setParameter(1,id);
//        deleteQuery.executeUpdate();
//        tx.commit();
//
//
//
//    }
}
