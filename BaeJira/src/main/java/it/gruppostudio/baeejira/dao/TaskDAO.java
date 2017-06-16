package it.gruppostudio.baeejira.dao;

import it.gruppostudio.baeejira.model.Task;

public interface TaskDAO {

	void persist(Task transientInstance);

	void remove(Task persistentInstance);

	Task merge(Task detachedInstance);

	Task findById(Integer id);

}