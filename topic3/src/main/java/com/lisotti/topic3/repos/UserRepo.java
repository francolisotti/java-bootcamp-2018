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

	public void save(User user) {
		mylist.add(user);
		user.setId(mylist.size());
	}

	public List<User> getAll()
	{
		return mylist;
	}

	public User getById(int id) {
		return mylist.get(id);
	}
}
