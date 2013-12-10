package at.fdisk.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import at.fdisk.util.EnsureService;


@Entity
@Table(name = "berechtigung")
public class Berechtigung extends BasePersistable {

	private static final long serialVersionUID = 5707680569424613530L;
	
	@Size(max = 30)
	@NotNull
	@Column(name = "berechtigung", nullable = false, length = 30)
	private String berechtigung;
	
	@OneToMany
	private Collection<User> berechtigte;

	public Berechtigung(String berechtigung, Collection<User> berechtigte) {
		super();
		EnsureService.notEmpty("berechtigung", berechtigung);
		EnsureService.notNull("berechtigung", berechtigte);
		this.berechtigung = berechtigung;
		this.berechtigte = berechtigte;
	}
	
	public Berechtigung() {
		//for jpa
	}

	public String getBerechtigung() {
		return berechtigung;
	}

	public void setBerechtigung(String berechtigung) {
		this.berechtigung = berechtigung;
	}
	
	public Collection<User> getBerechtigte() {
		return berechtigte;
	}

	public void setBerechtigte(Collection<User> berechtigte) {
		this.berechtigte = berechtigte;
	}
}
