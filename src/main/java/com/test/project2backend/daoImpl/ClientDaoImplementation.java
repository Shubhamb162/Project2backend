package com.test.project2backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.project2backend.dao.ClientDao;
import com.test.project2backend.model.Client;

@Repository("clientDao") // for doing all database related operation we have
				// to use @Repository annotation
@Transactional
public class ClientDaoImplementation implements ClientDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addClient(Client client) {
		try {
			sessionFactory.getCurrentSession().persist(client);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteClient(Client client) {
		try {
			sessionFactory.getCurrentSession().delete(client);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Client getClient(Integer id) {
		return (Client) sessionFactory.getCurrentSession().get(Client.class, id);
		
	}

	@Override
	public boolean updateClient(Client client) {
		try {
			sessionFactory.getCurrentSession().update(client);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getALLClient() {
		return sessionFactory.getCurrentSession().createQuery("from Client").getResultList();

	}

	@Override
	public Client getClient(String clientEmailId) {
		return (Client) sessionFactory.getCurrentSession().createQuery("from Client where clientEmailId=:email")
				.setParameter("email", clientEmailId).getSingleResult();
	}

}
