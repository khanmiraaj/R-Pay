package com.rpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpay.dto.LoadFundDto;
import com.rpay.dto.UserResponseDto;
import com.rpay.entity.LoadFund;
import com.rpay.repository.LoadFundRepository;

@Service
public class LoadFundManagementServcie {

	@Autowired
	private LoadFundRepository loadFundRepository;
    
	@Transactional
	public UserResponseDto loadFundIntoWallet(LoadFundDto loadFundDto) {
		UserResponseDto userResponseDto = null;
		userResponseDto = new UserResponseDto();
		LoadFund loadFund = null;
		double amount = Double.valueOf(loadFundDto.getAmount());
		String merchantId = loadFundDto.getMerchantId();
		String remarks = loadFundDto.getRemarks();

		loadFund = new LoadFund();
		loadFund.setAmount(amount);
		loadFund.setRemarks(remarks);
		loadFund.setMerchantId(merchantId);
		loadFund.setStatus("LoadFund Request has been raised");
		try {
			LoadFund loadFundEnity = loadFundRepository.saveAndFlush(loadFund);
			userResponseDto.setStatusCode("S0002");
			userResponseDto.setDescription("LoadFund Request Has been raised succesfully");

		} catch (Exception e) {
			userResponseDto.setStatusCode("F0004");
			userResponseDto.setDescription("Failed to raise loadFundRequest");
		}

		return userResponseDto;
	}
}
