package at.fdisk.core.repository.impl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import at.fdisk.core.domain.Berechtigung;
import at.fdisk.core.domain.User;
import at.fdisk.core.repository.BerechtigungRepository;
import at.fdisk.core.repositoryjpa.RepositoryTestConfiguration;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class BerechtigungRepositoryImplTest extends
		AbstractJUnit4SpringContextTests {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	BerechtigungRepository berechtigungRepository;

	@Before
	public void setup() {
		berechtigungRepository.deleteAll();
	}

	@Test
	public void testFindByBerechtigung() {
		Berechtigung b1 = new Berechtigung("Admin", new ArrayList<User>());
		Berechtigung b2 = new Berechtigung("Mod", new ArrayList<User>());
		Berechtigung b3 = new Berechtigung("User", new ArrayList<User>());
		berechtigungRepository.save(b1);
		berechtigungRepository.save(b2);
		berechtigungRepository.save(b3);
		Berechtigung berechtigung = berechtigungRepository
				.findByBerechtigung(b2.getBerechtigung());

		Assert.assertNotNull(berechtigung);
		Assert.assertEquals(berechtigung.getBerechtigung(),
				b2.getBerechtigung());
	}
}
