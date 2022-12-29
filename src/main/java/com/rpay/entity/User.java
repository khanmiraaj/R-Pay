package com.rpay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@Column(name = "bussiness_legal_name")
	protected String bussinessLegalName;
	@Column(name = "email_address")
	protected String emailAddress;
	//@Id
	@Column(name = "mobile_no")
	protected String mobileNo;
	@Column(name = "address")
	protected String addresss;
	@Column(name = "password")
	protected String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBussinessLegalName() {
		return bussinessLegalName;
	}
	public void setBussinessLegalName(String bussinessLegalName) {
		this.bussinessLegalName = bussinessLegalName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddresss() {
		return addresss;
	}
	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", bussinessLegalName=" + bussinessLegalName + ", emailAddress=" + emailAddress
				+ ", mobileNo=" + mobileNo + ", addresss=" + addresss + "]";
	}
	
	
	

}
