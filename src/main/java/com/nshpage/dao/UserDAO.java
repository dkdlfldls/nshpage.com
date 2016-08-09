package com.nshpage.dao;

import java.util.List;

import com.nshpage.dto.User;

public interface UserDAO {
	public void create(User user) throws Exception;
	
	public User login(User user) throws Exception;
	
	public User read(int user_id) throws Exception;
	
	public void update(User user) throws Exception;
	
	public void delete(int user_id) throws Exception;
	
	public List<User> listAll() throws Exception;
}
