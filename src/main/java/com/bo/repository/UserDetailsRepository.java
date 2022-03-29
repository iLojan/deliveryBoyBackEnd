package com.bo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bo.entity.User;


@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
	
}
