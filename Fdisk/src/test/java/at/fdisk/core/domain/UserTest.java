package at.fdisk.core.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import at.fdisk.core.domain.Berechtigung;
import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.domain.User;

public class UserTest extends AbstractDomainPersistenceTest {

	@Test
	public void testMe() {
		User u = new User("S", "*", new Berechtigung(), new Mitglied());
		assertThat(u.getId(), is(nullValue()));
		entityManager().persist(u);
		assertThat(u.getId(), is(notNullValue()));
	}
}