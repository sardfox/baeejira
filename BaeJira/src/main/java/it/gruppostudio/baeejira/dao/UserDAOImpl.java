package it.gruppostudio.baeejira.dao;
// Generated 14-giu-2017 16.52.42 by Hibernate Tools 5.1.4.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.gruppostudio.baeejira.model.User;

/**
 * Home object for domain model class User.
 * @see it.gruppostudio.baeejira.dao.User
 * @author Hibernate Tools
 */
@Stateless
public class UserDAOImpl implements UserDAO {

	private static final Log log = LogFactory.getLog(UserDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.UserDAO#persist(it.gruppostudio.baeejira.model.User)
	 */
	@Override
	public void persist(User transientInstance) {
		log.debug("persisting User instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.UserDAO#remove(it.gruppostudio.baeejira.model.User)
	 */
	@Override
	public void remove(User persistentInstance) {
		log.debug("removing User instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.UserDAO#merge(it.gruppostudio.baeejira.model.User)
	 */
	@Override
	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.UserDAO#findById(java.lang.Integer)
	 */
	@Override
	public User findById(Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = entityManager.find(User.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
