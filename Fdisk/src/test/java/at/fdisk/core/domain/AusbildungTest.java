package at.fdisk.core.domain;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Feuerwehr;

@Ignore
public class AusbildungTest extends AbstractDomainPersistenceTest {
	@Test
	public void testMe() {
		Ausbildung aus = new Ausbildung("TestAusbildung", "TA",
				new Feuerwehr(), new Date(), new Date());
		assertThat(aus.getId(), is(nullValue()));
		entityManager().persist(aus);
		assertThat(aus.getId(), is(notNullValue()));
	}
}