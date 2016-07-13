package com.hcl.rmdss.dao;

import java.util.List;

import com.hcl.rmdssws.model.User;
import com.hcl.rmdssws.model.Users;

public interface UserDAO {

	User getUserById(int userId);

	User addUser(User user);
	
//	List<User> getUser(User user);
	Users getUser(User user);
}
