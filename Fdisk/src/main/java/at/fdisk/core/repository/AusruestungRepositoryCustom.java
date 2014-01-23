package at.fdisk.core.repository;

import java.util.Date;
import java.util.List;

import at.fdisk.core.domain.Ausruestung;

public interface AusruestungRepositoryCustom {
	List<Ausruestung> findByBezeichnung(String bezeichnung);
	List<Ausruestung> findByAusgeben(Date ausgegeben);
}
