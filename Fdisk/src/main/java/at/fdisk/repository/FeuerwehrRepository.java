package at.fdisk.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import at.fdisk.domain.Feuerwehr;


public interface FeuerwehrRepository extends CrudRepository<Feuerwehr, Long>{



	public List<Feuerwehr> findAll();

	public Feuerwehr findById(Long id);
	
}