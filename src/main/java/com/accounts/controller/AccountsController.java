package com.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.dto.AccountBalanceUpdateReq;
import com.accounts.entity.Account;
import com.accounts.service.AccountsService;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
	
	@Autowired AccountsService booksService;
	
	@GetMapping("")
	public ResponseEntity<List<Account>> getAccounts() {
		return ResponseEntity.ok(booksService.getAllAccoutns());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable("id") Long bookID) {
		return ResponseEntity.ok(booksService.getAccountById(bookID));
	}
	
	@PostMapping("")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		
		return ResponseEntity.ok(booksService.createAccount(account));
	}
	
	@PutMapping("")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
		
		return ResponseEntity.ok(booksService.createAccount(account));
	}
	
	@PostMapping("/update-balance")
	public ResponseEntity<String> updateAccountBalance(@RequestBody AccountBalanceUpdateReq accountBalanceUpdateReq) {
		
		return ResponseEntity.ok(booksService.updateAccountBalance(accountBalanceUpdateReq));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteAccount(@PathVariable("id") Long accountId) {
		booksService.deleteAccount(accountId);
		return ResponseEntity.ok(true);
	}
}