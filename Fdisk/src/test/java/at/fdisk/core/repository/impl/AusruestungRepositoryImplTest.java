package at.fdisk.core.repository.impl;

import java.util.List;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.repository.AusruestungRepository;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class AusruestungRepositoryImplTest extends
		AbstractJUnit4SpringContextTests {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	AusruestungRepository ausruestungRepository;

	@Before
	public void setup() {
		ausruestungRepository.deleteAll();
	}
	
	@Test
	public void testfindByBezeichnung(){
		Ausruestung a1 = new Ausruestung("Handschuh", new Mitglied(), new Date());
		Ausruestung a2 = new Ausruestung("Stiefel", new Mitglied(), new Date());
		Ausruestung a3 = new Ausruestung("Jacke", new Mitglied(), new Date());
		ausruestungRepository.save(a1);
		ausruestungRepository.save(a2);
		ausruestungRepository.save(a3);
		List<Ausruestung> ausruestungen = ausruestungRepository.findByBezeichnung(a1.getBezeichnung());
		
		Assert.assertNotNull(ausruestungen);
		Assert.assertEquals(ausruestungen.size(), 1);
		Assert.assertEquals(ausruestungen.get(0), a1);
	}
}
