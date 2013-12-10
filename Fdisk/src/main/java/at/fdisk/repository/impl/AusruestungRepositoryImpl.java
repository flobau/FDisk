package at.fdisk.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.domain.Ausruestung;
import at.fdisk.domain.QAusruestung;
import at.fdisk.repository.AusruestungRepositoryCustom;

public class AusruestungRepositoryImpl implements AusruestungRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Ausruestung> findByBezeichnung(String bezeichnung) {
		JPAQuery query = new JPAQuery(entityManager);
		QAusruestung ausruestung = QAusruestung.ausruestung;
		query.from(ausruestung).where(ausruestung.bezeichnung.eq(bezeichnung));
		return query.list(ausruestung);
	}

	@Override
	public List<Ausruestung> findByAusgeben(Date ausgegeben) {
		JPAQuery query = new JPAQuery(entityManager);
		QAusruestung ausruestung = QAusruestung.ausruestung;
		query.from(ausruestung).where(ausruestung.ausgegeben.eq(ausgegeben))
				.orderBy(ausruestung.bezeichnung.asc());
		return query.list(ausruestung);
	}
}
