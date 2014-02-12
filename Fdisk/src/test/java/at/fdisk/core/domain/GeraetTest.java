package at.fdisk.core.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Geraet;

public class GeraetTest extends AbstractDomainPersistenceTest{
	@Test
	public void testMe() {
		Geraet g = new Geraet("S", new Date(), new Feuerwehrauto());
		assertThat(g.getId(), is(nullValue()));
		entityManager().persist(g);
		assertThat(g.getId(), is(notNullValue()));
	}
}