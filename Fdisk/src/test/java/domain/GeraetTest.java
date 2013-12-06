package domain;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GeraetTest {
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
		Geraet g = new Geraet("S", new Date(), new Feuerwehrauto());
		entityManager.persist(g);
	}
}