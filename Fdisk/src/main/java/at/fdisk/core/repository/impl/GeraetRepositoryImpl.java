package at.fdisk.core.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.core.domain.Geraet;
import at.fdisk.core.repository.GeraetRepositoryCustom;
import at.fdisk.core.domain.QGeraet;

public class GeraetRepositoryImpl implements GeraetRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Geraet> findByBezeichnung(String bezeichnung) {
		JPAQuery query = new JPAQuery(entityManager);
		QGeraet geraet = QGeraet.geraet;
		query.from(geraet).where(geraet.bezeichnung.eq(bezeichnung));
		return query.list(geraet);
	}

	@Override
	public List<Geraet> findByPruefungstermin(Date pruefungstermin) {
		JPAQuery query = new JPAQuery(entityManager);
		QGeraet geraet = QGeraet.geraet;
		query.from(geraet).where(geraet.pruefungstermin.eq(pruefungstermin))
				.orderBy(geraet.bezeichnung.asc());
		return query.list(geraet);
	}
}
