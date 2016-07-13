package com.hcl.rmdss.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.rmdss.services.ReportSvc;
import com.hcl.rmdss.services.UserSvc;
import com.hcl.rmdssws.model.Singleton;
import com.hcl.rmdssws.model.User;

@Controller
@RequestMapping(value = "/")
public class ReportController {

	@Autowired
	private UserSvc userSvc;
	@Autowired
	private ReportSvc reportSvc;

	private static final Logger logger = Logger
			.getLogger(ReportController.class);

	@RequestMapping(value = "/geoSourceReport.htm", method = RequestMethod.GET)
	public String generateGeoSourceReport() {

		logger.info("Inside Generate Geo Source Report");
		return "geoSourceReport";

	}

	@RequestMapping(value = "/rgiReport.htm", method = RequestMethod.GET)
	public String generateRgiReport() {
		System.out.println("Inside RGI Report");
		reportSvc.getRgiReport();
		return "rgiReport";

	}

	@RequestMapping(value = "/displaySegmentReport.htm", method = RequestMethod.GET)
	public ModelAndView displaySegmentReport(
			@ModelAttribute(value = "user") com.hcl.rmdssws.model.User user,
			BindingResult bindingResult) {
		System.out.println("Inside segment Report");
		ModelAndView mnv = new ModelAndView("segmentReport", "user", user);
		mnv.addObject("zeroSearchResults", true);
		return mnv;

	}

	@RequestMapping(value = "/segmentReport.htm", method = RequestMethod.GET)
	public ModelAndView generateSegmentReport(
			@ModelAttribute(value = "user") com.hcl.rmdssws.model.User user,
			BindingResult bindingResult) {
		System.out.println("Inside segment Report");
		Singleton sin = Singleton.getInstance();
		System.out.println(sin.getDate());
		System.out.println(Singleton.class.getClassLoader().getParent());
		List<User> userList = userSvc.getUsers(user);
		// user = userList.get(0);
		ModelAndView mnv = new ModelAndView("segmentReport", "user", userList);
		if (user == null) {
			mnv.addObject("zeroSearchResults", true);
		}
		return mnv;

	}

	@RequestMapping(value = "/addUser.htm")
	public ModelAndView addUser(
			@ModelAttribute(value = "user") com.hcl.rmdssws.model.User user,
			BindingResult bindingResult) {
		System.out.println("addUser");
		ModelAndView mnv = new ModelAndView("segmentReport");
		return mnv;

	}

}