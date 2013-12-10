package at.fdisk.repository;

import java.util.List;

import at.fdisk.domain.Mitglied;

public interface MitgliedRepositoryCustom {
	List<Mitglied> findWithQueryDsl(String building);
}
