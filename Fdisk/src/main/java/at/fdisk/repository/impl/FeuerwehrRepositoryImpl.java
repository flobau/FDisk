package at.fdisk.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Feuerwehr;
import at.fdisk.domain.Feuerwehrauto;
import at.fdisk.domain.QFeuerwehr;
import at.fdisk.repository.FeuerwehrRepositoryCustom;

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
