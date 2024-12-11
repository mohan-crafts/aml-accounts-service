package com.accounts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.entity.Account;
import com.accounts.repo.AccountsRepo;

@Service
public class AccountsService {
	
	@Autowired AccountsRepo accountsRepo;
	
	public List<Account> getAllAccoutns() {
		
		return accountsRepo.findAll();
	}
	
	public Account getAccountById(Long id) {
		
		return accountsRepo.findById(id).get();
	}
	
	public Account createAccount(Account account) {
		
		return accountsRepo.save(account);
	}
	
	public Account updateAccount(Account account) {
		
		return accountsRepo.save(account);
	}
	
	public void deleteAccount(Long accountId) {
		accountsRepo.deleteById(accountId);
	}
}