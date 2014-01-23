package at.fdisk.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Geraet;
import at.fdisk.core.repository.FeuerwehrautoRepositoryCustom;
import at.fdisk.domain.QFeuerwehrauto;

public class FeuerwehrautoRepositoryImpl implements
		FeuerwehrautoRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Feuerwehrauto> findByTyp(String typ) {
		JPAQuery query = new JPAQuery(entityManager);
		QFeuerwehrauto feuerwehrauto = QFeuerwehrauto.feuerwehrauto;
		query.from(feuerwehrauto).where(feuerwehrauto.typ.eq(typ))
				.orderBy(feuerwehrauto.typ.asc());
		return query.list(feuerwehrauto);
	}

	@Override
	public List<Feuerwehrauto> findByPlaetze(int plaetze) {
		JPAQuery query = new JPAQuery(entityManager);
		QFeuerwehrauto feuerwehrauto = QFeuerwehrauto.feuerwehrauto;
		query.from(feuerwehrauto).where(feuerwehrauto.sitzplaetze.eq(plaetze))
				.orderBy(feuerwehrauto.typ.asc());
		return query.list(feuerwehrauto);
	}

	@Override
	public List<Feuerwehrauto> findByGeraet(Geraet geraet) {
		JPAQuery query = new JPAQuery(entityManager);
		QFeuerwehrauto feuerwehrauto = QFeuerwehrauto.feuerwehrauto;
		query.from(feuerwehrauto).where(feuerwehrauto.geraete.contains(geraet))
				.orderBy(feuerwehrauto.typ.asc());
		return query.list(feuerwehrauto);
	}
}
