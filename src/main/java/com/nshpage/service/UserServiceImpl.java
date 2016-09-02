package com.nshpage.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.nshpage.controller.IndexController;
import com.nshpage.repository.UserDAO;
import com.nshpage.vo.User;

@Service
public class UserServiceImpl implements UserService {
	public static final int SUCCESS = 0;
	public static final int DIFFERENT_EMAIL = 1;
	public static final int DIFFERENT_CODE = 2;
	
	@Inject
	private UserDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Override
	public int join(User user, String sessionCode, String sessionEmail) throws Exception {
		// TODO Auto-generated method stub
		//logger.info("join request");
		
		//1. 로깅
		if (!user.getEmail().equals(sessionEmail) ) {
			return DIFFERENT_EMAIL;
		} else if (!user.getCheck_code().equals(sessionCode)) {
			return DIFFERENT_CODE;
		} else {
			//db 가입 처리추가할것
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			
			
			dao.create(user);
			return SUCCESS;
		}
	}

	@Override
	public boolean login(User user, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		//logger.info("login_request");
		//db에서 pw를 가져와서 BCrypr로 확인해야한다.
		User tempUser = dao.login(user);
		System.out.println("1111111111");
		if (tempUser != null) {
			if (BCrypt.checkpw(user.getPassword(), tempUser.getPassword())) {
				session.setAttribute("user_id", tempUser.getUser_id());
				session.setAttribute("name", tempUser.getName());
				session.setAttribute("email", tempUser.getEmail());
				session.setAttribute("login", true);
				return true;
			} else {
				session.setAttribute("login", false);
				return false;
			}
			
		} else {
			session.setAttribute("login", false);
			return false;
			
		}
	}
	
	
}
