package it.gruppostudio.baeejira.dao;

import java.util.List;

import it.gruppostudio.baeejira.model.Role;

public interface RoleDAO {

	/**
	 * Create or Update Role instance
	 * @param theRole
	 * 			the Role to be saved
	 */
	public void saveRole(Role theRole) throws RuntimeException;

	/**
	 * Delete the Role instance
	 * @param id
	 * 			the Role identifier
	 * @return 
	 */
	public int deleteRole(Integer id) throws RuntimeException;

	/**
	 * Retrieve a Role by id
	 * @param id
	 * 			the role identifier
	 * @return
	 * 			the Role instance
	 */
	public Role getRole(Integer id) throws RuntimeException;

	/**
	 * Retieve all Roles
	 * @return
	 * 			a List containing all Role instances
	 */
	public List<Role> getRoles() throws RuntimeException;

}