package com.accounts.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accounts.entity.Account;

public interface AccountsRepo extends JpaRepository<Account, Long> {

	Optional<Account> findByUserId(Long userId);
		
}