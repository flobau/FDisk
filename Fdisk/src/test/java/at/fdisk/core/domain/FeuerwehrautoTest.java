package at.fdisk.core.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Geraet;

public class FeuerwehrautoTest extends AbstractDomainPersistenceTest{
	@Test
	public void testMe() {
		Feuerwehrauto f = new Feuerwehrauto("A", 1, new Feuerwehr(),
				new ArrayList<Geraet>());
		assertThat(f.getId(), is(nullValue()));
		entityManager().persist(f);
		assertThat(f.getId(), is(notNullValue()));
	}
}