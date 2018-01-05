package com.test.project2backend;

import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.test.project2backend.dao.ClientDao;
import com.test.project2backend.model.Client;

public class ClientTesting 
{

	// we have to declare reference variables here to access it in any method
	private static	AnnotationConfigApplicationContext context;
	
	private static ClientDao clientDao;
	private static Client client;


	@BeforeClass
	public static void init() {
		// making object of AnnotationConfigApplicationContext
		context = new AnnotationConfigApplicationContext();
		// scanning the whole project for making bean objects
		context.scan("com.test.project2backend");
		// refresh the Spring Container
		context.refresh();
		// getting the beans of clientDao type
		clientDao = (ClientDao) context.getBean("clientDao");
		client = new Client();
		
		
	}

	@Test
	public void addClientTest() 
	{
		client.setClientName("Arun");
		client.setClientMobileNo("9876543210");
		client.setClientEmailId("pqrst@gmail.com");
		client.setClientPassword("9876543210");
		client.setClientConfirmPassword("9876543210");
		client.setRole("Client");
		Assert.assertEquals("Data Entered Ureka", true, clientDao.addClient(client));
	}
	/*@Test
	public void deleteClientTest()
	{
		client.setClient_Id(2);
		Assert.assertEquals("Data Entered Ureka", true, clientDao.deleteClient(client));
	}
	@Test
	public void getClientTest()
	{
		client=clientDao.getClient(3);
		Assert.assertNotNull(client);
		System.out.println(client.getClientName());
	}
	@Test
	public void updateClientTest()
	{
		client=clientDao.getClient(3);
		client.setClientName("Aman");
		Assert.assertEquals("Data Entered Ureka", true,clientDao.updateClient(client));
	}
	@Test
	public void getALLClientTest()
	{
		 List<Client> clientList=clientDao.getALLClient();
		 //Assert.assertEquals("Client List",true,!(clientList.isEmpty()));
	}*/
}
