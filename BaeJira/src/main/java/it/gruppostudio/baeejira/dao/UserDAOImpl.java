package it.gruppostudio.baeejira.dao;
import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import it.gruppostudio.baeejira.model.User;

public class UserDAOImpl implements UserDAO {
	
	private static final Log log = LogFactory.getLog(UserDAOImpl.class);
	
	// need to inject the session factory
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() throws RuntimeException {
		
		log.debug("getting Users instance");	
		
		try{
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			// create a query  ... sort by last name
			Query<User> theQuery = 
					currentSession.createQuery("from User order by username",
							User.class);
			
			// execute query and get result list
			List<User> users = theQuery.getResultList();
			
			log.debug("get successful");
			// return the results		
			return users;
			
		}catch(Exception re){
			log.error("get failed", re);
			throw new RuntimeException(re.getMessage());
		}		
	}

	@Override
	public void saveUser(User theUser)  throws RuntimeException{		
		log.debug("saving user instance");		
				
		try{
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			// save/upate the customer ... finally LOL
			currentSession.saveOrUpdate(theUser);			
			log.debug("get successful");			
		}catch(Exception re){
			log.error("get failed", re);
			throw new RuntimeException(re.getMessage());
		}			
	}

	@Override
	public User getUser(int theId) throws RuntimeException{
		log.debug("getting user instance");		
				
		try{
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			// now retrieve/read from database using the primary key			
			User theUser = currentSession.get(User.class,theId);			
			log.debug("get successful");			
			return theUser;
		}catch(Exception re){
			log.error("get failed", re);
			throw new RuntimeException(re.getMessage());
		}
	}

	@Override
	public void deleteUser(int theId) throws RuntimeException{
		log.debug("deleting user instance");		
				
		try{
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			// delete object with primary key
			Query theQuery = 
					currentSession.createQuery("delete from User where id=:userId");
			theQuery.setParameter("userId", theId);
			
			theQuery.executeUpdate();				
			log.debug("get successful");			
		}catch(Exception re){
			log.error("get failed", re);
			throw new RuntimeException(re.getMessage());
		}
	}
	
	
}
