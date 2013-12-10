package at.fdisk.domain;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Ausruestung;
import at.fdisk.domain.Charge;
import at.fdisk.domain.Feuerwehr;

public class ChargeTest {
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
		Charge c = new Charge("S", "T", "FM", new Date(), "PKDF",
				new Feuerwehr(), "R", new ArrayList<Ausruestung>(),
				new ArrayList<Ausbildung>());
		entityManager.persist(c);
	}
}