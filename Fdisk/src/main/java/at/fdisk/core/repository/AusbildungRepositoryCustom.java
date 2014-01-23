package at.fdisk.core.repository;

import java.util.Date;
import java.util.List;

import at.fdisk.core.domain.Ausbildung;

public interface AusbildungRepositoryCustom {
    Ausbildung findByBezeichnung(String bezeichnung);
    Ausbildung findByKurzbezeichnung(String kurzbezeichnung);
    List<Ausbildung> findByStartdatum(Date startdatum);
    List<Ausbildung> findByEnddatum(Date enddatum);
}
