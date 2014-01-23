package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import at.fdisk.core.domain.Ausruestung;

public interface AusruestungRepository extends AusruestungRepositoryCustom,
		CrudRepository<Ausruestung, Long> {

	List<Ausruestung> findAll();

	Ausruestung findById(Long id);
}