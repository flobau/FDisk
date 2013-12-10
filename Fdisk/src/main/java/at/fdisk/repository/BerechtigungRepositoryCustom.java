package at.fdisk.repository;

import java.util.List;

import at.fdisk.domain.Berechtigung;
import at.fdisk.domain.User;

public interface BerechtigungRepositoryCustom {
	List<Berechtigung> findByBerechtigung(String berechtigung);
	List<Berechtigung> findByUser(User user);
}
