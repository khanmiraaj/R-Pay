package com.rpay.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpay.dto.UserDto;
import com.rpay.dto.UserResponseDto;
import com.rpay.service.RegisterMerchantMangementService;

@RestController
@RequestMapping("register")
public class RegisterMerchantController {
	
	@Autowired
	private RegisterMerchantMangementService merchantMangementService;
	
	@PostMapping(value = "/new-merchant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerMerchant(@RequestBody UserDto userDto){	
		UserResponseDto responseDto= merchantMangementService.registerMerchant(userDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

}
