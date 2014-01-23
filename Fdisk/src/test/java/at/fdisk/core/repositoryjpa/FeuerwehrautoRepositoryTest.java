package at.fdisk.core.repositoryjpa;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Geraet;
import at.fdisk.core.repository.FeuerwehrautoRepository;


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
