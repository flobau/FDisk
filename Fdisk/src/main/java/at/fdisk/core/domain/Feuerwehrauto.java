package at.fdisk.core.domain;


import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import at.fdisk.core.EnsureService;

/**
 * User: Stefan Date: 12.09.13 Time: 17:45
 */
@Entity
@Table(name = "feuerwehrauto")
public class Feuerwehrauto extends BasePersistable {

	private static final long serialVersionUID = -5699493983403524197L;
	
	@Size(max = 5)
	@NotNull
	@Column(name = "typ", nullable = false, length = 5)
	private String typ;
	
	@NotNull
	@Column(name = "plaetze", nullable = false)
	private int sitzplaetze;
	
	@ManyToOne
	@Transient
	private Feuerwehr feuerwehr;
	
	@OneToMany
	private Collection<Geraet> geraete;
	
	private int key;

	public Feuerwehrauto(String typ, int sitzplaetze, Feuerwehr feuerwehr,
			Collection<Geraet> geraete) {
		super();
		EnsureService.notEmpty("typ", typ);
		EnsureService.not0("sitzplaetze", sitzplaetze);
		EnsureService.notNull("feuerwehr", feuerwehr);
		EnsureService.notNull("geraete", geraete);
		this.typ = typ;
		this.sitzplaetze = sitzplaetze;
		this.feuerwehr = feuerwehr;
		this.geraete = geraete;
	}
	
	public Feuerwehrauto(String typ, int sitzplaetze){
		super();
		EnsureService.notEmpty("typ", typ);
		EnsureService.not0("sitzplaetze", sitzplaetze);
		this.typ = typ;
		this.sitzplaetze = sitzplaetze;
	}
	
	public Feuerwehrauto(String typ, int sitzplaetze, int key){
		super();
		this.typ = typ;
		this.sitzplaetze = sitzplaetze;
		this.key = key;
	}

	public Feuerwehrauto() {
		//required for JPA
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public int getSitzplaetze() {
		return sitzplaetze;
	}

	public void setSitzplaetze(int sitzplaetze) {
		this.sitzplaetze = sitzplaetze;
	}

	public Feuerwehr getFeuerwehr() {
		return feuerwehr;
	}

	public void setFeuerwehr(Feuerwehr feuerwehr) {
		this.feuerwehr = feuerwehr;
	}

	public Collection<Geraet> getGeraete() {
		return geraete;
	}

	public void setGeraete(Collection<Geraet> geraete) {
		this.geraete = geraete;
	}

	public int getKey() {
		return key;
	}
	
	public void setKey(int key){
		this.key = key;
	}
}