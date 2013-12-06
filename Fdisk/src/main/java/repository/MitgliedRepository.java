package repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import domain.Mitglied;

public interface MitgliedRepository extends CrudRepository<Mitglied, Long>{

	public List<Mitglied> findAll();

	public Mitglied findById(Long id);
}