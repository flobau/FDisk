package domain;

import help.EnsureService;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User extends BasePersistable{

	private static final long serialVersionUID = 2056184011070687603L;
	
	@Size(max = 15)
	@NotNull
	@Column(name = "username", nullable = false, length = 15)
	private String username;
	
	@Size(max = 15)
	@NotNull
	@Column(name = "passwort", nullable = false, length = 15)
	private String passwort;
	
	@OneToMany
	private Collection<Berechtigung> berechtigungen;
	
	@ManyToOne
	@Transient
	private Mitglied mitglied;
	
	public User(String username, String passwort,
			Collection<Berechtigung> berechtigungen, Mitglied mitglied) {
		super();
		EnsureService.notEmpty("username", username);
		EnsureService.notEmpty("passwort", passwort);
		EnsureService.notNull("berechtigungen", berechtigungen);
		EnsureService.notNull("mitglied", mitglied);
		this.username = username;
		this.passwort = passwort;
		this.berechtigungen = berechtigungen;
		this.mitglied = mitglied;
	}
	
	public User() {
		//for jpa
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
	public Collection<Berechtigung> getBerechtigungen() {
		return berechtigungen;
	}
	public void setBerechtigungen(Collection<Berechtigung> berechtigungen) {
		this.berechtigungen = berechtigungen;
	}
	public Mitglied getMitglied() {
		return mitglied;
	}
	public void setMitglied(Mitglied mitglied) {
		this.mitglied = mitglied;
	}
}
