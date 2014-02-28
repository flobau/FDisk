package at.fdisk.core.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.core.domain.User;
import at.fdisk.core.repository.UserRepositoryCustom;
import at.fdisk.core.domain.QUser;

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
}
