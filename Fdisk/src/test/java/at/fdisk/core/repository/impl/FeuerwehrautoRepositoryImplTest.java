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

import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Geraet;
import at.fdisk.core.repository.FeuerwehrautoRepository;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class FeuerwehrautoRepositoryImplTest extends
		AbstractJUnit4SpringContextTests {
	
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	FeuerwehrautoRepository feuerwehrautoRepository;

	@Before
	public void setup() {
		feuerwehrautoRepository.deleteAll();
	}

	@Test
	public void testFindByBerechtigung() {
		Feuerwehrauto fa1 = new Feuerwehrauto("TLF", 1, new Feuerwehr(),
				new ArrayList<Geraet>());
		Feuerwehrauto fa2 = new Feuerwehrauto("RLF", 1, new Feuerwehr(),
				new ArrayList<Geraet>());
		Feuerwehrauto fa3 = new Feuerwehrauto("MTF", 1, new Feuerwehr(),
				new ArrayList<Geraet>());
		feuerwehrautoRepository.save(fa1);
		feuerwehrautoRepository.save(fa2);
		feuerwehrautoRepository.save(fa3);
		List<Feuerwehrauto> feuerwehrautos = feuerwehrautoRepository
				.findByTyp("RLF");

		Assert.assertNotNull(feuerwehrautos);
		Assert.assertEquals(feuerwehrautos.size(), 1);
		Assert.assertEquals(feuerwehrautos.get(0).getTyp(), fa2.getTyp());
	}
}
