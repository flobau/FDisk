package at.fdisk.core.repositoryjpa;

import java.util.ArrayList;




import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import at.fdisk.core.domain.Berechtigung;
import at.fdisk.core.domain.User;
import at.fdisk.core.repository.BerechtigungRepository;

public class BerechtigungRepositoryTest {

	@Test
	public void testMe() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				RepositoryTestConfiguration.class);
		BerechtigungRepository repository = context
				.getBean(BerechtigungRepository.class);
		repository.save(new Berechtigung("Admin", new ArrayList<User>()));

		Berechtigung berechtigung = repository.findById((long) 1);
		Assert.notNull(berechtigung);
		context.close();
	}
}
