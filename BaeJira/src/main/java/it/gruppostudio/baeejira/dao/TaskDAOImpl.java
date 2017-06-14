package it.gruppostudio.baeejira.dao;
// Generated 14-giu-2017 16.52.42 by Hibernate Tools 5.1.4.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.gruppostudio.baeejira.model.Task;
import it.gruppostudio.baeejira.model.TaskId;

/**
 * Home object for domain model class Task.
 * @see it.gruppostudio.baeejira.dao.Task
 * @author Hibernate Tools
 */
@Stateless
public class TaskDAOImpl implements TaskDAO {

	private static final Log log = LogFactory.getLog(TaskDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.TaskDAO#persist(it.gruppostudio.baeejira.model.Task)
	 */
	@Override
	public void persist(Task transientInstance) {
		log.debug("persisting Task instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.TaskDAO#remove(it.gruppostudio.baeejira.model.Task)
	 */
	@Override
	public void remove(Task persistentInstance) {
		log.debug("removing Task instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.TaskDAO#merge(it.gruppostudio.baeejira.model.Task)
	 */
	@Override
	public Task merge(Task detachedInstance) {
		log.debug("merging Task instance");
		try {
			Task result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.TaskDAO#findById(it.gruppostudio.baeejira.model.TaskId)
	 */
	@Override
	public Task findById(TaskId id) {
		log.debug("getting Task instance with id: " + id);
		try {
			Task instance = entityManager.find(Task.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
