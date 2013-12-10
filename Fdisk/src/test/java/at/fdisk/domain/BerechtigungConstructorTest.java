package at.fdisk.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import at.fdisk.domain.Berechtigung;
import at.fdisk.domain.User;

@RunWith(value = Parameterized.class)
public class BerechtigungConstructorTest {
	private String name;
	private ArrayList<User> berechtigte;

	public BerechtigungConstructorTest(String name, ArrayList<User> berechtigte) {
		this.name = name;
		this.berechtigte = berechtigte;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { null, new ArrayList<User>() },
				{ "", new ArrayList<User>() }, { "A", null } };
		return Arrays.asList(data);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenCreatingWithNullArguments() {
		new Berechtigung(name, berechtigte);
	}
}
