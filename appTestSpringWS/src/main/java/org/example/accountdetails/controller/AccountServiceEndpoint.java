package org.example.accountdetails.controller;

import org.example.accountdetails.Account;
import org.example.accountdetails.service.AccountService;
import org.example.accountdetailsserviceoperations.AccountDetailsRequest;
import org.example.accountdetailsserviceoperations.AccountDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccountServiceEndpoint {

	private static final String TARGET_NAMESPACE = "http://www.example.org/AccountDetailsServiceOperations"; 
	@Autowired
	private AccountService accountService;
	
	
	//@PayloadRoot 		:  Indica que este método procesará las solicitudes de servicio con el elemento raíz XML
	//@ResponsePayload  :  Indica el tipo que se devolverá en la respuesta SOAP (se convierte en xml)
	//@RequestPayload   :  AccountDetails le dice a Spring que convierta las solicitudes entrantes de tipo AccountDetails, de XML a Java 
	@PayloadRoot(localPart="AccountDetailsRequest",namespace=TARGET_NAMESPACE)	
	public  @ResponsePayload AccountDetailsResponse getAccountDetails(@RequestPayload AccountDetailsRequest _accountDetailsRequest){
		AccountDetailsResponse accountDetailsResponse = new AccountDetailsResponse();
		Account _account = accountService.getAccountDetails(_accountDetailsRequest.getAccountNumber());
		accountDetailsResponse.setAccountDetails(_account);
		return accountDetailsResponse;
	}
	
}
