package at.fdisk.repositoryjpa;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import at.fdisk.domain.Ausruestung;
import at.fdisk.domain.Mitglied;
import at.fdisk.repository.AusruestungRepository;

public class AusruestungRepositoryTest {

	@Test
	public void testMe() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				RepositoryTestConfiguration.class);
		AusruestungRepository repository = context
				.getBean(AusruestungRepository.class);
		repository.save(new Ausruestung("Test", new Mitglied(), new Date()));

		Ausruestung ausruestung = repository.findById((long) 1);
		Assert.notNull(ausruestung);
		context.close();
	}
}
