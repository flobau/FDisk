package at.fdisk.core.repository;

import java.util.List;

import at.fdisk.core.domain.Berechtigung;
import at.fdisk.core.domain.User;

public interface BerechtigungRepositoryCustom {
	Berechtigung findByBerechtigung(String berechtigung);
	List<Berechtigung> findByUser(User user);
}
