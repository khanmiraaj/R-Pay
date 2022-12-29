package com.rpay.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpay.dto.UserDto;
import com.rpay.dto.UserResponseDto;
import com.rpay.entity.User;
import com.rpay.repository.RegisterMerchantRepository;

@Service
public class RegisterMerchantMangementService {
	
	@Autowired
	private RegisterMerchantRepository registerMerchantRepository;
	
	@Autowired
	private UserResponseDto responseDto;
	
	@Transactional(readOnly = false)
	public UserResponseDto registerMerchant(UserDto userDto) {
		User user = null;
		Optional<User> optionalUser=null;
		user =new User();
		optionalUser=registerMerchantRepository.findByMobileNo(userDto.getMobileNo());
		
		if(optionalUser.isPresent()) {
			responseDto.setStatusCode("S0001");
			responseDto.setDescription("MobileNo is already registered with us.");
			return responseDto;
		}
		
		BeanUtils.copyProperties(userDto, user);
		try {
			registerMerchantRepository.save(user);
			responseDto.setStatusCode("S000");
			responseDto.setDescription("Merchant registered successfully");
		} catch (Exception e) {
			responseDto.setStatusCode("F000");
			responseDto.setDescription("Failed to Register Merchant");

		}
		return responseDto;

	}
}
