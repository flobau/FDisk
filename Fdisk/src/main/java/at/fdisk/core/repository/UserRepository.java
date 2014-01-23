package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import at.fdisk.core.domain.User;

public interface UserRepository extends UserRepositoryCustom,
		CrudRepository<User, Long> {

	List<User> findAll();

	User findById(Long id);
}
