package at.fdisk.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.domain.Feuerwehrauto;
import at.fdisk.domain.Geraet;
import at.fdisk.domain.QFeuerwehrauto;
import at.fdisk.repository.FeuerwehrautoRepositoryCustom;

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
