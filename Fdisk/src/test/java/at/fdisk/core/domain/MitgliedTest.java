package at.fdisk.core.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Mitglied;

@Ignore
public class MitgliedTest extends AbstractDomainPersistenceTest {

	@Test
	public void testMe() {
		Mitglied m = new Mitglied("S", "R", "FM", new Date(), "PKDF",
				new Feuerwehr(), new ArrayList<Ausruestung>(),
				new ArrayList<Ausbildung>());
		assertThat(m.getId(), is(nullValue()));
		entityManager().persist(m);
		assertThat(m.getId(), is(notNullValue()));
	}
}