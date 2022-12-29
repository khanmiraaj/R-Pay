package com.rpay.service;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpay.dto.MerchantSignDto;
import com.rpay.dto.UserResponseDto;
import com.rpay.entity.User;
import com.rpay.repository.RegisterMerchantRepository;

@Service
public class ValidateMerchantManagementService {

	@Autowired
	private RegisterMerchantRepository registerMerchantRepository;
    
	@Transactional(readOnly = true)
	public UserResponseDto validateMerchant(MerchantSignDto merchantSignDto) {
		UserResponseDto userResponseDto = null;
		userResponseDto = new UserResponseDto();
		Optional<User> optionalUser = null;
		User user = null;
		String mobileNo = merchantSignDto.getMobileNo();
		String enteredPassword = merchantSignDto.getPassword();

		optionalUser = registerMerchantRepository.findByMobileNo(mobileNo);
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
			String registeredPassword = user.getPassword();
			if (StringUtils.equalsIgnoreCase(enteredPassword, registeredPassword)) {
				userResponseDto.setStatusCode("S000");
				userResponseDto.setDescription("login success/valid credential");
			} else {
				userResponseDto.setStatusCode("F000");
				userResponseDto.setDescription("login Failed/Invalid credential");
			}
		} else {
			userResponseDto.setStatusCode("F0001");
			userResponseDto.setDescription("You are not registered with us");
		}

		return userResponseDto;
	}
}
