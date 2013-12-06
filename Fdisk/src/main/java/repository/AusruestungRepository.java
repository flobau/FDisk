package repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import domain.Ausruestung;

public interface AusruestungRepository extends CrudRepository<Ausruestung, Long> {

	List<Ausruestung> findAll();

	Ausruestung findById(Long id);
}