package at.fdisk.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import at.fdisk.core.EnsureService;

@Entity
@Table(name = "user")
public class User extends BasePersistable {

	private static final long serialVersionUID = 2056184011070687603L;

	@Size(max = 15)
	@NotNull
	@Column(name = "username", nullable = false, length = 15, unique = true)
	private String username;

	@Size(max = 15)
	@NotNull
	@Column(name = "passwort", nullable = false, length = 15)
	private String passwort;

	@ManyToOne
	private Berechtigung berechtigung;

	@ManyToOne
	@Transient
	private Mitglied mitglied;

	public User(String username, String passwort, Berechtigung berechtigung,
			Mitglied mitglied) {
		super();
		EnsureService.notEmpty("username", username);
		EnsureService.notEmpty("passwort", passwort);
		EnsureService.notNull("berechtigungen", berechtigung);
		EnsureService.notNull("mitglied", mitglied);
		this.username = username;
		this.passwort = passwort;
		this.berechtigung = berechtigung;
		this.mitglied = mitglied;
	}

	public User() {
		// for jpa
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public Berechtigung getBerechtigung() {
		return berechtigung;
	}

	public void setBerechtigung(Berechtigung berechtigung) {
		this.berechtigung = berechtigung;
	}

	public Mitglied getMitglied() {
		return mitglied;
	}

	public void setMitglied(Mitglied mitglied) {
		this.mitglied = mitglied;
	}
}
