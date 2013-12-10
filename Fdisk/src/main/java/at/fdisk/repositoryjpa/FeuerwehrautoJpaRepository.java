package at.fdisk.repositoryjpa;

import java.util.List;
import org.springframework.stereotype.Repository;

import at.fdisk.domain.Feuerwehrauto;

@Repository
public class FeuerwehrautoJpaRepository extends AbstractJpaRepository<Feuerwehrauto> {

	@Override
	public List<Feuerwehrauto> findAll() {
		return entityManager().createQuery("SELECT fa FROM Feuerwehrauto fa", Feuerwehrauto.class).getResultList();
	}

	@Override
	public Feuerwehrauto findById(Long id) {
		return entityManager().find(Feuerwehrauto.class, id);
	}
}