package com.soumya.myapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soumya.myapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Optional<Customer> findByCustomerEmail(String uname);

}
