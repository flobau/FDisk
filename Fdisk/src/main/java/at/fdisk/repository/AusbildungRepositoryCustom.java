package at.fdisk.repository;

import java.util.List;

import at.fdisk.domain.Ausbildung;

public interface AusbildungRepositoryCustom {
    List<Ausbildung> findWithQueryDsl(String building);

}
