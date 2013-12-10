package at.fdisk.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Ausruestung;
import at.fdisk.domain.Feuerwehr;
import at.fdisk.domain.Mitglied;

@RunWith(value = Parameterized.class)
public class MitgliedConstructorTest {

	private String vorname;
	private String nachname;
	private String dienstgrad;
	private Date geburtsdatum;
	private String wohnort;
	private Feuerwehr feuerwehr;
	private Collection<Ausruestung> ausruestungen;
	private Collection<Ausbildung> ausbildung;

	public MitgliedConstructorTest(String vorname, String nachname,
			String dienstgrad, Date geburtsdatum, String wohnort,
			Feuerwehr feuerwehr, Collection<Ausruestung> ausruestungen,
			Collection<Ausbildung> ausbildung) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.dienstgrad = dienstgrad;
		this.wohnort = wohnort;
		this.feuerwehr = feuerwehr;
		this.ausruestungen = ausruestungen;
		this.ausbildung = ausbildung;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { //
				{ null, "R", "FM", new Date(), "PKDF", new Feuerwehr(), new ArrayList<Ausruestung>(), new ArrayList<Ausbildung>() },
				{ "", "R", "FM", new Date(), "PKDF", new Feuerwehr(), new ArrayList<Ausruestung>(), new ArrayList<Ausbildung>() },
				{ "S", null, "FM", new Date(), "PKDF", new Feuerwehr(), new ArrayList<Ausruestung>(), new ArrayList<Ausbildung>() },
				{ "S", "", "FM", new Date(), "PKDF", new Feuerwehr(), new ArrayList<Ausruestung>(), new ArrayList<Ausbildung>() },
				{ "S", "R", null, new Date(), "PKDF", new Feuerwehr(), new ArrayList<Ausruestung>(), new ArrayList<Ausbildung>() },
				{ "S", "", "", new Date(), "PKDF", new Feuerwehr(), new ArrayList<Ausruestung>(), new ArrayList<Ausbildung>()},
				{ "S", "R", "FM", null, "PKDF", new Feuerwehr(), new ArrayList<Ausruestung>(), new ArrayList<Ausbildung>()},
				{ "S", "R", "FM", new Date(), null, new Feuerwehr(), new ArrayList<Ausruestung>(), new ArrayList<Ausbildung>()},
				{ "S", "R", "FM", new Date(), "", new Feuerwehr(), new ArrayList<Ausruestung>(), new ArrayList<Ausbildung>()},
				{ "S", "R", "FM", new Date(), "PKDF", null, new ArrayList<Ausruestung>(), new ArrayList<Ausbildung>()},
				{ "S", "R", "FM", new Date(), "PKDF", new Feuerwehr(), new ArrayList<Ausruestung>(), new ArrayList<Ausbildung>() },
				{ "S", "R", "FM", new Date(), "PKDF", new Feuerwehr(), null, new ArrayList<Ausbildung>() },
				{ "S", "R", "FM", new Date(), "PKDF", new Feuerwehr(), new ArrayList<Ausruestung>(), null}
				};
		return Arrays.asList(data);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenCreatingWithNullArguments() {
		new Mitglied(vorname, nachname, dienstgrad, geburtsdatum, wohnort,
				feuerwehr, ausruestungen, ausbildung);
	}
}
