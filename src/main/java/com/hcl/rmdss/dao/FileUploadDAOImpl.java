package com.hcl.rmdss.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.rmdss.services.UserSvc;
import com.hcl.rmdssws.model.User;

public class FileUploadDAOImpl implements FileUploadDAO {

//	@Autowired
//	UserSvc userWSSvc;
	@Autowired
	UserDAO userDAO;
	
	@Override
	public void uploadFileData(User user) {
		userDAO.addUser(user);
	}

}
