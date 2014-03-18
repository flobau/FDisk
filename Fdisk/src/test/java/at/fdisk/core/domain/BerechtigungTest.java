package at.fdisk.core.domain;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.Ignore;
import org.junit.Test;

import at.fdisk.core.domain.Berechtigung;
import at.fdisk.core.domain.User;

@Ignore
public class BerechtigungTest extends AbstractDomainPersistenceTest {
	@Test
	public void testMe() {
		Berechtigung b = new Berechtigung("new Berechtigung",
				new ArrayList<User>());
		assertThat(b.getId(), is(nullValue()));
		entityManager().persist(b);
		assertThat(b.getId(), is(notNullValue()));
	}
}