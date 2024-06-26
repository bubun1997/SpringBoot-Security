package com.soumya.myapp.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soumya.myapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUserName(String userName);

}
