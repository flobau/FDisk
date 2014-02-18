package at.fdisk.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.core.domain.Berechtigung;
import at.fdisk.core.domain.User;
import at.fdisk.core.repository.BerechtigungRepositoryCustom;
import at.fdisk.core.domain.QBerechtigung;

public class BerechtigungRepositoryImpl implements BerechtigungRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Berechtigung> findByBerechtigung(String berechtigungName) {
		JPAQuery query = new JPAQuery(entityManager);
		QBerechtigung berechtigung = QBerechtigung.berechtigung;
		query.from(berechtigung).where(
				berechtigung.berechtigungName.eq(berechtigungName));
		return query.list(berechtigung);
	}

	@Override
	public List<Berechtigung> findByUser(User user) {
		JPAQuery query = new JPAQuery(entityManager);
		QBerechtigung berechtigung = QBerechtigung.berechtigung;
		query.from(berechtigung).where(berechtigung.berechtigte.contains(user))
				.orderBy(berechtigung.berechtigungName.asc());
		return query.list(berechtigung);
	}
}
