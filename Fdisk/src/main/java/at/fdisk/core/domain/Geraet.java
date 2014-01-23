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

import at.fdisk.core.EnsureService;

/**
 * User: Stefan
 * Date: 12.09.13
 * Time: 17:45
 */
@Entity
@Table(name = "geraet")
public class Geraet  extends BasePersistable {

	private static final long serialVersionUID = 9186456843145873233L;
	
	@Size(max = 30)
	@NotNull
	@Column(name = "bezeichnung", nullable = false, length = 30)
	private String bezeichnung;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	@Column(name = "pruefungstermin", nullable = false)
    private Date pruefungstermin;
    
	@ManyToOne
	@Transient
    private Feuerwehrauto auto;

    public Geraet(String bezeichnung, Date pruefungstermin, Feuerwehrauto auto){
    	EnsureService.notEmpty("bezeichnung", bezeichnung);
    	EnsureService.notNull("pruefungstermin", pruefungstermin);
    	EnsureService.notNull("auto", auto);
        this.bezeichnung = bezeichnung;
        this.pruefungstermin = pruefungstermin;
        this.auto = auto;
    }
    
    public Geraet(){
            bezeichnung = "Musterger�t";
            pruefungstermin = new Date();
            auto = new Feuerwehrauto();
    }


    public String getBezeichnung() {
        return bezeichnung;
    }

    public Date getPruefungstermin() {
        return pruefungstermin;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setPruefungstermin(Date pruefungstermin) {
        this.pruefungstermin = pruefungstermin;
    }

        public Feuerwehrauto getAuto() {
                return auto;
        }

        public void setAuto(Feuerwehrauto auto) {
                this.auto = auto;
        }
    
}