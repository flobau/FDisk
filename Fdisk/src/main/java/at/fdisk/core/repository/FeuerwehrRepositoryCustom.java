package at.fdisk.core.repository;

import java.util.List;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Feuerwehrauto;

public interface FeuerwehrRepositoryCustom {
	List<Feuerwehr> findByOrt(String ort);
	List<Feuerwehr> findByAuto(Feuerwehrauto auto);
	List<Feuerwehr> findByAusbildung(Ausbildung ausbildung);
}
