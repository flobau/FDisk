package at.fdisk.core.repositoryjpa;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

import at.fdisk.core.domain.Berechtigung;
import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.domain.User;
import at.fdisk.core.repository.UserRepository;

public class UserRepositoryTest {

	@Test
	public void testMe() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				RepositoryTestConfiguration.class);
		UserRepository repository = context.getBean(UserRepository.class);
		repository.save(new User("S", "*", new Berechtigung(), new Mitglied()));

		User user = repository.findById((long) 1);
		Assert.notNull(user);
		context.close();
	}
}
