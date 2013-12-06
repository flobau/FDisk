package repositoryjpa;

import java.util.List;
import org.springframework.stereotype.Repository;
import domain.Ausbildung;

@Repository
public class AusbildungJpaRepository extends AbstractJpaRepository<Ausbildung>{

		@Override
		public List<Ausbildung> findAll() {
			return entityManager().createQuery("SELECT aus FROM Ausbildung aus", Ausbildung.class).getResultList();
		}

		@Override
		public Ausbildung findById(Long id) {
			return entityManager().find(Ausbildung.class, id);
		}
}