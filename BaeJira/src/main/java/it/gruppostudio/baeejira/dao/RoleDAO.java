package it.gruppostudio.baeejira.dao;

import java.util.List;

import it.gruppostudio.baeejira.model.Role;

public interface RoleDAO {

	void persist(Role transientInstance);

	void remove(Role persistentInstance);

	Role merge(Role detachedInstance);

	Role findById(Integer id);

	List<Role> getRoles();

}