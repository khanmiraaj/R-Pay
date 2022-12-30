package com.rpay.dto;

public class LoadFundDto {

	private String amount;

	private String remarks;

	private String merchantId;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	@Override
	public String toString() {
		return "LoadFundDto [amount=" + amount + ", remarks=" + remarks + ", merchantId=" + merchantId + "]";
	}

}
