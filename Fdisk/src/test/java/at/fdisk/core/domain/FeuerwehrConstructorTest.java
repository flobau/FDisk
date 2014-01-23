package at.fdisk.core.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Charge;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Mitglied;

@RunWith(value = Parameterized.class)
public class FeuerwehrConstructorTest {

	private String ort;
	private ArrayList<Mitglied> mitglieder;
	private ArrayList<Charge> chargen;
	private Mitglied kommandant;
	private ArrayList<Feuerwehrauto> autos;
	private ArrayList<Ausbildung> ausbildungen;

	public FeuerwehrConstructorTest(String ort, ArrayList<Mitglied> mitglieder,
			ArrayList<Charge> chargen, Mitglied kommandant,
			ArrayList<Feuerwehrauto> autos, ArrayList<Ausbildung> ausbildungen) {
		this.ort = ort;
		this.mitglieder = mitglieder;
		this.chargen = chargen;
		this.kommandant = kommandant;
		this.autos = autos;
		this.ausbildungen = ausbildungen;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { //
				{ "", new ArrayList<Mitglied>(), new ArrayList<Charge>(),
						new Mitglied(), new ArrayList<Feuerwehrauto>(),
						new ArrayList<Ausbildung>() },
				{ "PKDF", null, new ArrayList<Charge>(), new Mitglied(),
						new ArrayList<Feuerwehrauto>(),
						new ArrayList<Ausbildung>() },
				{ "", new ArrayList<Mitglied>(), null, new Mitglied(),
						new ArrayList<Feuerwehrauto>(),
						new ArrayList<Ausbildung>() },
				{ "", new ArrayList<Mitglied>(), new ArrayList<Charge>(), null,
						new ArrayList<Feuerwehrauto>(),
						new ArrayList<Ausbildung>() },
				{ "", new ArrayList<Mitglied>(), new ArrayList<Charge>(),
						new Mitglied(), null, new ArrayList<Ausbildung>() },
				{ "", new ArrayList<Mitglied>(), new ArrayList<Charge>(),
						new Mitglied(), new ArrayList<Feuerwehrauto>(), null } };
		return Arrays.asList(data);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenCreatingWithNullArguments() {
		new Feuerwehr(ort, mitglieder, chargen, kommandant, autos, ausbildungen);
	}
}
