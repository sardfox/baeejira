package it.gruppostudio.baeejira.service;

import java.util.List;

import it.gruppostudio.baeejira.model.User;

public interface UserService {
	
	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);

}
