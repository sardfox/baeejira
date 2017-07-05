package it.gruppostudio.baeejira.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import it.gruppostudio.baeejira.config.SpringConfig;
import it.gruppostudio.baeejira.model.Role;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfig.class })
@Transactional
public class RoleDAOImplTest {

	@Autowired
	@Qualifier("roleDAO")
	private RoleDAO roleDAO;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRoles() {
		List<Role> rolesList = roleDAO.getRoles();
		
		assertNotNull(rolesList);
	}

	@Test
	public void testGetRole() {
		Role role = roleDAO.getRole(1);
		
		assertNotNull(role);
	}

	@Test
	@Rollback(true)
	public void testSaveRole() {
		Role role = new Role();
		role.setName("FakeRole");
		
		roleDAO.saveRole(role);
		
		assertNotNull("Id should be not null", role.getId());
	}

	@Test
	@Rollback(true)
	public void testDeleteRole() {
		int result = roleDAO.deleteRole(999);

		assertNotNull(result);
		assertTrue(result > 0);
	}

}
