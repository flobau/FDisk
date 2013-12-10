package at.fdisk.repository;

import java.util.List;

import at.fdisk.domain.Feuerwehrauto;

public interface FeuerwehrautoRepositoryCustom {
	List<Feuerwehrauto> findWithQueryDsl(String building);
}
