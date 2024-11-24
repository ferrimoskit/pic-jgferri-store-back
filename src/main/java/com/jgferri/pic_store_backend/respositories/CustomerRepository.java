package com.jgferri.pic_store_backend.respositories;

import com.jgferri.pic_store_backend.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerById(Long id);
}
