package at.fdisk.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.repository.FeuerwehrRepositoryCustom;
import at.fdisk.core.domain.QFeuerwehr;

public class FeuerwehrRepositoryImpl implements FeuerwehrRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Feuerwehr> findByOrt(String ort) {
		JPAQuery query = new JPAQuery(entityManager);
		QFeuerwehr feuerwehr = QFeuerwehr.feuerwehr;
		query.from(feuerwehr).where(feuerwehr.ort.eq(ort));
		return query.list(feuerwehr);
	}

	@Override
	public List<Feuerwehr> findByAuto(Feuerwehrauto auto) {
		JPAQuery query = new JPAQuery(entityManager);
		QFeuerwehr feuerwehr = QFeuerwehr.feuerwehr;
		query.from(feuerwehr).where(feuerwehr.autos.contains(auto))
				.orderBy(feuerwehr.ort.asc());
		return query.list(feuerwehr);
	}

	@Override
	public List<Feuerwehr> findByAusbildung(Ausbildung ausbildung) {
		JPAQuery query = new JPAQuery(entityManager);
		QFeuerwehr feuerwehr = QFeuerwehr.feuerwehr;
		query.from(feuerwehr)
				.where(feuerwehr.ausbildungen.contains(ausbildung))
				.orderBy(feuerwehr.ort.asc());
		return query.list(feuerwehr);
	}
}
