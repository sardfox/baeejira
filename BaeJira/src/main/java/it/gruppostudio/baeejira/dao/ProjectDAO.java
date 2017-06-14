package it.gruppostudio.baeejira.dao;

import it.gruppostudio.baeejira.model.Project;

public interface ProjectDAO {

	void persist(Project transientInstance);

	void remove(Project persistentInstance);

	Project merge(Project detachedInstance);

	Project findById(Integer id);

}