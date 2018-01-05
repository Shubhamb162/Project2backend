package com.test.project2backend.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.test.project2backend.model.Client;

@Component
public interface ClientDao {

	public boolean addClient(Client client);

	public boolean deleteClient(Client client);

	public Client getClient(Integer id);

	public boolean updateClient(Client client);

	public List<Client> getALLClient();

	public Client getClient(String ClientEmailId);

}
