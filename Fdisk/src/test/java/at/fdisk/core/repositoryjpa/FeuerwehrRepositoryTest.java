package at.fdisk.core.repositoryjpa;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Charge;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.repository.FeuerwehrRepository;


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
