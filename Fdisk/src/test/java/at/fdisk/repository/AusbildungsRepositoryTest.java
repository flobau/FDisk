package at.fdisk.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Feuerwehr;
import at.fdisk.repository.AusbildungRepository;
import at.fdisk.repositoryjpa.RepositoryTestConfiguration;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class AusbildungsRepositoryTest extends AbstractJUnit4SpringContextTests {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	AusbildungRepository ausbildungRepository;

	@Before
	public void setup() {
		ausbildungRepository.deleteAll();
	}

	@Test
	public void testFindAll() {
		ausbildungRepository.save(new Ausbildung("TEST1", "T1",
				new Feuerwehr(), new Date(), new Date()));
		ausbildungRepository.save(new Ausbildung("TEST2", "T2",
				new Feuerwehr(), new Date(), new Date()));
		ausbildungRepository.save(new Ausbildung("TEST3", "T3",
				new Feuerwehr(), new Date(), new Date()));
		List<Ausbildung> ausbildung = ausbildungRepository.findAll();

		Assert.notNull(ausbildung);
		Assert.isTrue(ausbildung.size() == 3);
	}
}
