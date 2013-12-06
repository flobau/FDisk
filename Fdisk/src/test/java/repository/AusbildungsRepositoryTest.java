package repository;

import java.util.Date;

import domain.Ausbildung;
import domain.Feuerwehr;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

public class AusbildungsRepositoryTest {

	@Test
	public void testMe() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				RepositoryTestConfiguration.class);
		AusbildungRepository repository = context
				.getBean(AusbildungRepository.class);
		repository.save(new Ausbildung("TEST", "T", new Feuerwehr(), new Date(), new Date()));

		Ausbildung ausbildung = repository.findById((long) 1);
		Assert.notNull(ausbildung);
		context.close();
	}
}
