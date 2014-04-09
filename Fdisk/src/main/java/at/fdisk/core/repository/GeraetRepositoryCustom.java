package at.fdisk.core.repository;

import java.util.Date;
import java.util.List;

import at.fdisk.core.domain.Geraet;

public interface GeraetRepositoryCustom {
	List<Geraet> findByBezeichnung(String bezeichnung);
	List<Geraet> findByPruefungstermin(Date pruefungstermin);
}
