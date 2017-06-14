package it.gruppostudio.baeejira.dao;
// Generated 14-giu-2017 16.52.42 by Hibernate Tools 5.1.4.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.gruppostudio.baeejira.model.Role;

/**
 * Home object for domain model class Role.
 * @see it.gruppostudio.baeejira.dao.Role
 * @author Hibernate Tools
 */
@Stateless
public class RoleDAOImpl implements RoleDAO {

	private static final Log log = LogFactory.getLog(RoleDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.RoleDAO#persist(it.gruppostudio.baeejira.model.Role)
	 */
	@Override
	public void persist(Role transientInstance) {
		log.debug("persisting Role instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.RoleDAO#remove(it.gruppostudio.baeejira.model.Role)
	 */
	@Override
	public void remove(Role persistentInstance) {
		log.debug("removing Role instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.RoleDAO#merge(it.gruppostudio.baeejira.model.Role)
	 */
	@Override
	public Role merge(Role detachedInstance) {
		log.debug("merging Role instance");
		try {
			Role result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.RoleDAO#findById(java.lang.Integer)
	 */
	@Override
	public Role findById(Integer id) {
		log.debug("getting Role instance with id: " + id);
		try {
			Role instance = entityManager.find(Role.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
