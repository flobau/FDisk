package repository;

import java.util.List;
import domain.Ausbildung;
import org.springframework.data.repository.CrudRepository;

public interface AusbildungRepository extends CrudRepository<Ausbildung, Long> {

	List<Ausbildung> findAll();

	Ausbildung findById(Long id);
}