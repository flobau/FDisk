package at.fdisk.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Feuerwehr;

@RunWith(value = Parameterized.class)
public class AusbildungConstructorTest {

	private String bezeichnung;	
	private String kurz_bezeichnung;
	private Feuerwehr ort;
	private Date startdatum;
	private Date enddatum;
	
	 public AusbildungConstructorTest(String b, String kb, Feuerwehr ort, Date startdate, Date enddate) {
	        this.bezeichnung = b;
	        this.kurz_bezeichnung = kb;
	        this.ort = ort;
	        this.startdatum = startdate;
	        this.enddatum = enddate;
	    }

	    @Parameterized.Parameters
	    public static Collection<Object[]> data() {
	        Object[][] data = new Object[][]{ //
	                {null, "T", new Feuerwehr(), new Date(), new Date()},
	                {"", "T", new Feuerwehr(), new Date(), new Date()},
	                {"Test", null, new Feuerwehr(), new Date(), new Date()},
	                {"Test", "", new Feuerwehr(), new Date(), new Date()},
	                {"Test", "T", null, new Date(), new Date()},
	                {"Test", "T", new Feuerwehr(), null, new Date()},
	                {"Test", "T", new Feuerwehr(), new Date(), null}
	                };
	        return Arrays.asList(data);
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void whenCreatingWithNullArguments() {
	        new Ausbildung(bezeichnung, kurz_bezeichnung, ort, startdatum, enddatum);
	    }

}
