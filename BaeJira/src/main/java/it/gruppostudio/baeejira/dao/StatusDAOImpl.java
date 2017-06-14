package it.gruppostudio.baeejira.dao;
// Generated 14-giu-2017 16.52.42 by Hibernate Tools 5.1.4.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.gruppostudio.baeejira.model.Status;

/**
 * Home object for domain model class Status.
 * @see it.gruppostudio.baeejira.dao.Status
 * @author Hibernate Tools
 */
@Stateless
public class StatusDAOImpl implements StatusDAO {

	private static final Log log = LogFactory.getLog(StatusDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.StatusDAO#persist(it.gruppostudio.baeejira.model.Status)
	 */
	@Override
	public void persist(Status transientInstance) {
		log.debug("persisting Status instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.StatusDAO#remove(it.gruppostudio.baeejira.model.Status)
	 */
	@Override
	public void remove(Status persistentInstance) {
		log.debug("removing Status instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.StatusDAO#merge(it.gruppostudio.baeejira.model.Status)
	 */
	@Override
	public Status merge(Status detachedInstance) {
		log.debug("merging Status instance");
		try {
			Status result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.StatusDAO#findById(java.lang.Integer)
	 */
	@Override
	public Status findById(Integer id) {
		log.debug("getting Status instance with id: " + id);
		try {
			Status instance = entityManager.find(Status.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
