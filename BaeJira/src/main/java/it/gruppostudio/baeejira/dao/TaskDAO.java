package it.gruppostudio.baeejira.dao;

import it.gruppostudio.baeejira.model.Task;
import it.gruppostudio.baeejira.model.TaskId;

public interface TaskDAO {

	void persist(Task transientInstance);

	void remove(Task persistentInstance);

	Task merge(Task detachedInstance);

	Task findById(TaskId id);

}