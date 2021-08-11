package com.learninggoods;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import com.learninggoods.controllers.UserController;
import com.learninggoods.dao.entity.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:application-context.xml", "classpath*:dispatcher-servlet.xml",
		"classpath*:spring-security-config.xml" })
public class UserControllerTest {

	@Autowired
	private UserController userController;

	@Test
	public void updateUserProfiles() {
		User u = new User();
		ModelAndView m = userController.updateProfile(u);
		assertNotNull(m);
	}
}
