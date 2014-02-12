package at.fdisk.core.domain;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;

import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Mitglied;

public class AusruestungTest extends AbstractDomainPersistenceTest{
	@Test
	public void testMe() {
		Mitglied m = new Mitglied();
		Ausruestung a = new Ausruestung("Testausruestung", m, new Date());
		assertThat(a.getId(), is(nullValue()));
		entityManager().persist(a);
		assertThat(a.getId(), is(notNullValue()));
	}
}