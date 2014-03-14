package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import at.fdisk.core.domain.User;

@Repository
@RestResource(path = "/users")
public interface UserRepository extends UserRepositoryCustom,
		CrudRepository<User, Long> {

	List<User> findAll();

	User findById(Long id);
}
