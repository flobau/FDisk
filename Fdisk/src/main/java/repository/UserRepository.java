package repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findAll();
	
	User findById(Long id);
}
