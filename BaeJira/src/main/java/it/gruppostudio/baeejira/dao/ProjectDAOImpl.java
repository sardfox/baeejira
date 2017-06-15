package it.gruppostudio.baeejira.dao;
// Generated 14-giu-2017 16.52.42 by Hibernate Tools 5.1.4.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.gruppostudio.baeejira.model.Project;

/**
 * Home object for domain model class Project.
 * @see it.gruppostudio.baeejira.model.Project
 * @author Hibernate Tools
 */
@Stateless
public class ProjectDAOImpl implements ProjectDAO {

	private static final Log log = LogFactory.getLog(ProjectDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Project transientInstance) {
		log.debug("persisting Project instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(Project persistentInstance) {
		log.debug("removing Project instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public Project merge(Project detachedInstance) {
		log.debug("merging Project instance");
		try {
			Project result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public Project findById(Integer id) {
		log.debug("getting Project instance with id: " + id);
		try {
			Project instance = entityManager.find(Project.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
