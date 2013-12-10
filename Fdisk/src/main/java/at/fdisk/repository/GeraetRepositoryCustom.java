package at.fdisk.repository;

import java.util.Date;
import java.util.List;

import at.fdisk.domain.Geraet;

public interface GeraetRepositoryCustom {
	List<Geraet> findByBezeichnung(String bezeichnung);
	List<Geraet> findByPruefungstermin(Date pruefungstermin);
}
