package at.fdisk.core.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import at.fdisk.core.domain.Berechtigung;
import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.domain.User;
import at.fdisk.core.repository.UserRepository;
import at.fdisk.core.repositoryjpa.RepositoryTestConfiguration;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class UserRepositoryImplTest extends AbstractJUnit4SpringContextTests {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	UserRepository userRepository;

	@Before
	public void setup() {
		userRepository.deleteAll();
	}

	@Test
	public void testFindByBerechtigung() {
		User u1 = new User("A", null, new ArrayList<Berechtigung>(),
				new Mitglied());
		User u2 = new User("B", null, new ArrayList<Berechtigung>(),
				new Mitglied());
		User u3 = new User("C", null, new ArrayList<Berechtigung>(),
				new Mitglied());
		userRepository.save(u1);
		userRepository.save(u2);
		userRepository.save(u3);
		List<User> geraete = userRepository.findByUsername("B");

		Assert.assertNotNull(geraete);
		Assert.assertEquals(geraete.size(), 1);
		Assert.assertEquals(geraete.get(0).getUsername(), u2.getUsername());
	}
}
