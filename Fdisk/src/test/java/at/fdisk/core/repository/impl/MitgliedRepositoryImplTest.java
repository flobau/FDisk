package at.fdisk.core.repository.impl;

import java.util.ArrayList;
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

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.repository.MitgliedRepository;
import at.fdisk.core.repositoryjpa.RepositoryTestConfiguration;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class MitgliedRepositoryImplTest extends
		AbstractJUnit4SpringContextTests {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MitgliedRepository mitgliedRepository;

	@Before
	public void setup() {
		mitgliedRepository.deleteAll();
	}

	@Test
	public void testFindByBerechtigung() {
		Mitglied m1 = new Mitglied("Stefan", "R", "FM", new Date(), "PKDF",
				new Feuerwehr(), new ArrayList<Ausruestung>(),
				new ArrayList<Ausbildung>());
		Mitglied m2 = new Mitglied("Martin", "R", "FM", new Date(), "PKDF",
				new Feuerwehr(), new ArrayList<Ausruestung>(),
				new ArrayList<Ausbildung>());
		Mitglied m3 = new Mitglied("Kurt", "R", "FM", new Date(), "PKDF",
				new Feuerwehr(), new ArrayList<Ausruestung>(),
				new ArrayList<Ausbildung>());
		mitgliedRepository.save(m1);
		mitgliedRepository.save(m2);
		mitgliedRepository.save(m3);
		List<Mitglied> mitglieder = mitgliedRepository.findByVorname("Stefan");

		Assert.assertNotNull(mitglieder);
		Assert.assertEquals(mitglieder.size(), 1);
		Assert.assertEquals(mitglieder.get(0).getVorname(), m1.getVorname());
	}
}
