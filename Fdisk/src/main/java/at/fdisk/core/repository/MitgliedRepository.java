package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import at.fdisk.core.domain.Mitglied;

public interface MitgliedRepository extends MitgliedRepositoryCustom,
		CrudRepository<Mitglied, Long> {

	public List<Mitglied> findAll();

	public Mitglied findById(Long id);
}