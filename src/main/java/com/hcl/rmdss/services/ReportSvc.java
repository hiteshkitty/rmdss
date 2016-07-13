package com.hcl.rmdss.services;

import com.hcl.rmdssws.model.User;

public interface ReportSvc {
	void getGeoSourceReport();

	void getRgiReport();

	User getSegmentReport();

}