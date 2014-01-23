package at.fdisk.core.repository;

import java.util.List;

import at.fdisk.core.domain.Berechtigung;
import at.fdisk.core.domain.User;

public interface UserRepositoryCustom {
	List<User> findByUsername(String username);
	List<User> findByPasswort(String passwort);
	List<User> findByBerechtigung(Berechtigung berechtigung);
}
