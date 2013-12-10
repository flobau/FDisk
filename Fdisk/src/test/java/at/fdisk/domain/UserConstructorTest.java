package at.fdisk.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import at.fdisk.domain.Berechtigung;
import at.fdisk.domain.Mitglied;
import at.fdisk.domain.User;

@RunWith(value = Parameterized.class)
public class UserConstructorTest {

	private String username;
	private String passwort;
	private ArrayList<Berechtigung> berechtigungen;
	private Mitglied mitglied;

	public UserConstructorTest(String username, String passwort,
			ArrayList<Berechtigung> berechtigungen, Mitglied mitglied) {
		this.username = username;
		this.passwort = passwort;
		this.berechtigungen = berechtigungen;
		this.mitglied = mitglied;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { //
		{ null, "*", new ArrayList<Berechtigung>(), new Mitglied() },
				{ "", "*", new ArrayList<Berechtigung>(), new Mitglied() },
				{ "A", null, new ArrayList<Berechtigung>(), new Mitglied() },
				{ "A", "", new ArrayList<Berechtigung>(), new Mitglied() },
				{ "A", "*", null, new Mitglied() },
				{ "A", "*", new ArrayList<Berechtigung>(), null } };
		return Arrays.asList(data);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenCreatingWithNullArguments() {
		new User(username, passwort, berechtigungen, mitglied);
	}
}
