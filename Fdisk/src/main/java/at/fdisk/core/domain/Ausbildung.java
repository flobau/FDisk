package at.fdisk.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.BeanUtils;

import at.fdisk.core.EnsureService;
import at.fdisk.core.events.ausbildung.AusbildungDetails;

@Entity
@Table(name = "ausbildung")
public class Ausbildung extends BasePersistable {

	private static final long serialVersionUID = 4601413807692718572L;

	@Size(max = 30)
	@NotNull
	@Column(name = "bezeichnung", nullable = false, length = 30)
	private String bezeichnung;

	@Size(max = 3)
	@NotNull
	@Column(name = "kurzbezeichnung", nullable = false, length = 3)
	private String kurzBezeichnung;

	@ManyToOne
	@Transient
	private Feuerwehr ort;

	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(name = "startdatum", nullable = false)
	private Date startdatum;

	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(name = "endatum", nullable = false)
	private Date enddatum;

	public Ausbildung(String bezeichnung, String kurz_bezeichnung,
			Feuerwehr ort, Date startdatum, Date enddatum) {
		super();
		EnsureService.notEmpty("bezeichnung", bezeichnung);
		EnsureService.notEmpty("kurz_bezeichnung", kurz_bezeichnung);
		EnsureService.notNull("ort", ort);
		EnsureService.notNull("startdatum", startdatum);
		EnsureService.notNull("enddatum", enddatum);
		this.bezeichnung = bezeichnung;
		this.kurzBezeichnung = kurz_bezeichnung;
		this.ort = ort;
		this.startdatum = startdatum;
		this.enddatum = enddatum;
	}

	public Ausbildung(String bezeichnung, String kurz_bezeichnung,
			Date startdatum, Date enddatum) {
		super();
		EnsureService.notEmpty("bezeichnung", bezeichnung);
		EnsureService.notEmpty("kurz_bezeichnung", kurz_bezeichnung);
		EnsureService.notNull("startdatum", startdatum);
		EnsureService.notNull("enddatum", enddatum);
		this.bezeichnung = bezeichnung;
		this.kurzBezeichnung = kurz_bezeichnung;
		this.startdatum = startdatum;
		this.enddatum = enddatum;
	}

	public Ausbildung() {
		// required for JPA
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getKurz_bezeichnung() {
		return kurzBezeichnung;
	}

	public void setKurz_bezeichnung(String kurz_bezeichnung) {
		this.kurzBezeichnung = kurz_bezeichnung;
	}

	public Feuerwehr getOrt() {
		return ort;
	}

	public void setOrt(Feuerwehr ort) {
		this.ort = ort;
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

	public AusbildungDetails toAusbildungDetails() {
		AusbildungDetails details = new AusbildungDetails();
		BeanUtils.copyProperties(this, details);
		return details;
	}

	public static Ausbildung fromOrderDetails(
			AusbildungDetails ausbildungDetails) {
		Ausbildung ausbildung = new Ausbildung(
				ausbildungDetails.getBezeichnung(),
				ausbildungDetails.getKurz_bezeichnung(),
				ausbildungDetails.getStartdatum(),
				ausbildungDetails.getEnddatum());

		BeanUtils.copyProperties(ausbildungDetails, ausbildung);

		return ausbildung;
	}

	public boolean canBeDeleted() {
		return true;
	}
}