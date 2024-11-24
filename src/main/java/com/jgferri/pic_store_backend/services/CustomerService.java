package com.jgferri.pic_store_backend.services;

import com.jgferri.pic_store_backend.domain.customer.Customer;
import com.jgferri.pic_store_backend.dtos.CustomerDTO;
import com.jgferri.pic_store_backend.respositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    public Customer findCustomerById(Long id) throws Exception{
        return this.repository.findCustomerById(id).orElseThrow(()-> new Exception("Nenhum cliente encontrado"));
    }

    public Customer createCustomer(@RequestBody CustomerDTO customer) {
        Customer newCustomer = new Customer(customer);
        this.saveCustomer(newCustomer);
        return newCustomer;
    }

    private void saveCustomer(Customer customer) {this.repository.save(customer);}
    public List<Customer> getAllCustomers(){ return this.repository.findAll();}
}

