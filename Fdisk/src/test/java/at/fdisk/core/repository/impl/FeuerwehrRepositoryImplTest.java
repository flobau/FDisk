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

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Charge;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.repository.FeuerwehrRepository;
import at.fdisk.core.repositoryjpa.RepositoryTestConfiguration;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class FeuerwehrRepositoryImplTest extends
		AbstractJUnit4SpringContextTests {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	FeuerwehrRepository feuerwehrRepository;

	@Before
	public void setup() {
		feuerwehrRepository.deleteAll();
	}

	@Test
	public void testFindByBerechtigung() {
		Feuerwehr f1 = new Feuerwehr("Purkersdorf", new ArrayList<Mitglied>(),
				new ArrayList<Charge>(), new Mitglied(),
				new ArrayList<Feuerwehrauto>(), new ArrayList<Ausbildung>());
		Feuerwehr f2 = new Feuerwehr("Gablitz", new ArrayList<Mitglied>(),
				new ArrayList<Charge>(), new Mitglied(),
				new ArrayList<Feuerwehrauto>(), new ArrayList<Ausbildung>());
		Feuerwehr f3 = new Feuerwehr("Pressbaum", new ArrayList<Mitglied>(),
				new ArrayList<Charge>(), new Mitglied(),
				new ArrayList<Feuerwehrauto>(), new ArrayList<Ausbildung>());
		feuerwehrRepository.save(f1);
		feuerwehrRepository.save(f2);
		feuerwehrRepository.save(f3);
		List<Feuerwehr> feuerwehren = feuerwehrRepository
				.findByOrt("Purkersdorf");

		Assert.assertNotNull(feuerwehren);
		Assert.assertEquals(feuerwehren.size(), 1);
		Assert.assertEquals(feuerwehren.get(0).getOrt(), f1.getOrt());
	}

}
