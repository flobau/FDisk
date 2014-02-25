package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import at.fdisk.core.domain.Charge;

@RestResource(path="/chargen")
public interface ChargeRepository extends ChargeRepositoryCustom,
		CrudRepository<Charge, Long> {

	List<Charge> findAll();

	Charge findById(Long id);
}