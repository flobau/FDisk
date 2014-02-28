package at.fdisk.core.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Geraet;
import at.fdisk.core.repository.GeraetRepository;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class GeraetRepositoryImplTest extends AbstractJUnit4SpringContextTests {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	GeraetRepository geraetRepository;

	@Before
	public void setup() {
		geraetRepository.deleteAll();
	}

	@Test
	public void testFindByBerechtigung() {
		Geraet g1 = new Geraet("Schlauch", new Date(), new Feuerwehrauto());
		Geraet g2 = new Geraet("Verteiler", new Date(), new Feuerwehrauto());
		Geraet g3 = new Geraet("Pumpe", new Date(), new Feuerwehrauto());
		geraetRepository.save(g1);
		geraetRepository.save(g2);
		geraetRepository.save(g3);
		List<Geraet> geraete = geraetRepository.findByBezeichnung("Pumpe");

		Assert.assertNotNull(geraete);
		Assert.assertEquals(geraete.size(), 1);
		Assert.assertEquals(geraete.get(0).getBezeichnung(),
				g3.getBezeichnung());
	}
}
