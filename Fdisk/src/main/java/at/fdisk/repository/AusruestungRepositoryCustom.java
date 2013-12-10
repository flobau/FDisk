package at.fdisk.repository;

import java.util.Date;
import java.util.List;

import at.fdisk.domain.Ausruestung;

public interface AusruestungRepositoryCustom {
	List<Ausruestung> findByBezeichnung(String bezeichnung);
	List<Ausruestung> findByAusgeben(Date ausgegeben);
}
