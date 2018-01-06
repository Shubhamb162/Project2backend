package com.test.project2backend.daoImpl;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.test.project2backend.dao.FriendDao;
import com.test.project2backend.model.Friend;

@Repository("friendDao") // for doing all database related operation we have
// to use @Repository annotation
@Transactional
public class FriendDaoImplementation implements FriendDao {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addFriend(Friend friend) {
		try {
			sessionfactory.getCurrentSession().save(friend);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteFriend(Friend friend) {
		try {
			sessionfactory.getCurrentSession().delete(friend);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Friend getFriend(Integer id) {
		return (Friend) sessionfactory.getCurrentSession().get(Friend.class, id);
	}

	@Override
	public boolean updateFriend(Friend friend) {
		try {
			friend.setFriend_Name("xyz");
			sessionfactory.getCurrentSession().update(friend);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> getALLFriend() {
		return (List<Friend>) sessionfactory.getCurrentSession().createQuery("from Friend").getResultList();
	}
}
