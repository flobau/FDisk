package at.fdisk.core.repositoryjpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import at.fdisk.core.domain.Charge;

@Repository
public class ChargeJpaRepository extends AbstractJpaRepository<Charge> {

	@Override
	public List<Charge> findAll() {
		return entityManager().createQuery("SELECT ch FROM Charge ch", Charge.class).getResultList();
	}

	@Override
	public Charge findById(Long id) {
		return entityManager().find(Charge.class, id);
	}

}