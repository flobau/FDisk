package at.fdisk.core.domain;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import at.fdisk.core.domain.Berechtigung;
import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.domain.User;

@RunWith(value = Parameterized.class)
public class UserConstructorTest {

	private String username;
	private String passwort;
	private Berechtigung berechtigung;
	private Mitglied mitglied;

	public UserConstructorTest(String username, String passwort,
			Berechtigung berechtigung, Mitglied mitglied) {
		this.username = username;
		this.passwort = passwort;
		this.berechtigung = berechtigung;
		this.mitglied = mitglied;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { //
		{ null, "*", new Berechtigung(), new Mitglied() },
				{ "", "*", new Berechtigung(), new Mitglied() },
				{ "A", null, new Berechtigung(), new Mitglied() },
				{ "A", "", new Berechtigung(), new Mitglied() },
				{ "A", "*", null, new Mitglied() },
				{ "A", "*", new Berechtigung(), null } };
		return Arrays.asList(data);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenCreatingWithNullArguments() {
		new User(username, passwort, berechtigung, mitglied);
	}
}
