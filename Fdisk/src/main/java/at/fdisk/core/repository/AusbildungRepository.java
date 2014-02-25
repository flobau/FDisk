package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import at.fdisk.core.domain.Ausbildung;

@RestResource(path="/ausbildungen")
public interface AusbildungRepository extends AusbildungRepositoryCustom,
		CrudRepository<Ausbildung, Long> {

	List<Ausbildung> findAll();

	Ausbildung findById(Long id);
}