package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import at.fdisk.core.domain.Ausbildung;

@RestResource(path = "/ausbildungen")
@Repository
public interface AusbildungRepository extends AusbildungRepositoryCustom,
		CrudRepository<Ausbildung, Long> {

	List<Ausbildung> findAll();

	Ausbildung findById(Long id);
}