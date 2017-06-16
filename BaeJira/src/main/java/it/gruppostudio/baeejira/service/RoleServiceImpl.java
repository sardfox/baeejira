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
	
	@Override
	@Transactional
	public List<Role> getRoles() throws RuntimeException {
		return roleDAO.getRoles();
	}

	@Override
	@Transactional
	public void saveRole(Role theRole) throws RuntimeException {
		roleDAO.saveRole(theRole);
	}

	@Override
	@Transactional
	public void deleteRole(Integer id) throws RuntimeException {
		roleDAO.deleteRole(id);
	}

	@Override
	@Transactional
	public Role getRole(Integer id) throws RuntimeException {
		return roleDAO.getRole(id);
	}
}
