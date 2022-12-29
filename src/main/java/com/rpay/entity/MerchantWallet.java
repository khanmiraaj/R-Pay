package com.rpay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallet")
public class MerchantWallet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@Column(name = "wallet_balance")
	protected double walletBalance;
	@Column(name = "wallet_id")
	protected String walletId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

}
