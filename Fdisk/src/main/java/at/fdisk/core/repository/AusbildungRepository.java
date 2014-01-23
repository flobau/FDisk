package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import at.fdisk.core.domain.Ausbildung;

public interface AusbildungRepository extends AusbildungRepositoryCustom,
		CrudRepository<Ausbildung, Long> {

	List<Ausbildung> findAll();

	Ausbildung findById(Long id);
}