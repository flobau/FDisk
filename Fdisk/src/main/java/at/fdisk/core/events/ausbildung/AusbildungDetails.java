package at.fdisk.core.events.ausbildung;

import java.util.Date;

public class AusbildungDetails {

	private String bezeichnung;
	private String kurz_bezeichnung;
	private Date startdatum;
	private Date enddatum;

	public AusbildungDetails() {
		bezeichnung = null;
	}

	public AusbildungDetails(String key) {
		this.bezeichnung = key;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getKurz_bezeichnung() {
		return kurz_bezeichnung;
	}

	public void setKurz_bezeichnung(String kurz_bezeichnung) {
		this.kurz_bezeichnung = kurz_bezeichnung;
	}

	public Date getStartdatum() {
		return startdatum;
	}

	public void setStartdatum(Date startdatum) {
		this.startdatum = startdatum;
	}

	public Date getEnddatum() {
		return enddatum;
	}

	public void setEnddatum(Date enddatum) {
		this.enddatum = enddatum;
	}
}
