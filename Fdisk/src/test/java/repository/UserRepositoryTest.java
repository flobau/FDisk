package repository;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import domain.Berechtigung;
import domain.Mitglied;
import domain.User;

public class UserRepositoryTest {

	@Test
	public void testMe() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				RepositoryTestConfiguration.class);
		UserRepository repository = context
				.getBean(UserRepository.class);
		repository.save(new User("S", "*", new ArrayList<Berechtigung>(), new Mitglied()));

		User user = repository.findById((long) 1);
		Assert.notNull(user);
		context.close();
	}
}
