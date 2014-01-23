package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import at.fdisk.core.domain.Feuerwehr;

public interface FeuerwehrRepository extends FeuerwehrRepositoryCustom,
		CrudRepository<Feuerwehr, Long> {

	public List<Feuerwehr> findAll();

	public Feuerwehr findById(Long id);

}