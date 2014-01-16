package at.fdisk.repositoryjpa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.Assert;

import at.fdisk.domain.Ausruestung;
import at.fdisk.domain.Mitglied;

public class AusruestungRepositoryTest extends AbstractJpaRepositoryTest {
	@Test
	public void verifyFindByUnknownId() {
		AusruestungJpaRepository AusruestungJpaRepository = new AusruestungJpaRepository();
		AusruestungJpaRepository.setEntityManager(entityManager);

		Ausruestung Ausruestung = AusruestungJpaRepository.findById(1l);

		Assert.assertNull(Ausruestung);
	}

	@Test
	public void verifyFindById() {
		AusruestungJpaRepository AusruestungJpaRepository = new AusruestungJpaRepository();
		AusruestungJpaRepository.setEntityManager(entityManager);

		Ausruestung Ausruestung = new Ausruestung("Handschuh", new Mitglied(),
				new Date());
		AusruestungJpaRepository.persist(Ausruestung);

		Ausruestung Ausruestung2 = AusruestungJpaRepository
				.findById(Ausruestung.getId());

		Assert.assertNotNull(Ausruestung2);
		Assert.assertEquals(Ausruestung, Ausruestung2);
	}

	@Test
	public void findAllWithoutAusruestung() {
		AusruestungJpaRepository AusruestungJpaRepository = new AusruestungJpaRepository();
		AusruestungJpaRepository.setEntityManager(entityManager);

		// expect
		assertThat(AusruestungJpaRepository.findAll().isEmpty(),
				is(equalTo(Boolean.TRUE)));
	}

	@Test
	public void findByIdWithoutAusruestung() {
		AusruestungJpaRepository AusruestungJpaRepository = new AusruestungJpaRepository();
		AusruestungJpaRepository.setEntityManager(entityManager);

		// expect
		assertThat(AusruestungJpaRepository.findById(0l), is(nullValue()));
	}

	@Test
	public void persistAndFindAusruestung() {
		AusruestungJpaRepository AusruestungJpaRepository = new AusruestungJpaRepository();
		AusruestungJpaRepository.setEntityManager(entityManager);

		Ausruestung Ausruestung = new Ausruestung("Handschuh", new Mitglied(),
				new Date());

		AusruestungJpaRepository.persist(Ausruestung);
		assertThat(Ausruestung.getId(), is(notNullValue()));
		Long newId = Ausruestung.getId();

		Ausruestung AusruestungByFind = AusruestungJpaRepository
				.findById(newId);
		assertThat(AusruestungByFind, equalTo(Ausruestung));
	}
}
