package ua.skillsup.practice.jpaworkshop.dao.impl;

import org.springframework.stereotype.Repository;
import ua.skillsup.practice.jpaworkshop.dao.ItemRepository;
import ua.skillsup.practice.jpaworkshop.dao.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

	private final EntityManagerFactory entityManagerFactory;

	public ItemRepositoryImpl(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public long create(Item item) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.persist(item);
		return item.getId();
	}

	@Override
	public void update(Item item) {

	}

	@Override
	public Item getOne(long id) {
		return null;
	}

	@Override
	public List<Item> findAll() {
		return entityManagerFactory.createEntityManager()
				.createQuery("from Item", Item.class).getResultList();
	}

	@Override
	public Item findByTitle(String title) {
		return entityManagerFactory.createEntityManager()
				.createQuery("from Item where title = :title", Item.class)
				.setParameter("title", title)
				.getSingleResult();
	}

	@Override
	public List<Item> findByWeightGreaterThen(double weight) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Item> cq = cb.createQuery(Item.class);
		Root<Item> item = cq.from(Item.class);

		cq.where(cb.greaterThan(item.get("weight"), weight));

		return entityManager.createQuery(cq).getResultList();
	}
}