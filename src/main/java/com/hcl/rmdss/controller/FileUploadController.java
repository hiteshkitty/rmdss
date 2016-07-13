package com.hcl.rmdss.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.rmdss.model.FileUploadForm;
import com.hcl.rmdss.services.FileUploadSvc;
import com.hcl.rmdss.services.UserSvc;
import com.hcl.rmdssws.model.User;

@Controller
public class FileUploadController {

	@Autowired
	private FileUploadSvc fileUploadSvc;
	@Autowired
	private UserSvc userSvc;
	private static final Logger logger = Logger
			.getLogger(FileUploadController.class);

	@RequestMapping(value = "/uploadData.htm", method = RequestMethod.GET)
	public String displayForm(
			@ModelAttribute(value = "user") com.hcl.rmdssws.model.User user,
			BindingResult bindingResult) {
		return "fileUploadForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
			Model map) {

		List<MultipartFile> files = uploadForm.getFiles();

		List<String> fileNames = new ArrayList<String>();

		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				// Handle file content - multipartFile.getInputStream()

				try {
					// MultipartFile filea = multipartFile.getFileData();
					InputStream inputStream = null;
					OutputStream outputStream = null;
					if (multipartFile.getSize() > 0) {
						inputStream = multipartFile.getInputStream();
						// File realUpload = new File("C:/");
						outputStream = new FileOutputStream("C:\\test111\\"
								+ multipartFile.getOriginalFilename());
						System.out.println("====22=========");
						System.out.println(multipartFile.getOriginalFilename());
						System.out.println("=============");
						int readBytes = 0;
						byte[] buffer = new byte[8192];
						while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
							System.out.println("===ddd=======");
							outputStream.write(buffer, 0, readBytes);
							System.out.println(buffer);
						}
						File file = new File("C:\\test111\\user.xml");
						JAXBContext jaxbContext = JAXBContext
								.newInstance(User.class);

						Unmarshaller jaxbUnmarshaller = jaxbContext
								.createUnmarshaller();
						User user = (User) jaxbUnmarshaller.unmarshal(file);
						System.out.println(user);
						fileUploadSvc.addFileData(user);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

		map.addAttribute("files", fileNames);
		return "fileUploadSuccess";
	}

	@RequestMapping(value = "/saveUser.htm", method = RequestMethod.POST)
	public ModelAndView saveUser(
			@ModelAttribute(value = "user") com.hcl.rmdssws.model.User user,
			BindingResult bindingResult) {
		logger.info("inside saveUser()");
		if (user != null) {
			user = userSvc.addUser(user);
		}
		ModelAndView mav = new ModelAndView("userSuccess", "user", user);

		return mav;

	}
}
