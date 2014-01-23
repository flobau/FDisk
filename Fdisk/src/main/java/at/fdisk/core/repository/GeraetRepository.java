package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import at.fdisk.core.domain.Geraet;

public interface GeraetRepository extends GeraetRepositoryCustom,
		CrudRepository<Geraet, Long> {

	public List<Geraet> findAll();

	public Geraet findById(Long id);
}