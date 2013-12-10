package at.fdisk.repository;

import java.util.List;

import at.fdisk.domain.Feuerwehrauto;
import at.fdisk.domain.Geraet;

public interface FeuerwehrautoRepositoryCustom {
	List<Feuerwehrauto> findByTyp(String typ);
	List<Feuerwehrauto> findByPlaetze(int plaetze);
	List<Feuerwehrauto> findByGeraet(Geraet geraet);
}
