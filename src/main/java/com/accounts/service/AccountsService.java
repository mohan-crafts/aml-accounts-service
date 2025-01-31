package com.accounts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accounts.dto.AccountBalanceUpdateReq;
import com.accounts.dto.User;
import com.accounts.entity.Account;
import com.accounts.repo.AccountsRepo;

@Service
public class AccountsService {
	
	@Autowired AccountsRepo accountsRepo;
	@Autowired private RestTemplate restTemplate;
	
	public List<Account> getAllAccoutns() {
		
		List<Account> accounts = accountsRepo.findAll();
		for(Account account: accounts) {
			
			 User user = restTemplate.getForObject("http://user-service/users/" + account.getUserId(), User.class);
			 account.setUser(user);
		}
		return accounts;
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

	public String updateAccountBalance(AccountBalanceUpdateReq accountBalanceUpdateReq) {
		Account account = accountsRepo.findByUserId(accountBalanceUpdateReq.getUserId()).get();
		if (account != null) {
			account.setBalance(account.getBalance()+ accountBalanceUpdateReq.getBalance());
			accountsRepo.save(account);
		}
		return null;
	}
}