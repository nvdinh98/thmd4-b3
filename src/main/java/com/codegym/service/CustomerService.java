package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService{

    private static  final Map<Integer,Customer> customers;

        static {
            customers = new HashMap<>();
            customers.put(1,new Customer(1,"kawa","kawa@gmail.com","tokyo"));
            customers.put(2,new Customer(2,"kudo","kudo@gmail.com","kawaguchi"));
            customers.put(3,new Customer(3,"hikary","hikary@gmail.com","ike"));
            customers.put(4,new Customer(4,"kanto","kanto@gmail.com","mizuko"));
            customers.put(5,new Customer(5,"kemuri","kemuri@gmail.com","chiba"));
        }

        //in danh sach
        @Override
        public List<Customer> findAll() {
            return new ArrayList<>(customers.values());
        }

        //luu danh sach
        @Override
        public void save(Customer customer) {
            customers.put(customer.getId(),customer);
        }

        // tim nguoi bang id
        @Override
        public Customer findCustomerById(int id) {
            return customers.get(id);
        }

        // sua danh sach
        @Override
        public void update(int id, Customer customer) {
            customers.put(id,customer);
        }

        @Override
        public void remove(int id) {
            customers.remove(id);
        }
}
