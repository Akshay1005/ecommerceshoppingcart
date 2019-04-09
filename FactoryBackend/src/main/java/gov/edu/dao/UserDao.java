package gov.edu.dao;

import gov.edu.model.UserInfo;

public interface UserDao
{
	public boolean registerUser(UserInfo user);
	public boolean updateAddress(UserInfo user);
	public UserInfo getUser(String username);

}
