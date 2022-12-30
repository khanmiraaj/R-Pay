package com.rpay.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpay.dto.UserDto;
import com.rpay.dto.UserResponseDto;
import com.rpay.entity.MerchantWallet;
import com.rpay.entity.User;
import com.rpay.repository.MerchantWalletRepository;
import com.rpay.repository.RegisterMerchantRepository;

@Service
public class RegisterMerchantMangementService {

	@Autowired
	private RegisterMerchantRepository registerMerchantRepository;

	@Autowired
	private MerchantWalletRepository merchantWalletRepository;

	@Autowired
	private UserResponseDto responseDto;

	@Transactional
	public UserResponseDto registerMerchant(UserDto userDto) {
		User user = null;
		Optional<User> optionalUser = null;
		MerchantWallet merchantWallet = null;
		user = new User();
		optionalUser = registerMerchantRepository.findByMobileNo(userDto.getMobileNo());

		if (optionalUser.isPresent()) {
			responseDto.setStatusCode("F0000");
			responseDto.setDescription("MobileNo is already registered with us.");
			return responseDto;
		}
		BeanUtils.copyProperties(userDto, user);
		String merchantId=generateMerchantId(userDto.getMobileNo(), userDto.getBussinessLegalName());
		user.setMerchantId(merchantId);
		try {
			registerMerchantRepository.save(user);
			merchantWallet = new MerchantWallet();
			merchantWallet.setWalletBalance(0);
			merchantWallet.setWalletId("PAYOUT" + userDto.getMobileNo());
			merchantWallet.setMerchantId(merchantId);
			merchantWalletRepository.saveAndFlush(merchantWallet);
			responseDto.setStatusCode("S0000");
			responseDto.setDescription("Merchant registered successfully");
		} catch (Exception e) {
			responseDto.setStatusCode("F0001");
			responseDto.setDescription("Failed to Register Merchant");

		}
		return responseDto;

	}

	private String generateMerchantId(String mobileNo, String bussinessLegalName) {
		mobileNo = mobileNo.substring(6, 10);
		bussinessLegalName = bussinessLegalName.substring(0, 4).toUpperCase();
		String merchantId = "MERCHANT" + mobileNo + bussinessLegalName;
		return merchantId;

	}
}
