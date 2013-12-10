package at.fdisk.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import at.fdisk.domain.Feuerwehrauto;

public interface FeuerwehrautoRepository extends CrudRepository<Feuerwehrauto, Long>{

	List<Feuerwehrauto> findAll();

	Feuerwehrauto findById(Long id);
}