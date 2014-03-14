package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import at.fdisk.core.domain.Geraet;

@Repository
@RestResource(path = "/geraete")
public interface GeraetRepository extends GeraetRepositoryCustom,
		CrudRepository<Geraet, Long> {

	public List<Geraet> findAll();

	public Geraet findById(Long id);
}