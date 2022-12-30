package com.rpay.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpay.dto.LoadFundDto;
import com.rpay.dto.UserResponseDto;
import com.rpay.service.LoadFundManagementServcie;

@RestController
@RequestMapping("/loadfund")
public class LoadFundController {
	
	@Autowired
	private LoadFundManagementServcie loadFundManagementServcie;

	@PostMapping(value = "/wallet", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> loadFundIntoWallet(@RequestBody LoadFundDto loadFundDto) {
		UserResponseDto userResponseDto = loadFundManagementServcie.loadFundIntoWallet(loadFundDto);
		return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
	}	
}
