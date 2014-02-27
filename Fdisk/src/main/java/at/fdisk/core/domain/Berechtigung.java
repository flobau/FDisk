package at.fdisk.core.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import at.fdisk.core.EnsureService;


@Entity
@Table(name = "berechtigung")
public class Berechtigung extends BasePersistable {

	private static final long serialVersionUID = 5707680569424613530L;
	
	@Size(max = 30)
	@NotNull
	@Column(name = "berechtigungName", nullable = false, length = 30)
	private String berechtigungName;
	
	@OneToMany
	private Collection<User> berechtigte;

	public Berechtigung(String berechtigungName, Collection<User> berechtigte) {
		super();
		EnsureService.notEmpty("berechtigungName", berechtigungName);
		EnsureService.notNull("berechtigte", berechtigte);
		this.berechtigungName = berechtigungName;
		this.berechtigte = berechtigte;
	}
	
	public Berechtigung(String berechtigungName){
		super();
		EnsureService.notEmpty("berechtigungName", berechtigungName);
		this.berechtigungName = berechtigungName;
	}
	
	public Berechtigung() {
		//for jpa
	}

	public String getBerechtigung() {
		return berechtigungName;
	}

	public void setBerechtigung(String berechtigung) {
		this.berechtigungName = berechtigung;
	}
	
	public Collection<User> getBerechtigte() {
		return berechtigte;
	}

	public void setBerechtigte(Collection<User> berechtigte) {
		this.berechtigte = berechtigte;
	}
}
