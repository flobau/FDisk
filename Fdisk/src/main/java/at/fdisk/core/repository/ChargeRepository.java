package at.fdisk.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import at.fdisk.core.domain.Charge;

public interface ChargeRepository extends ChargeRepositoryCustom,
		CrudRepository<Charge, Long> {

	List<Charge> findAll();

	Charge findById(Long id);
}