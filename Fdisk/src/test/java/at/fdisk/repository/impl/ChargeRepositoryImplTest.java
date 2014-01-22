package at.fdisk.repository.impl;

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

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Ausruestung;
import at.fdisk.domain.Charge;
import at.fdisk.domain.Feuerwehr;
import at.fdisk.repository.ChargeRepository;
import at.fdisk.repositoryjpa.RepositoryTestConfiguration;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class ChargeRepositoryImplTest extends
		AbstractJUnit4SpringContextTests {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	ChargeRepository chargeRepository;

	@Before
	public void setup() {
		chargeRepository.deleteAll();
	}

	@Test
	public void testFindByFachgebiet() {
		Charge c1 = new Charge("Stefan","Reinprecht","Kind",new Date(),"Wien",new Feuerwehr(),"Kind",new ArrayList<Ausruestung>(),new ArrayList<Ausbildung>());
		Charge c2 = new Charge("Flo","Bauernhofer","Mensch",new Date(),"Wien",new Feuerwehr(),"Kind",new ArrayList<Ausruestung>(),new ArrayList<Ausbildung>());
		chargeRepository.save(c1);
		chargeRepository.save(c2);
		List<Charge> charge = chargeRepository
				.findByFachgebiet(c1.getFachgebiet());

		Assert.assertNotNull(charge);
		Assert.assertEquals(charge.size(), 1);
		Assert.assertEquals(charge.get(0).getFachgebiet(),
				c1.getFachgebiet());
	}
}