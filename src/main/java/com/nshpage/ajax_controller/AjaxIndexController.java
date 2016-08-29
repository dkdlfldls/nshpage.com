package com.nshpage.ajax_controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nshpage.controller.IndexController;
import com.nshpage.models.SMTPAuthenticatior;
import com.nshpage.vo.User;

@RestController
public class AjaxIndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private SMTPAuthenticatior smtp;
	
	@RequestMapping("/asdasdasdasddd")
	public void sendMail() {
		
		smtp.sendMail(null,null,null);
		logger.info("send mail request");
	}
	
	@RequestMapping("/asdasdasasdasdsadsad")
	public User login(User user) {
		logger.info(user.getEmail());
		
		User n = new User();
		n.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		
		return n;
	}
}
