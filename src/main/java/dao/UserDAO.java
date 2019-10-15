package dao;

import models.User;

public interface UserDAO {
	
	public boolean  checkUserByLogin(String login);
	public void insertUser(User user);
	public User getUserByLoginPassword(String login, String password);
	public void updateUser(User user);
	
}
