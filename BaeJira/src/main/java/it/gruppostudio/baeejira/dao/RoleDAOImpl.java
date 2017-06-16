package it.gruppostudio.baeejira.dao;
// Generated 14-giu-2017 16.52.42 by Hibernate Tools 5.1.4.Final

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import it.gruppostudio.baeejira.model.Role;

/**
 * Home object for domain model class Role.
 * @see it.gruppostudio.baeejira.model2.Role
 * @author Hibernate Tools
 */
@Repository
public class RoleDAOImpl implements RoleDAO {

	private static final Log log = LogFactory.getLog(RoleDAOImpl.class);

	// need to inject the session factory
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.dao.RoleDAO#findById(java.lang.Integer)
	 */
	@Override
	public List<Role> getRoles() {
		log.debug("getting Roles instance");
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			// create a query
			Query<Role> theQuery = currentSession.createQuery("from Role", Role.class);
			log.debug("get successful");
			return theQuery.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public void persist(Role transientInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Role persistentInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role merge(Role detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
