package at.fdisk.core.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Charge;
import at.fdisk.core.domain.Feuerwehr;

public class ChargeTest extends AbstractDomainPersistenceTest {
	@Test
	public void testMe() {
		Charge c = new Charge("S", "T", "FM", new Date(), "PKDF",
				new Feuerwehr(), "R", new ArrayList<Ausruestung>(),
				new ArrayList<Ausbildung>());
		assertThat(c.getId(), is(nullValue()));
		entityManager().persist(c);
		assertThat(c.getId(), is(notNullValue()));
	}
}