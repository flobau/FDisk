package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import at.fdisk.core.domain.Mitglied;

@Repository
@RestResource(path = "/mitglieder")
public interface MitgliedRepository extends MitgliedRepositoryCustom,
		CrudRepository<Mitglied, Long> {

	public List<Mitglied> findAll();

	public Mitglied findById(Long id);
}