package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import at.fdisk.core.domain.Berechtigung;

public interface BerechtigungRepository extends BerechtigungRepositoryCustom,
		CrudRepository<Berechtigung, Long> {

	List<Berechtigung> findAll();

	Berechtigung findById(Long id);
}
