package com.hcl.rmdss.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.rmdss.dao.FileUploadDAO;
import com.hcl.rmdssws.model.User;

public class FileUploadSvcImpl implements FileUploadSvc {

	@Autowired
	FileUploadDAO fileUploadDAO;
	
	@Override
	public void addFileData(User user) {
		fileUploadDAO.uploadFileData(user);
	}

}
