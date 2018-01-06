package com.test.project2backend;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.project2backend.dao.FriendDao;
import com.test.project2backend.model.Friend;

public class FriendTesting {
	// we have to declare reference variables here to access it in any method
	private static AnnotationConfigApplicationContext context;

	private static FriendDao friendDao;
	private static Friend friend;

	@BeforeClass
	public static void init() {
		// making object of AnnotationConfigApplicationContext
		context = new AnnotationConfigApplicationContext();
		// scanning the whole project for making bean objects
		context.scan("com.test.project2backend");
		// refresh the Spring Container
		context.refresh();
		// getting the beans of friendDao type
		friendDao = (FriendDao) context.getBean("friendDao");
		friend = new Friend();

	}

	@Test
	public void addFriendTest() {
		friend.setFriend_Id(25);
		friend.setFriend_Name("Anuj");
		friend.setUser_Id(26);
		friend.setUser_Name("Aman");
		Assert.assertEquals("Data Entered Ureka", true, friendDao.addFriend(friend));
	}
	 
	@Test
	public void deleteFriendTest() {
		friend=friendDao.getFriend(32);
		Assert.assertEquals("Data Entered Ureka", true, friendDao.deleteFriend(friend));
	}
	
	@Test
	public void getFriendTest() {
		friend = friendDao.getFriend(34);
		Assert.assertNotNull(friend);
		System.out.println(friend.getFriend_Name());
	}
	
	@Test
	public void updateFriendTest() {
		friend = friendDao.getFriend(34);
		friend.setFriend_Name("Ajay");
		Assert.assertEquals("Data Entered Ureka", true, friendDao.updateFriend(friend));
	}
	
	@Test
	public void getALLFriendTest() {
		List<Friend> friendList = friendDao.getALLFriend();
		Iterator<Friend> itr = friendList.iterator();

		Assert.assertEquals(true, itr.hasNext());
	}
}
