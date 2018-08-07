package org.example.accountdetails.test;

import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.payload;

import javax.xml.transform.Source;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class AccountServiceTest {

	@Autowired
	private ApplicationContext applicationContext;

	private MockWebServiceClient mockClient;

	@Before
	public void createClient() {
		mockClient = MockWebServiceClient.createClient(applicationContext);
	}

	@Test
	public void customerEndpoint() throws Exception {
		final Source requestPayload = new StringSource(
				"<AccountDetailsRequest xmlns='http://www.example.org/AccountDetailsServiceOperations'><accountNumber>09033333A</accountNumber></AccountDetailsRequest>");
		
		
		final Source responsePayload = new StringSource(				
				"      <ns3:AccountDetailsResponse xmlns:ns2='http://www.example.org/AccountDetails' xmlns:ns3='http://www.example.org/AccountDetailsServiceOperations'> " + 
				"         <ns3:AccountDetails> " + 
				"            <ns2:AccountNumber>02212</ns2:AccountNumber> " + 
				"            <ns2:AccountName>MIguel Gomez </ns2:AccountName> " + 
				"            <ns2:AccountBalance>3500</ns2:AccountBalance>  " + 
				"            <ns2:AccountStatus>Active</ns2:AccountStatus>  " + 
				"         </ns3:AccountDetails>  " + 
				"      </ns3:AccountDetailsResponse>  " 
			);
		
		mockClient.sendRequest(withPayload(requestPayload)).andExpect(payload(responsePayload));		
	}
	
	
}
