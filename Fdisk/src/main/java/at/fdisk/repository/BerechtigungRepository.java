package at.fdisk.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import at.fdisk.domain.Berechtigung;

public interface BerechtigungRepository extends BerechtigungRepositoryCustom,
		CrudRepository<Berechtigung, Long> {

	List<Berechtigung> findAll();

	Berechtigung findById(Long id);
}
