package com.rpay.dto;

public class UserDto {

	private String bussinessLegalName;

	private String mobileNo;

	private String emailAddress;

	private String address;

	private String password;

	public String getBussinessLegalName() {
		return bussinessLegalName;
	}

	public void setBussinessLegalName(String bussinessLegalName) {
		this.bussinessLegalName = bussinessLegalName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [bussinessLegalName=" + bussinessLegalName + ", mobileNo=" + mobileNo + ", emailAddress="
				+ emailAddress + ", address=" + address + ", password=" + password + "]";
	}

}
