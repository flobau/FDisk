package at.fdisk.core.repositoryjpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import at.fdisk.core.domain.Berechtigung;

@Repository
public class BerechtigungJpaRepository extends AbstractJpaRepository<Berechtigung>{

	@Override
	public List<Berechtigung> findAll() {
		return entityManager().createQuery("SELECT ber FROM Berechtigung ber", Berechtigung.class).getResultList();
	}

	@Override
	public Berechtigung findById(Long id) {
		return entityManager().find(Berechtigung.class, id);
	}

}
