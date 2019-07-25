package ua.skillsup.practice.jpaworkshop.dao.impl;

import org.springframework.stereotype.Repository;
import ua.skillsup.practice.jpaworkshop.dao.ItemRepository;
import ua.skillsup.practice.jpaworkshop.dao.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

	private final EntityManager entityManager;

	public ItemRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public long create(Item item) {
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
		return entityManager
				.createQuery("from Item", Item.class).getResultList();
	}

	@Override
	public Item findByTitle(String title) {
		return entityManager
				.createQuery("from Item where title = :title", Item.class)
				.setParameter("title", title)
				.getSingleResult();
	}

	@Override
	public List<Item> findByWeightGreaterThen(double weight) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Item> cq = cb.createQuery(Item.class);
		Root<Item> item = cq.from(Item.class);

		cq.where(cb.greaterThan(item.get("weight"), weight));

		return entityManager.createQuery(cq).getResultList();
	}
}