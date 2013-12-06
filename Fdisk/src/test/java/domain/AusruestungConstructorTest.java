package domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class AusruestungConstructorTest {

	private String bezeichnung;	
	private Mitglied benutzer;
	private Date ausgegeben;
	
	 public AusruestungConstructorTest(String bezeichnung, Mitglied benutzer,
				Date ausgegeben) {
	        this.bezeichnung = bezeichnung;
	        this.benutzer = benutzer;
	        this.ausgegeben = ausgegeben;
	    }

	    @Parameterized.Parameters
	    public static Collection<Object[]> data() {
	        Object[][] data = new Object[][]{ //
	                {"", new Mitglied(), new Date()},
	                {null, new Mitglied(), new Date()},
	                {"Test", null, new Date()},
	                {"Test", new Mitglied(), null}
	                };
	        return Arrays.asList(data);
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void whenCreatingWithNullArguments() {
	        new Ausruestung(bezeichnung, benutzer, ausgegeben);
	    }

}
