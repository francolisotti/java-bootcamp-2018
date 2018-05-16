package com.lisotti.topic3.repos;
import com.lisotti.topic3.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepo {

	private List<User> mylist = new ArrayList<>();

	public void removeById(int id) {
		mylist.remove(id);
	}

	public User getByUsername(String username) {
		User searched = new User();
		for (User u: mylist){
			if (u.getUsername().equals(username)){
				searched=u;
			}
		}
		return searched;
	}


	public void save(User user) {
		mylist.add(user);
	}

	public List<User> getAll()
	{
		return mylist;
	}

	public User getById(int id) {
		return mylist.get(id);
	}
}
