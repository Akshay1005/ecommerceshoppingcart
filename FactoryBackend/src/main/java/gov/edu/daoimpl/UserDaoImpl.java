package gov.edu.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.edu.dao.UserDao;
import gov.edu.model.UserInfo;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao 
{
    @Autowired
    SessionFactory sessionFactory;
    
	public boolean registerUser(UserInfo user) 
    {
    	try
        {
        sessionFactory.getCurrentSession().save(user);
        return true;
        }
        catch(Exception e)
        {
        return false;
	}
}

	public boolean updateAddress(UserInfo user) 
	{
		try
        {
        sessionFactory.getCurrentSession().update(user);
        return true;
        }
        catch(Exception e)
        {
        return false;
        }
	}

	public UserInfo getUser(String username)
	{
		{
		    Session session=sessionFactory.openSession();
	        UserInfo user=session.get(UserInfo.class,username); 
	        session.close();
			return user;
		}
	}
}
