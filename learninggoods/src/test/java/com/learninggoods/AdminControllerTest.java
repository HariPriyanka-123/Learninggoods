package com.learninggoods;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import com.learninggoods.controllers.AdminController;
import com.learninggoods.dao.entity.Admin;
import com.learninggoods.dao.entity.Course;
import com.learninggoods.dao.entity.Tests;
import com.learninggoods.dao.entity.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:application-context.xml", "classpath*:dispatcher-servlet.xml",
		"classpath*:spring-security-config.xml" })
public class AdminControllerTest {

	@Autowired
	AdminController adminController;

	@Test
	public void registaerAdminUser() {

		Admin admin = new Admin();
		admin.setId("priyatest2@gmail.com");
		admin.setGender("male");
		admin.setName("Priya Warior");
		admin.setPwd("priyatest");
		ModelAndView m = adminController.registerAdmin(admin);
		assertNotNull(m);
	}

	@Test
	public void updateUserByAdmin() {
		User u = new User();
		u.setEmail("hari@gmail.com");
		u.setName("Hari");
		ModelAndView m = adminController.updateUser(u);
		assertNotNull(m);
	}

	@Test
	public void deleteUserbyAdmin() {
		String email = "hari@gmail.com";
		ModelAndView m = adminController.deleteUser(email);
		assertNotNull(m);

	}

	@Test
	public void addTestByAdmin() {

		Tests test = new Tests();
		test.setId("priya@gmail.com");
		test.setNumber(20);
		test.setQuestion("What is JAVA");
		test.setOption1("JAVA JAVA");
		test.setOption2("JAVA1 JAVA1");
		test.setOption3("JAVA2 JAVA1");
		test.setOption4("JAVA13JAVA1");
		ModelAndView m = adminController.addTest(test);
		assertNotNull(m);

	}

	@Test
	public void updateTestsByAdmin() {
		Tests test = new Tests();
		test.setId("priya@gmail.com");
		test.setNumber(20);
		test.setQuestion("What is JAVA");
		test.setOption1("JAVA3 JAVA");
		test.setOption2("JAVA2 JAVA1");
		test.setOption3("JAVA2 JAVA1");
		test.setOption4("JAVA13JAVA1");
		ModelAndView m = adminController.updateTest(test);
		assertNotNull(m);
	}

	@Test
	public void deleteTestsByAdmin() {
		long number = 20;
		ModelAndView m = adminController.deleteTest(number);
		assertNotNull(m);

	}

	@Test
	public void addCourseByAdmin() {
		
		Course c = new Course();
		c.setId(3);
		c.setDesc("Python language");
		c.setTitle("Python");
		c.setUrl("Python language");
		ModelAndView m = adminController.addCourse(c);
		assertNotNull(m);
	}
	
	@Test
	public void updateCourseByAdmin() {
		Course u = new Course();
		u.setTitle("Python");
		u.setId(3);
		ModelAndView m = adminController.updateCourse(u);
		assertNotNull(m);
	}
	
	@Test
	public void deleteCourseByAdmin() {
		long id=3;
		ModelAndView m = adminController.deleteCourse(id);
		assertNotNull(m);
	}
}
