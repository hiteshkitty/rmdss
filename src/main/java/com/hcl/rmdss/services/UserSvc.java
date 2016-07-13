package com.hcl.rmdss.services;

import java.util.List;

import com.hcl.rmdssws.model.User;

public interface UserSvc {

	User getUserById(int userId);
	User addUser(User user);
	List<User> getUsers(User user);
}
