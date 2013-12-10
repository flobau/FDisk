package at.fdisk.repository;

import java.util.Date;
import java.util.List;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Ausruestung;
import at.fdisk.domain.Charge;

public interface ChargeRepositoryCustom {
	List<Charge> findByFachgebiet(String fachgebiet);
	List<Charge> findByVorname(String vorname);
	List<Charge> findByNachname(String nachname);
	List<Charge> findByDienstgrad(String dienstgrad);
	List<Charge> findByGeburtsdatum(Date gebdat);
	List<Charge> findByWohnort(String ort);
	List<Charge> findByAusruestung(Ausruestung ausruestung);
	List<Charge> findByAusbildung(Ausbildung ausbildung);
}
