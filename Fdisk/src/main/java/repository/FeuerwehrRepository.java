package repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import domain.Feuerwehr;

public interface FeuerwehrRepository extends CrudRepository<Feuerwehr, Long>{



	public List<Feuerwehr> findAll();

	public Feuerwehr findById(Long id);
	
}