package com.nshpage.service;

import javax.servlet.http.HttpSession;

import com.nshpage.vo.User;

public interface UserService {
	public int join(User user, String sessionCode, String sessionEmail) throws Exception;
	
	public boolean login(User user, HttpSession session) throws Exception;
}
