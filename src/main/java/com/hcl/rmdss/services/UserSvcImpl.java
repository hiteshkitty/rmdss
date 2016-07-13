package com.hcl.rmdss.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.rmdss.dao.UserDAO;
import com.hcl.rmdssws.model.User;
import com.hcl.rmdssws.model.Users;

public class UserSvcImpl implements UserSvc {

	private static final Logger logger = Logger.getLogger(UserSvcImpl.class);

	@Autowired
	UserDAO userDAO;

	@Override
	public User getUserById(int userId) {

		logger.info("inside the getUserById()");
		User user = userDAO.getUserById(userId);
		return user;
	}

	@Override
	public User addUser(User user) {
		logger.info("inside addUser()");
		User usr = userDAO.addUser(user);
		return usr;
	}

	@Override
	public List<User> getUsers(User user) {
		logger.info("inside getUsers()");
		Users users = userDAO.getUser(user);
		return users.getUserList();
	}

}
