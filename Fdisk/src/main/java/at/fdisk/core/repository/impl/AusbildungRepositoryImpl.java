package at.fdisk.core.repository.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.repository.AusbildungRepositoryCustom;
import at.fdisk.core.domain.QAusbildung;

public class AusbildungRepositoryImpl implements AusbildungRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Ausbildung findByBezeichnung(String bezeichnung) {
		JPAQuery query = new JPAQuery(entityManager);
		QAusbildung ausbildung = QAusbildung.ausbildung;
		query.from(ausbildung).where(ausbildung.bezeichnung.eq(bezeichnung));
		return query.singleResult(ausbildung);
	}

	@Override
	public Ausbildung findByKurzbezeichnung(String kurzbezeichnung) {
		JPAQuery query = new JPAQuery(entityManager);
		QAusbildung ausbildung = QAusbildung.ausbildung;
		query.from(ausbildung).where(
				ausbildung.kurzBezeichnung.eq(kurzbezeichnung));
		return query.singleResult(ausbildung);
	}

	@Override
	public List<Ausbildung> findByStartdatum(Date startdatum) {
		JPAQuery query = new JPAQuery(entityManager);
		QAusbildung ausbildung = QAusbildung.ausbildung;
		query.from(ausbildung).where(ausbildung.startdatum.eq(startdatum))
				.orderBy(ausbildung.bezeichnung.asc());
		return null;
	}

	@Override
	public List<Ausbildung> findByEnddatum(Date enddatum) {
		JPAQuery query = new JPAQuery(entityManager);
		QAusbildung ausbildung = QAusbildung.ausbildung;
		query.from(ausbildung).where(ausbildung.enddatum.eq(enddatum))
				.orderBy(ausbildung.bezeichnung.asc());
		return null;
	}

}
