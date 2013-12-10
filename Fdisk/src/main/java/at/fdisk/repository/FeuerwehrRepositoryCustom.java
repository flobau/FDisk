package at.fdisk.repository;

import java.util.List;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Feuerwehr;
import at.fdisk.domain.Feuerwehrauto;

public interface FeuerwehrRepositoryCustom {
	List<Feuerwehr> findByOrt(String ort);
	List<Feuerwehr> findByAuto(Feuerwehrauto auto);
	List<Feuerwehr> findByAusbildung(Ausbildung ausbildung);
}
