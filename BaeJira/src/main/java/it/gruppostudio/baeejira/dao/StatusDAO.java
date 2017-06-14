package it.gruppostudio.baeejira.dao;

import it.gruppostudio.baeejira.model.Status;

public interface StatusDAO {

	void persist(Status transientInstance);

	void remove(Status persistentInstance);

	Status merge(Status detachedInstance);

	Status findById(Integer id);

}