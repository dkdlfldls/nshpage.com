package com.nshpage.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.nshpage.vo.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.nshpage.mapper.UserMapper";

	@Override
	public void create(User user) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", user);
	}

	@Override
	public User read(int user_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int user_id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(User user) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+ ".login", user);
	}
	
	
}
