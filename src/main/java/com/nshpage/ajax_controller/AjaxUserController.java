package com.nshpage.ajax_controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nshpage.controller.IndexController;
import com.nshpage.models.SMTPAuthenticatior;
import com.nshpage.models.UserCodeMaker;
import com.nshpage.service.UserServiceImpl;
import com.nshpage.vo.Mail;
import com.nshpage.vo.Result;
import com.nshpage.vo.User;

@RestController
public class AjaxUserController {
	private static final Logger logger = LoggerFactory.getLogger(AjaxUserController.class);
	
	private static final String CHECK_MAIL_TITLE = "nshpage.com 가입을 위한 본인인증 코드 발송입니다.";

	@Inject
	private UserServiceImpl userService;
	
	@Autowired
	private SMTPAuthenticatior smtp;
	@Autowired
	private UserCodeMaker codeMaker;
	
	@RequestMapping(value="/ajax/emailCheck", method=RequestMethod.POST)
	public void sendMail(Mail mailInfo, HttpSession session) {
		
		String code = codeMaker.makeCode();
		//session에 mail정보 저장
		session.setAttribute("check_code", code);
		session.setAttribute("email", mailInfo.getReciver());
		
		smtp.sendMail(mailInfo.getReciver(), code, CHECK_MAIL_TITLE);
		logger.info("send mail request");
	}
	
	@RequestMapping("/ajax/join_request")
	public Result join(User user, HttpSession session) throws Exception {
		logger.info("join request");
		
		Result result = new Result();
		result.setResultInt(userService.join(
				user, 
				(String)session.getAttribute("check_code"), 
				(String)session.getAttribute("email")));
		
		return result;
		
		
		
	}
	
	@RequestMapping("/ajax/login_request")
	public boolean login(User user, HttpSession session) throws Exception {
		logger.info("login request");
		return userService.login(user, session);
		
	}
	
	@RequestMapping("/ajax/checkLogin")
	public boolean checkLogin(HttpSession session) {
		logger.info("check login request");
		if(session.getAttribute("login") != null && (boolean)session.getAttribute("login")) {
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping("/ajax/logout")
	public boolean logout(HttpSession session) {
		logger.info("logout request");
		if (session.getAttribute("login") == null) {
			return false;
		} else {
			session.removeAttribute("login");
			return true;
		}
		
	}
}
