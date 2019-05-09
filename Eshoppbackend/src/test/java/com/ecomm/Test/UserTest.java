package com.ecomm.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.DAO.UserDAO;
import com.ecomm.model.User;

public class UserTest {
	static UserDAO userDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	@Test
	public void addUserTest()
	{
		User user=new User();
		user.setMobileNo("8300454514");
		user.setPassword("Appa0369?");
		user.setUsername("ramya");
		user.setRole("ROLE_ADMIN");
		user.setEmail("dramya@gmail.com");
		assertTrue("Problem in User Insertion",userDAO.addUser(user));
	}
	@Ignore
	@Test
	public void updateUserTest()
	{
		User user=userDAO.getUser(112);
	    user.setUsername("ramya");
	    user.setRole("ROLE_ADMIN");
		assertTrue("Problem in Updation",userDAO.updateUser(user));
	}
	@Ignore
	@Test
	public void listUserTest()
	{
		List<User> listUser=userDAO.getUser();
		assertNotNull("No User",listUser);
		
		for(User user:listUser)
		{
			System.out.print(user.getUsername()+" ");
			System.out.print(user.getEmail()+" ");
			
		}
	}
	
	
	
}
