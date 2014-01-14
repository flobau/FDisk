package at.fdisk.repositoryjpa;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Ausruestung;
import at.fdisk.domain.Feuerwehr;
import at.fdisk.domain.Mitglied;
import at.fdisk.repository.MitgliedRepository;


public class MitgliedRepositoryTest {

	@Test
	public void testMe() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				RepositoryTestConfiguration.class);
		MitgliedRepository repository = context
				.getBean(MitgliedRepository.class);
		repository.save(new Mitglied("S", "R", "FM", new Date(), "PKDF",
				new Feuerwehr(), new ArrayList<Ausruestung>(),
				new ArrayList<Ausbildung>()));

		Mitglied mitglied = repository.findById((long) 1);
		Assert.notNull(mitglied);
		context.close();
	}
}
