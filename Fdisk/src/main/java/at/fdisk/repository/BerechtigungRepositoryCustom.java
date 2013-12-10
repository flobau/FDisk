package at.fdisk.repository;

import java.util.List;

import at.fdisk.domain.Berechtigung;

public interface BerechtigungRepositoryCustom {
	List<Berechtigung> findWithQueryDsl(String building);
}
