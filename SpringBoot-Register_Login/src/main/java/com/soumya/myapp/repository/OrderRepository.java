package com.soumya.myapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soumya.myapp.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{
	
	Optional<Orders> findByCustomerIdAndProductName(Long id,String productName);
	
	Optional<List<Orders>> findByCustomerId(Long id);

}
