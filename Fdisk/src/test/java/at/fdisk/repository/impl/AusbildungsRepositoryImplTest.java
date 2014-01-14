package at.fdisk.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Feuerwehr;
import at.fdisk.repository.AusbildungRepository;
import at.fdisk.repositoryjpa.RepositoryTestConfiguration;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class AusbildungsRepositoryImplTest extends
		AbstractJUnit4SpringContextTests {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	AusbildungRepository ausbildungRepository;

	@Before
	public void setup() {
		ausbildungRepository.deleteAll();
	}

	@Test
	public void testFindByBezeichnung() {
		Ausbildung a1 = new Ausbildung("TEST1", "T1", new Feuerwehr(),
				new Date(), new Date());
		Ausbildung a2 = new Ausbildung("TEST2", "T2", new Feuerwehr(),
				new Date(), new Date());
		Ausbildung a3 = new Ausbildung("TEST3", "T3", new Feuerwehr(),
				new Date(), new Date());
		ausbildungRepository.save(a1);
		ausbildungRepository.save(a2);
		ausbildungRepository.save(a3);
		List<Ausbildung> ausbildung = ausbildungRepository.findByBezeichnung(a1
				.getBezeichnung());

		Assert.assertNotNull(ausbildung);
		Assert.assertEquals(ausbildung.size(), 1);
		Assert.assertEquals(ausbildung.get(0), a1);
	}

	@Test
	public void testFindByKurzbezeichnung() {
		Ausbildung a1 = new Ausbildung("TEST1", "T1", new Feuerwehr(),
				new Date(), new Date());
		Ausbildung a2 = new Ausbildung("TEST2", "T2", new Feuerwehr(),
				new Date(), new Date());
		Ausbildung a3 = new Ausbildung("TEST3", "T3", new Feuerwehr(),
				new Date(), new Date());
		ausbildungRepository.save(a1);
		ausbildungRepository.save(a2);
		ausbildungRepository.save(a3);
		List<Ausbildung> ausbildung = ausbildungRepository
				.findByKurzbezeichnung(a2.getKurz_bezeichnung());

		Assert.assertNotNull(ausbildung);
		Assert.assertEquals(ausbildung.size(), 1);
		Assert.assertEquals(ausbildung.get(0), a2);
	}
}
