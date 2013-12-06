package repositoryjpa;

import java.util.List;
import org.springframework.stereotype.Repository;
import domain.User;

@Repository
public class UserJpaRepository extends AbstractJpaRepository<User> {

	public List<User> findAll() {
		return entityManager().createQuery("SELECT user FROM User user", User.class).getResultList();
	}

	public User findById(Long id) {
		return entityManager().find(User.class, id);
	}

}
