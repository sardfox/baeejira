package it.gruppostudio.baeejira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.gruppostudio.baeejira.dao.RoleDAO;
import it.gruppostudio.baeejira.model.Role;

@Service
public class RoleServiceImpl implements RoleService {

	// need to inject customer dao
	@Autowired
	@Qualifier("roleDAO")
	private RoleDAO roleDAO;
	
	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.service.RoleService#getRoles()
	 */
	@Override
	@Transactional
	public List<Role> getRoles() {
		return roleDAO.getRoles();
	}
}
