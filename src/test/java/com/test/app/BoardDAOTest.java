package com.test.app;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nshpage.repository.UserDAO;
import com.nshpage.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	@Inject
	private UserDAO dao;
	
	@Test
	public void testCreate() throws Exception {
		User user = new User();
		user.setEmail("aaa");
		user.setName("aaa");
		user.setPassword("aaaa");
		dao.create(user);
	}
}
