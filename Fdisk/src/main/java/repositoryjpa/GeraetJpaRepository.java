package repositoryjpa;

import java.util.List;
import org.springframework.stereotype.Repository;
import domain.Geraet;

@Repository
public class GeraetJpaRepository extends AbstractJpaRepository<Geraet>{

	@Override
	public List<Geraet> findAll() {
		return entityManager().createQuery("SELECT ge FROM Geraet ge", Geraet.class).getResultList();
	}

	@Override
	public Geraet findById(Long id) {
		return entityManager().find(Geraet.class, id);
	}
}