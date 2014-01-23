package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import at.fdisk.core.domain.Feuerwehrauto;

public interface FeuerwehrautoRepository extends FeuerwehrautoRepositoryCustom,
		CrudRepository<Feuerwehrauto, Long> {

	List<Feuerwehrauto> findAll();

	Feuerwehrauto findById(Long id);
}