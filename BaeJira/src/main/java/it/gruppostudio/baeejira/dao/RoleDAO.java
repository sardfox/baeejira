package it.gruppostudio.baeejira.dao;

import it.gruppostudio.baeejira.model.Role;

public interface RoleDAO {

	void persist(Role transientInstance);

	void remove(Role persistentInstance);

	Role merge(Role detachedInstance);

	Role findById(Integer id);

}