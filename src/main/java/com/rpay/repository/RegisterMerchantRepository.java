package com.rpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rpay.entity.User;

@Repository
public interface RegisterMerchantRepository extends JpaRepository<User, Integer>{

}
