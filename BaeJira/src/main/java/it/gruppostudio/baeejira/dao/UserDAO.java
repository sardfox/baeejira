package it.gruppostudio.baeejira.dao;

import java.util.List;

import it.gruppostudio.baeejira.model.User;

public interface UserDAO {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);

}