package at.fdisk.repository;

import java.util.List;

import at.fdisk.domain.User;

public interface UserRepositoryCustom {
	List<User> findWithQueryDsl(String building);
}
