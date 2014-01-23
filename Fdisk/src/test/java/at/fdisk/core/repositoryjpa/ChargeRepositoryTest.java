package at.fdisk.core.repositoryjpa;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Charge;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.repository.ChargeRepository;


public class ChargeRepositoryTest {

	@Test
	public void testMe() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				RepositoryTestConfiguration.class);
		ChargeRepository repository = context.getBean(ChargeRepository.class);
		repository.save(new Charge("S", "R", "FM", new Date(), "PKDF",
				new Feuerwehr(), "R", new ArrayList<Ausruestung>(),
				new ArrayList<Ausbildung>()));

		Charge charge = repository.findById((long) 1);
		Assert.notNull(charge);
		context.close();
	}
}
