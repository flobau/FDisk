package at.fdisk.core.repositoryjpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import at.fdisk.core.domain.Feuerwehr;

@Repository
public class FeuerwehrJpaRepository extends AbstractJpaRepository<Feuerwehr>{

	@Override
	public List<Feuerwehr> findAll() {
		return entityManager().createQuery("SELECT fe FROM Feuerwehr fe", Feuerwehr.class).getResultList();
	}

	@Override
	public Feuerwehr findById(Long id) {
		return entityManager().find(Feuerwehr.class, id);
	}
}