package at.fdisk.core.domain;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Geraet;

public class FeuerwehrautoTest {
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
		Feuerwehrauto f = new Feuerwehrauto("A", 1, new Feuerwehr(),
				new ArrayList<Geraet>());
		entityManager.persist(f);
	}
}