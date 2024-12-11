package com.accounts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounts.entity.Account;

public interface AccountsRepo extends JpaRepository<Account, Long> {
		
}