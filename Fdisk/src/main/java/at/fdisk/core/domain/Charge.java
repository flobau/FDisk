package at.fdisk.core.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import at.fdisk.core.EnsureService;

@Entity
@Table(name = "charge")
public class Charge extends Mitglied {

	private static final long serialVersionUID = -4720638043052019587L;

	@Size(max = 15)
	@NotNull
	@Column(name = "fachgebiet", nullable = false, length = 15)
	private String fachgebiet;

	public Charge(String vorname, String nachname, String dienstgrad,
			Date geburtsdatum, String wohnort, Feuerwehr feuerwehr,
			String fachgebiet, Collection<Ausruestung> ausruestungen,
			Collection<Ausbildung> ausbildung) {
		super(vorname, nachname, dienstgrad, geburtsdatum, wohnort, feuerwehr,
				ausruestungen, ausbildung);
		EnsureService.notEmpty("fachgebiet", fachgebiet);
		this.fachgebiet = fachgebiet;
	}

	public Charge(String vorname, String nachname, String dienstgrad,
			Date geburtsdatum, String wohnort, String fachgebiet) {
		super(vorname, nachname, dienstgrad, geburtsdatum, wohnort);
		EnsureService.notEmpty("fachgebiet", fachgebiet);
		this.fachgebiet = fachgebiet;
	}

	public Charge() {
		// for jpa
	}

	public String getFachgebiet() {
		return fachgebiet;
	}

	public void setFachgebiet(String fachgebiet) {
		this.fachgebiet = fachgebiet;
	}
}