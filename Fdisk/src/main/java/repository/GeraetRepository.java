package repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import domain.Geraet;

public interface GeraetRepository extends CrudRepository<Geraet, Long>{


	public List<Geraet> findAll();
	
	public Geraet findById(Long id);
}