package at.fdisk.repository;

import java.util.List;

import at.fdisk.domain.Feuerwehr;

public interface FeuerwehrRepositoryCustom {
	List<Feuerwehr> findWithQueryDsl(String building);
}
