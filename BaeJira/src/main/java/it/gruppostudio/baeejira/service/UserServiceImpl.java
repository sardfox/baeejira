package it.gruppostudio.baeejira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import it.gruppostudio.baeejira.dao.UserDAO;
import it.gruppostudio.baeejira.model.User;

public class UserServiceImpl implements UserService {
	
	
	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDao;
	
	@Override
	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User theUser) {
		userDao.saveUser(theUser);
	}

	@Override
	@Transactional
	public User getUser(int theId) {
		return userDao.getUser(theId);
	}

	@Override
	@Transactional
	public void deleteUser(int theId) {
		// TODO Auto-generated method stub
		userDao.deleteUser(theId);
	}

}
