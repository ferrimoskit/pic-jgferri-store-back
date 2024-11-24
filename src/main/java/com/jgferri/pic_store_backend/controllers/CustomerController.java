package com.jgferri.pic_store_backend.controllers;

import com.jgferri.pic_store_backend.domain.customer.Customer;
import com.jgferri.pic_store_backend.dtos.CustomerDTO;
import com.jgferri.pic_store_backend.services.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customer){
        Customer newCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = this.customerService.getAllCustomers();
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }


}
