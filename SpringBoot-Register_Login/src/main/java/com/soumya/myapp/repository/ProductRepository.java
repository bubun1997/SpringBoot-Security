package com.soumya.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soumya.myapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
