package at.fdisk.repositoryjpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Feuerwehr;
import at.fdisk.repositoryjpa.AusbildungJpaRepository;

public class AusbildungJpaRepositoryTest extends AbstractJpaRepositoryTest {
	@Test
	public void verifyFindByUnknownId() {
		AusbildungJpaRepository ausbildungJpaRepository = new AusbildungJpaRepository();
		ausbildungJpaRepository.setEntityManager(entityManager);

		Ausbildung ausbildung = ausbildungJpaRepository.findById(1l);

		Assert.assertNull(ausbildung);
	}

	@Test
	public void verifyFindById() {
		AusbildungJpaRepository ausbildungJpaRepository = new AusbildungJpaRepository();
		ausbildungJpaRepository.setEntityManager(entityManager);

		Ausbildung ausbildung = new Ausbildung("Test", "T", new Feuerwehr(),
				new Date(), new Date());
		ausbildungJpaRepository.persist(ausbildung);

		Ausbildung ausbildung2 = ausbildungJpaRepository.findById(ausbildung
				.getId());

		Assert.assertNotNull(ausbildung2);
		Assert.assertEquals(ausbildung, ausbildung2);
	}

	@Test
	public void findAllWithoutAusbildung() {
		AusbildungJpaRepository ausbildungJpaRepository = new AusbildungJpaRepository();
		ausbildungJpaRepository.setEntityManager(entityManager);

		// expect
		assertThat(ausbildungJpaRepository.findAll().isEmpty(),
				is(equalTo(Boolean.TRUE)));
	}

	@Test
	public void findByIdWithoutAusbildung() {
		AusbildungJpaRepository ausbildungJpaRepository = new AusbildungJpaRepository();
		ausbildungJpaRepository.setEntityManager(entityManager);

		// expect
		assertThat(ausbildungJpaRepository.findById(0l), is(nullValue()));
	}

	@Test
	public void persistAndFindAusbildung() {
		AusbildungJpaRepository ausbildungJpaRepository = new AusbildungJpaRepository();
		ausbildungJpaRepository.setEntityManager(entityManager);

		Ausbildung ausbildung = new Ausbildung("Atemschutz", "AS",
				new Feuerwehr(), new Date(), new Date());

		ausbildungJpaRepository.persist(ausbildung);
		assertThat(ausbildung.getId(), is(notNullValue()));
		Long newId = ausbildung.getId();

		Ausbildung ausbildungByFind = ausbildungJpaRepository.findById(newId);
		assertThat(ausbildungByFind, equalTo(ausbildung));
	}
}
