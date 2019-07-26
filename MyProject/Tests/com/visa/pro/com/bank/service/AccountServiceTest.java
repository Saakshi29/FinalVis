package com.visa.pro.com.bank.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountServiceTest {

	@Test
	public void tcreateAccount_returns_vaaaaaalid_id_when_balance_gt_minbal() {
		// arrange
		AccountService service = new AccountService();
		// act
		int id = service.createNewAccount("SA", 10001);
		// assert
		assertTrue(id > 0);
	}

}
