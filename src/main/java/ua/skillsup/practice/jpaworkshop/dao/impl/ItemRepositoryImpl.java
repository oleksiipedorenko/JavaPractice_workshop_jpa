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
		return 0;
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
				.createQuery("from Item where title = :tttt", Item.class)
				.setParameter("tttt", title)
				.getSingleResult();
	}

	@Override
	public List<Item> findByWeightGreaterThen(double weight) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Item> query = builder.createQuery(Item.class);
		Root<Item> root = query.from(Item.class);

		query.where(builder.greaterThan(root.get("weight"), weight));
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public List<Item> findByCategory(String category) {
		return entityManager
				.createQuery("select i from Item i " +
						"JOIN i.categories c " +
						"where c.title = :title", Item.class)
				.setParameter("title", category)
				.getResultList();
	}
}
