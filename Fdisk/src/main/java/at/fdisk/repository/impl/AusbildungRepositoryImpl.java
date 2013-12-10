package at.fdisk.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.QAusbildung;
import at.fdisk.repository.AusbildungRepositoryCustom;

public class AusbildungRepositoryImpl implements AusbildungRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Ausbildung> findByBezeichnung(String bezeichnung) {
		JPAQuery query = new JPAQuery(entityManager);
		QAusbildung ausbildung = QAusbildung.ausbildung;
		query.from(ausbildung).where(ausbildung.bezeichnung.eq(bezeichnung));
		return query.list(ausbildung);
	}

	@Override
	public List<Ausbildung> findByKurzbezeichnung(String kurzbezeichnung) {
		JPAQuery query = new JPAQuery(entityManager);
		QAusbildung ausbildung = QAusbildung.ausbildung;
		query.from(ausbildung).where(
				ausbildung.kurzBezeichnung.eq(kurzbezeichnung));
		return query.list(ausbildung);
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
