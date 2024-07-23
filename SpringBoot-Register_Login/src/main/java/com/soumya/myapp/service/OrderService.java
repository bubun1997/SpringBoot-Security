package com.soumya.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumya.myapp.entity.Orders;
import com.soumya.myapp.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	public Orders saveOrder(Orders order) {
		
		return this.orderRepository.save(order);
	}
	
	public Orders findOrderByCustomerIdAndProductName(Long id,String name) {
		
		return this.orderRepository.findByCustomerIdAndProductName(id, name).orElse(null);
	}
	
	public List<Orders> findOrderByCustomerId(Long id) {
		
		return this.orderRepository.findByCustomerId(id).get();
	}

}
