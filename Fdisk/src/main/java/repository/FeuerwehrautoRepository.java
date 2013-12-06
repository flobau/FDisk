package repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import domain.Feuerwehrauto;

public interface FeuerwehrautoRepository extends CrudRepository<Feuerwehrauto, Long>{

	List<Feuerwehrauto> findAll();

	Feuerwehrauto findById(Long id);
}