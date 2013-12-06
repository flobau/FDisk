package repository;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import domain.Ausbildung;
import domain.Charge;
import domain.Feuerwehr;
import domain.Feuerwehrauto;
import domain.Mitglied;

public class FeuerwehrRepositoryTest {

	@Test
	public void testMe() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				RepositoryTestConfiguration.class);
		FeuerwehrRepository repository = context.getBean(FeuerwehrRepository.class);
		repository.save(new Feuerwehr("PKDF", new ArrayList<Mitglied>(),
				new ArrayList<Charge>(), new Mitglied(),
				new ArrayList<Feuerwehrauto>(), new ArrayList<Ausbildung>()));

		Feuerwehr feuerwehr = repository.findById((long) 1);
		Assert.notNull(feuerwehr);
		context.close();
	}
}
