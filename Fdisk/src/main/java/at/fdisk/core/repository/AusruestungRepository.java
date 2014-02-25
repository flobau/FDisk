package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import at.fdisk.core.domain.Ausruestung;

@RestResource(path="/ausruestungen")
public interface AusruestungRepository extends AusruestungRepositoryCustom,
		CrudRepository<Ausruestung, Long> {

	List<Ausruestung> findAll();

	Ausruestung findById(Long id);
}