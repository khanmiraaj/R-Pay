package com.rpay.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpay.dto.MerchantSignDto;
import com.rpay.dto.UserResponseDto;
import com.rpay.service.ValidateMerchantManagementService;

@RestController
@RequestMapping("validate")
public class ValidateMerchantController {

	@Autowired
	private ValidateMerchantManagementService merchantManagementService;

	@PostMapping("/merchant")
	public ResponseEntity<?> validateMerchant(@RequestBody MerchantSignDto merchantSignDto) {
		UserResponseDto userResponseDto = merchantManagementService.validateMerchant(merchantSignDto);
		return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
	}
}
