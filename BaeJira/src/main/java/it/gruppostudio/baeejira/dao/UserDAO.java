package it.gruppostudio.baeejira.dao;

import it.gruppostudio.baeejira.model.User;

public interface UserDAO {

	void persist(User transientInstance);

	void remove(User persistentInstance);

	User merge(User detachedInstance);

	User findById(Integer id);

}