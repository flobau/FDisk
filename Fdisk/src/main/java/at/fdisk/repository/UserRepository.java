package at.fdisk.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import at.fdisk.domain.User;

public interface UserRepository extends UserRepositoryCustom,
		CrudRepository<User, Long> {

	List<User> findAll();

	User findById(Long id);
}
