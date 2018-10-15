package ua.skillsup.practice.jpaworkshop.dao.impl;

import org.springframework.stereotype.Repository;
import ua.skillsup.practice.jpaworkshop.dao.LotRepository;
import ua.skillsup.practice.jpaworkshop.dao.entity.Lot;
import ua.skillsup.practice.jpaworkshop.dao.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Repository
public class LotRepositoryImpl implements LotRepository {

	private final EntityManagerFactory entityManagerFactory;

	public LotRepositoryImpl(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public long create(Lot lot) {
		return 0;
	}

	@Override
	public void update(Lot lot) {

	}

	@Override
	public Lot getOne(long id) {
		return null;
	}

	@Override
	public List<Lot> findAll() {
		return entityManagerFactory.createEntityManager()
				.createQuery("from Lot", Lot.class).getResultList();
	}

	@Override
	public List<Lot> findByUserNameAndCreationDate(String username, LocalDate from, LocalDate to) {
		return entityManagerFactory.createEntityManager()
				.createQuery("select l from Lot l LEFT JOIN l.owner o " +
						" where o.login=:username" +
						" and l.datePlaced between :from and :to", Lot.class)
				.setParameter("username", username)
				.setParameter("from", from)
				.setParameter("to", to)
				.getResultList();
	}
}
