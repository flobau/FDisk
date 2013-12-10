package at.fdisk.repository;

import java.util.List;

import at.fdisk.domain.Geraet;

public interface GeraetRepositoryCustom {
	List<Geraet> findWithQueryDsl(String building);
}
