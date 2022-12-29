package com.rpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rpay.entity.User;

@Repository
public interface RegisterMerchantRepository extends JpaRepository<User, String>{
	
	Optional<User> findByMobileNo(String mobileNo);

}
