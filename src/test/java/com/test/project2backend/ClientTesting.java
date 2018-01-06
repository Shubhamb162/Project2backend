package com.test.project2backend;

import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.test.project2backend.dao.ClientDao;
import com.test.project2backend.model.Client;

public class ClientTesting {

	// we have to declare reference variables here to access it in any method
	private static AnnotationConfigApplicationContext context;

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
	public void addClientTest() {
		client.setClient_Name("Raj");
		client.setClient_Mobile_No("9876543210");
		client.setClient_Email_Id("abc@gmail.com");
		client.setClient_Password("9876543210");
		client.setClient_Confirm_Password("9876543210");
		client.setRole("Client");
		Assert.assertEquals("Data Entered Ureka", true, clientDao.addClient(client));
	}

	@Test
	public void deleteClientTest() {
		client=clientDao.getClient(23);
		Assert.assertEquals("Data Entered Ureka", true, clientDao.deleteClient(client));
	}

	@Test
	public void getClientTest() {
		client = clientDao.getClient(21);
		Assert.assertNotNull(client);
		System.out.println(client.getClient_Name());
	}

	@Test
	public void updateClientTest() {
		client = clientDao.getClient(21);
		client.setClient_Name("A");
		Assert.assertEquals("Data Entered Ureka", true, clientDao.updateClient(client));
	}

	@Test
	public void getALLClientTest() {
		List<Client> clientList = clientDao.getALLClient();
		Iterator<Client> itr = clientList.iterator();

		Assert.assertEquals(true, itr.hasNext());
	}
}
