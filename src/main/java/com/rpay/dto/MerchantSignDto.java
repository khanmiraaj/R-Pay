package com.rpay.dto;

public class MerchantSignDto {

	private String mobileNo;

	private String password;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MerchantSignDto [mobileNo=" + mobileNo + ", password=" + password + "]";
	}

}
