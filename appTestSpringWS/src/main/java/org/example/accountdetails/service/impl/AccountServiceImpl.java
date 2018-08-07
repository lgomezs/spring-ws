package org.example.accountdetails.service.impl;

import org.example.accountdetails.Account;
import org.example.accountdetails.EnumAccountStatus;
import org.example.accountdetails.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl  implements AccountService{

	public Account getAccountDetails(String account) {		
		return createAccount();
	}
	
	private Account createAccount() {
		Account account = new Account();
		account.setAccountNumber("02212");
		account.setAccountName("MIguel Gomez");
		account.setAccountBalance("3500");
		account.setAccountStatus(EnumAccountStatus.ACTIVE);
		return account;
	}

}
