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
	public List<Role> getRoles() throws RuntimeException {
		log.debug("getting all Roles instances");

		try {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// create a query
			Query<Role> theQuery = currentSession.createQuery("from Role", Role.class);
			log.debug("get successful");
			return theQuery.getResultList();
		} catch (Exception e) {
			log.error("get failed", e);
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Role getRole(Integer id) throws RuntimeException {
		log.debug("getting Role instance by id:" + id);

		try {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			Role theRole = currentSession.get(Role.class, id);
			log.debug("get successful");
			return theRole;
		} catch (Exception e) {
			log.error("get failed", e);
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void saveRole(Role theRole) throws RuntimeException {
		log.debug("saving Role instance: " + theRole);

		try {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// save or update Role
			currentSession.saveOrUpdate(theRole);
			log.debug("save successful");
		} catch (Exception e) {
			log.error("save failed", e);
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void deleteRole(Integer id) throws RuntimeException {
		log.debug("deleting Role id:" + id);

		try {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			// delete object with primary key
			Query theQuery = currentSession.createQuery("delete from Role where id=:roleId");
			theQuery.setParameter("roleId", id);
			
			log.debug("delete successful");
		} catch (Exception e) {
			log.error("delete failed", e);
			throw new RuntimeException(e.getMessage());
		}
	}
}
