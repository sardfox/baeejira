package it.gruppostudio.baeejira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.gruppostudio.baeejira.dao.RoleDAO;
import it.gruppostudio.baeejira.model.Role;

@Service
public class RoleServiceImpl implements RoleService {

	// need to inject customer dao
	@Autowired
	private RoleDAO roleDAO;
	
	/* (non-Javadoc)
	 * @see it.gruppostudio.baeejira.service.RoleService#getRoles()
	 */
	@Override
	public List<Role> getRoles() {
		return roleDAO.getRoles();
	}
}
