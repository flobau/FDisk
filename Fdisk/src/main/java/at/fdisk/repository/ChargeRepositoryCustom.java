package at.fdisk.repository;

import java.util.List;

import at.fdisk.domain.Charge;

public interface ChargeRepositoryCustom {
	List<Charge> findWithQueryDsl(String building);
}
