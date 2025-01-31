package com.accounts.dto;

public class AccountBalanceUpdateReq {
	private Long userId;
	
	private Long balance;
	

	
	public AccountBalanceUpdateReq(Long userId, Long balance) {
		
		this.userId = userId;
		this.balance = balance;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
}
