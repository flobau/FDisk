package at.fdisk.core.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Charge;
import at.fdisk.core.repository.ChargeRepositoryCustom;
import at.fdisk.core.domain.QCharge;

public class ChargeRepositoryImpl implements ChargeRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Charge> findByFachgebiet(String fachgebiet) {
		JPAQuery query = new JPAQuery(entityManager);
		QCharge charge = QCharge.charge;
		query.from(charge).where(charge.fachgebiet.eq(fachgebiet))
				.orderBy(charge.nachname.asc());
		return query.list(charge);
	}
	
	@Override
	public List<Charge> findByVorname(String vorname) {
		JPAQuery query = new JPAQuery(entityManager);
		QCharge charge = QCharge.charge;
		query.from(charge).where(charge.vorname.eq(vorname))
				.orderBy(charge.nachname.asc());
		return query.list(charge);
	}

	@Override
	public List<Charge> findByNachname(String nachname) {
		JPAQuery query = new JPAQuery(entityManager);
		QCharge mitglied = QCharge.charge;
		query.from(mitglied).where(mitglied.nachname.eq(nachname))
				.orderBy(mitglied.vorname.asc());
		return query.list(mitglied);
	}

	@Override
	public List<Charge> findByDienstgrad(String dienstgrad) {
		JPAQuery query = new JPAQuery(entityManager);
		QCharge mitglied = QCharge.charge;
		query.from(mitglied).where(mitglied.dienstgrad.eq(dienstgrad))
				.orderBy(mitglied.nachname.asc());
		return query.list(mitglied);
	}

	@Override
	public List<Charge> findByGeburtsdatum(Date gebdat) {
		JPAQuery query = new JPAQuery(entityManager);
		QCharge mitglied = QCharge.charge;
		query.from(mitglied).where(mitglied.geburtsdatum.eq(gebdat))
				.orderBy(mitglied.nachname.asc());
		return query.list(mitglied);
	}

	@Override
	public List<Charge> findByWohnort(String ort) {
		JPAQuery query = new JPAQuery(entityManager);
		QCharge mitglied = QCharge.charge;
		query.from(mitglied).where(mitglied.wohnort.eq(ort))
				.orderBy(mitglied.nachname.asc());
		return query.list(mitglied);
	}

	@Override
	public List<Charge> findByAusruestung(Ausruestung ausruestung) {
		JPAQuery query = new JPAQuery(entityManager);
		QCharge mitglied = QCharge.charge;
		query.from(mitglied)
				.where(mitglied.ausruestungen.contains(ausruestung))
				.orderBy(mitglied.nachname.asc());
		return query.list(mitglied);
	}

	@Override
	public List<Charge> findByAusbildung(Ausbildung ausbildung) {
		JPAQuery query = new JPAQuery(entityManager);
		QCharge mitglied = QCharge.charge;
		query.from(mitglied).where(mitglied.ausbildung.contains(ausbildung))
				.orderBy(mitglied.nachname.asc());
		return query.list(mitglied);
	}
}
