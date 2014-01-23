package at.fdisk.core.repositoryjpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import at.fdisk.core.domain.Ausruestung;

@Repository
public class AusruestungJpaRepository extends AbstractJpaRepository<Ausruestung> {

	@Override
	public List<Ausruestung> findAll() {
		return entityManager().createQuery("SELECT aus FROM Ausruestung aus", Ausruestung.class).getResultList();
	}

	@Override
	public Ausruestung findById(Long id) {
		return entityManager().find(Ausruestung.class, id);
	}
}