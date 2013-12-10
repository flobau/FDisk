package at.fdisk.repository;

import java.util.List;

import at.fdisk.domain.Berechtigung;
import at.fdisk.domain.User;

public interface UserRepositoryCustom {
	List<User> findByUsername(String username);
	List<User> findByPasswort(String passwort);
	List<User> findByBerechtigung(Berechtigung berechtigung);
}
