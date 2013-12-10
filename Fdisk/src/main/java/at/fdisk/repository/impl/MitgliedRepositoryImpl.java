package at.fdisk.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Ausruestung;
import at.fdisk.domain.Mitglied;
import at.fdisk.domain.QMitglied;
import at.fdisk.repository.MitgliedRepositoryCustom;

public class MitgliedRepositoryImpl implements MitgliedRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Mitglied> findByVorname(String vorname) {
		JPAQuery query = new JPAQuery(entityManager);
		QMitglied mitglied = QMitglied.mitglied;
		query.from(mitglied).where(mitglied.vorname.eq(vorname))
				.orderBy(mitglied.nachname.asc());
		return query.list(mitglied);
	}

	@Override
	public List<Mitglied> findByNachname(String nachname) {
		JPAQuery query = new JPAQuery(entityManager);
		QMitglied mitglied = QMitglied.mitglied;
		query.from(mitglied).where(mitglied.nachname.eq(nachname))
				.orderBy(mitglied.vorname.asc());
		return query.list(mitglied);
	}

	@Override
	public List<Mitglied> findByDienstgrad(String dienstgrad) {
		JPAQuery query = new JPAQuery(entityManager);
		QMitglied mitglied = QMitglied.mitglied;
		query.from(mitglied).where(mitglied.dienstgrad.eq(dienstgrad))
				.orderBy(mitglied.nachname.asc());
		return query.list(mitglied);
	}

	@Override
	public List<Mitglied> findByGeburtsdatum(Date gebdat) {
		JPAQuery query = new JPAQuery(entityManager);
		QMitglied mitglied = QMitglied.mitglied;
		query.from(mitglied).where(mitglied.geburtsdatum.eq(gebdat))
				.orderBy(mitglied.nachname.asc());
		return query.list(mitglied);
	}

	@Override
	public List<Mitglied> findByWohnort(String ort) {
		JPAQuery query = new JPAQuery(entityManager);
		QMitglied mitglied = QMitglied.mitglied;
		query.from(mitglied).where(mitglied.wohnort.eq(ort))
				.orderBy(mitglied.nachname.asc());
		return query.list(mitglied);
	}

	@Override
	public List<Mitglied> findByAusruestung(Ausruestung ausruestung) {
		JPAQuery query = new JPAQuery(entityManager);
		QMitglied mitglied = QMitglied.mitglied;
		query.from(mitglied)
				.where(mitglied.ausruestungen.contains(ausruestung))
				.orderBy(mitglied.nachname.asc());
		return query.list(mitglied);
	}

	@Override
	public List<Mitglied> findByAusbildung(Ausbildung ausbildung) {
		JPAQuery query = new JPAQuery(entityManager);
		QMitglied mitglied = QMitglied.mitglied;
		query.from(mitglied).where(mitglied.ausbildung.contains(ausbildung))
				.orderBy(mitglied.nachname.asc());
		return query.list(mitglied);
	}
}
