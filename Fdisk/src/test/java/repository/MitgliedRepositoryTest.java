package repository;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import domain.Ausbildung;
import domain.Ausruestung;
import domain.Feuerwehr;
import domain.Mitglied;

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
