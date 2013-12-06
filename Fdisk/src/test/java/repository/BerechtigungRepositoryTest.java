package repository;

import java.util.ArrayList;

import domain.Berechtigung;
import domain.User;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

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
