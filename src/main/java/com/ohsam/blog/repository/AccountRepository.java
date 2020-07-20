package com.ohsam.blog.repository;

import java.util.List;

import com.ohsam.blog.model.Account;

public interface AccountRepository {

	public void update(Account account);
	public List<Account> findAll();
	public Account findByAccountNumber(String accountNumber);
}
