package de.ruu.lab.modules.item.internal;

import java.util.HashSet;
import java.util.Set;

import de.ruu.lab.modules.item.Item;
import de.ruu.lab.modules.item.ItemCreated;
import de.ruu.lab.modules.item.ItemService;
import de.ruu.lab.modules.item.ModuleItem;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemServiceDefault implements ItemService
{
	@Inject
	@ModuleItem
	private EntityManager entityManager;
	
	@Inject private Event<ItemCreated> event;

	@Override public Item create(Item item)
	{
		ItemDefault entity = new ItemDefault(item);

		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();

		event.fire(new ItemCreatedDefault(entity));

		return entity;
	}

	@Override public Item find(long id) { return entityManager.find(Item.class, id); }

	@Override public Item update(Item item)
	{
		ItemDefault entity = entityManager.find(ItemDefault.class, item.id());

		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();

		return entity;
	}

	@Override
	public void delete(Item item)
	{
		ItemDefault entity = entityManager.find(ItemDefault.class, item.id());

		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}

	@Override
	public Set<Item> findAll()
	{
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ItemDefault> criteriaQuery = criteriaBuilder.createQuery(ItemDefault.class);
		Root<ItemDefault> rootEntry = criteriaQuery.from(ItemDefault.class);
		criteriaQuery = criteriaQuery.select(rootEntry);
		TypedQuery<ItemDefault> allQuery = entityManager.createQuery(criteriaQuery);
		return new HashSet<Item>(allQuery.getResultList());
	}

	@SuppressWarnings("unused")
	private void listen(@Observes ItemCreated event)
	{
		log.info("received event - item created: {}", event.item());
	}
}