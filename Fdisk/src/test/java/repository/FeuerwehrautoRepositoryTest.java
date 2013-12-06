package repository;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import domain.Feuerwehr;
import domain.Feuerwehrauto;
import domain.Geraet;

public class FeuerwehrautoRepositoryTest {

	@Test
	public void testMe() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				RepositoryTestConfiguration.class);
		FeuerwehrautoRepository repository = context.getBean(FeuerwehrautoRepository.class);
		repository.save(new Feuerwehrauto("A", 1, new Feuerwehr(),
				new ArrayList<Geraet>()));

		Feuerwehrauto feuerwehrauto = repository.findById((long) 1);
		Assert.notNull(feuerwehrauto);
		context.close();
	}
}
