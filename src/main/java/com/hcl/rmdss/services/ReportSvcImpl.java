package com.hcl.rmdss.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.hcl.rmdssws.model.User;

public class ReportSvcImpl implements ReportSvc {

	private static final Logger logger = Logger.getLogger(ReportSvcImpl.class);

	public void getGeoSourceReport() {
		logger.info("inside the getGeoSourceReport");
	}

	public void getRgiReport() {
		logger.info("inside the getGeoSourceReport");
	}

	public User getSegmentReport() {
		logger.info("inside the getGeoSourceReport");

		return new User();
	}
}