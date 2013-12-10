package at.fdisk.repository;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Ausruestung;
import at.fdisk.domain.Charge;
import at.fdisk.domain.Feuerwehr;
import at.fdisk.repository.ChargeRepository;


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
