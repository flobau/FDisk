package at.fdisk.core.repository;

import java.util.List;

import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Geraet;

public interface FeuerwehrautoRepositoryCustom {
	List<Feuerwehrauto> findByTyp(String typ);
	List<Feuerwehrauto> findByPlaetze(int plaetze);
	List<Feuerwehrauto> findByGeraet(Geraet geraet);
}
