package at.fdisk.repository;

import java.util.List;

import at.fdisk.domain.Ausruestung;

public interface AusruestungRepositoryCustom {
	List<Ausruestung> findWithQueryDsl(String building);
}
