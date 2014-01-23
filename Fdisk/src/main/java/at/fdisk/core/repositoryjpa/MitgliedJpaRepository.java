package at.fdisk.core.repositoryjpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import at.fdisk.core.domain.Mitglied;


@Repository
public class MitgliedJpaRepository extends AbstractJpaRepository<Mitglied>{

	@Override
	public List<Mitglied> findAll() {
		return entityManager().createQuery("SELECT mi FROM Mitglied mi", Mitglied.class).getResultList();
	}

	@Override
	public Mitglied findById(Long id) {
		return entityManager().find(Mitglied.class, id);
	}
}