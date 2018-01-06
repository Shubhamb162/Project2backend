package com.test.project2backend.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.test.project2backend.model.Friend;

@Component
public interface FriendDao {

	public boolean addFriend(Friend friend);

	public boolean deleteFriend(Friend friend);

	public Friend getFriend(Integer id);

	public boolean updateFriend(Friend friend);

	public List<Friend> getALLFriend();

}
