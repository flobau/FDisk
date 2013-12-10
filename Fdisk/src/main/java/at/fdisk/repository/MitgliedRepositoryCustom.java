package at.fdisk.repository;

import java.util.Date;
import java.util.List;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Ausruestung;
import at.fdisk.domain.Mitglied;

public interface MitgliedRepositoryCustom {
	List<Mitglied> findByVorname(String vorname);
	List<Mitglied> findByNachname(String nachname);
	List<Mitglied> findByDienstgrad(String dienstgrad);
	List<Mitglied> findByGeburtsdatum(Date gebdat);
	List<Mitglied> findByWohnort(String ort);
	List<Mitglied> findByAusruestung(Ausruestung ausruestung);
	List<Mitglied> findByAusbildung(Ausbildung ausbildung);
}
