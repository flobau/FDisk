package at.fdisk.repository;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Charge;
import at.fdisk.domain.Feuerwehr;
import at.fdisk.domain.Feuerwehrauto;
import at.fdisk.domain.Mitglied;
import at.fdisk.repository.FeuerwehrRepository;


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
