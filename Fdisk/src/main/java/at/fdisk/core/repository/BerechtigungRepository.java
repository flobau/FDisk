package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import at.fdisk.core.domain.Berechtigung;

@RestResource(path = "/berechtigungen")
@Repository
public interface BerechtigungRepository extends BerechtigungRepositoryCustom,
		CrudRepository<Berechtigung, Long> {

	List<Berechtigung> findAll();

	Berechtigung findById(Long id);
}
