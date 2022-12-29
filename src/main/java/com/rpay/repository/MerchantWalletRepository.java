package com.rpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rpay.entity.MerchantWallet;

@Repository
public interface MerchantWalletRepository extends JpaRepository<MerchantWallet, Integer>{

}
