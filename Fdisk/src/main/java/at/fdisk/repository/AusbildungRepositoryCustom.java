package at.fdisk.repository;

import java.util.Date;
import java.util.List;

import at.fdisk.domain.Ausbildung;

public interface AusbildungRepositoryCustom {
    List<Ausbildung> findByBezeichnung(String bezeichnung);
    List<Ausbildung> findByKurzbezeichnung(String kurzbezeichnung);
    List<Ausbildung> findByStartdatum(Date startdatum);
    List<Ausbildung> findByEnddatum(Date enddatum);
}
