package com.hcl.rmdss.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.hcl.rmdssws.model.User;
import com.hcl.rmdssws.model.Users;

public class UserDAOImpl implements UserDAO {
	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	RestTemplate restTemplate;

	/* This method gets the user by user id */
	@Override
	public User getUserById(int userId) {
		System.out.println("Inside segment Report");
		User user = restTemplate.getForObject(
				"http://localhost:8080/rmdssws/user/" + userId, User.class);
		System.out.println("user is " + user.getUserId() + "  "
				+ user.getUserName());
		return user;
	}

	@Override
	public User addUser(User user) {
		logger.info("inside the getGeoSourceReport");
		User usr = restTemplate.postForObject(
				"http://localhost:8080/rmdssws/user/addUser", user, User.class);
		return usr;
	}

	@Override
	public Users getUser(User user) {
		logger.info("inside the getGeoSourceReport");
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", user.getUserId() + "");
		map.put("userName", user.getUserName());
		map.put("desg", user.getDesg());

		Users users = new Users();
		users = restTemplate.getForObject(
				"http://localhost:8080/rmdssws/user/users?userId={userId}&userName={userName}&desg={desg}", Users.class, map);

//		for (int i = 0; i < userArray.length; i++) {
//			usrList.add(userArray);
//		}
		return users;
	}

}
