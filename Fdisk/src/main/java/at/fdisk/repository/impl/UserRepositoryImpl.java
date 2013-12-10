package at.fdisk.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.domain.Berechtigung;
import at.fdisk.domain.QUser;
import at.fdisk.domain.User;
import at.fdisk.repository.UserRepositoryCustom;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<User> findByUsername(String username) {
		JPAQuery query = new JPAQuery(entityManager);
		QUser user = QUser.user;
		query.from(user).where(user.username.eq(username));
		return query.list(user);
	}

	@Override
	public List<User> findByPasswort(String passwort) {
		JPAQuery query = new JPAQuery(entityManager);
		QUser user = QUser.user;
		query.from(user).where(user.username.eq(passwort))
				.orderBy(user.username.asc());
		return query.list(user);
	}

	@Override
	public List<User> findByBerechtigung(Berechtigung berechtigung) {
		JPAQuery query = new JPAQuery(entityManager);
		QUser user = QUser.user;
		query.from(user).where(user.berechtigungen.contains(berechtigung))
				.orderBy(user.username.asc());
		return query.list(user);
	}
}
