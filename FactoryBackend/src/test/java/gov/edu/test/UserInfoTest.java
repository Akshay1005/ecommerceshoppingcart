package gov.edu.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gov.edu.dao.UserDao;
import gov.edu.model.UserInfo;

public class UserInfoTest 
{
	@Autowired
	static UserDao userDao;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("gov.edu");
	    context.refresh();
	    
	    userDao=(UserDao)context.getBean("userDao");
	}
	@Ignore
	@Test
	public void registerUserTest() 
	{
		UserInfo user=new UserInfo();
		
		user.setUsername("Naveen");
		user.setPassword("admin");
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setCustomerName("Naveen Reddy");
		user.setCustomerAddr("Hyderabad");
		
		assertTrue("Problem in adding User:",userDao.registerUser(user));
	}
	//@Ignore
	@Test
	public void updateAddress()
	{
		UserInfo user=userDao.getUser("Akshay");
		user.setPassword("admin");
		user.setRole("ROLE_ADMIN");
		
		assertTrue("Problem in Updating the UserDetails:",userDao.updateAddress(user));	
	}
}

