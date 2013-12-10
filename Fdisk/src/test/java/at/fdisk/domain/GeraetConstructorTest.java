package at.fdisk.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import at.fdisk.domain.Feuerwehrauto;
import at.fdisk.domain.Geraet;

@RunWith(value = Parameterized.class)
public class GeraetConstructorTest {

	private String bezeichnung;
	private Date pruefungstermin;
	private Feuerwehrauto auto;

	public GeraetConstructorTest(String bezeichnung, Date pruefungstermin,
			Feuerwehrauto auto) {
		this.bezeichnung = bezeichnung;
		this.pruefungstermin = pruefungstermin;
		this.auto = auto;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{ "", new Date(), new Feuerwehrauto() },
				{ null, new Date(), new Feuerwehrauto() },
				{ "S", null, new Feuerwehrauto() }, { "", new Date(), null } };
		return Arrays.asList(data);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenCreatingWithNullArguments() {
		new Geraet(bezeichnung, pruefungstermin, auto);
	}
}
