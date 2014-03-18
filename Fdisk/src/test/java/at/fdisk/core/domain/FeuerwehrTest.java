package at.fdisk.core.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Charge;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Mitglied;

@Ignore
public class FeuerwehrTest extends AbstractDomainPersistenceTest {
	@Test
	public void testMe() {
		Feuerwehr f = new Feuerwehr("PKDF", new ArrayList<Mitglied>(),
				new ArrayList<Charge>(), new Mitglied(),
				new ArrayList<Feuerwehrauto>(), new ArrayList<Ausbildung>());
		assertThat(f.getId(), is(nullValue()));
		entityManager().persist(f);
		assertThat(f.getId(), is(notNullValue()));
	}
}