package at.fdisk.core.repositoryjpa;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Geraet;
import at.fdisk.core.repository.GeraetRepository;


public class GeraetRepositoryTest {

	@Test
	public void testMe() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				RepositoryTestConfiguration.class);
		GeraetRepository repository = context.getBean(GeraetRepository.class);
		repository.save(new Geraet("S", new Date(), new Feuerwehrauto()));

		Geraet geraet = repository.findById((long) 1);
		Assert.notNull(geraet);
		context.close();
	}
}
