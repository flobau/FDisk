package at.fdisk.domain;


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

import at.fdisk.EnsureService;

@Entity
@Table(name = "ausruestung")
public class Ausruestung  extends BasePersistable {

	private static final long serialVersionUID = -5590879199470794514L;
	
	@Size(max = 30)
	@NotNull
	@Column(name = "bezeichnung", nullable = false, length = 30)
	private String bezeichnung;
	
	@ManyToOne
	@Transient
	private Mitglied benutzer;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(name = "datum_ausgegeben", nullable = false)
	private Date ausgegeben;

	public Ausruestung(String bezeichnung, Mitglied benutzer,
			Date ausgegeben) {
		super();
		EnsureService.notEmpty("bezeichnung", bezeichnung);
		EnsureService.notNull("benutzer", benutzer);
		EnsureService.notNull("ausgegeben", ausgegeben);
		this.bezeichnung = bezeichnung;
		this.benutzer = benutzer;
		this.ausgegeben = ausgegeben;
	}

	public Ausruestung() {
		//for jpa
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Mitglied getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Mitglied benutzer) {
		this.benutzer = benutzer;
	}

	public Date getAusgegeben() {
		return ausgegeben;
	}

	public void setAusgegeben(Date ausgegeben) {
		this.ausgegeben = ausgegeben;
	}

}