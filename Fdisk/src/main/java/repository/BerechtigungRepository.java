package repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import domain.Berechtigung;

public interface BerechtigungRepository extends CrudRepository<Berechtigung, Long>{

	List<Berechtigung> findAll();
	
	Berechtigung findById(Long id);
}
