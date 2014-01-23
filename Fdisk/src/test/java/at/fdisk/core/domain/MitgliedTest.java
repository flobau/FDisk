package at.fdisk.core.domain;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Mitglied;

public class MitgliedTest {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	@Before
	public void setup() {
		entityManagerFactory = Persistence.createEntityManagerFactory("fdisk");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	}

	@After
	public void teardown() {
		if (entityManager != null)
			entityManager.getTransaction().commit();
		if (entityManager != null)
			entityManager.close();
		if (entityManagerFactory != null)
			entityManagerFactory.close();
	}

	@Test
	public void testMe() {
		Mitglied m = new Mitglied("S", "R", "FM", new Date(), "PKDF", new Feuerwehr(), new ArrayList<Ausruestung>(), new ArrayList<Ausbildung>());
		entityManager.persist(m);
	}
}