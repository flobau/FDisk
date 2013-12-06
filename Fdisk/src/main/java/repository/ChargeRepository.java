package repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import domain.Charge;

public interface ChargeRepository extends CrudRepository<Charge, Long> {

	List<Charge> findAll();

	Charge findById(Long id);
}