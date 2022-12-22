package de.ruu.lab.modules.inventory.internal;

import java.util.HashSet;
import java.util.Set;

import de.ruu.lab.modules.inventory.InventoryService;
import de.ruu.lab.modules.inventory.Item;
import de.ruu.lab.modules.inventory.ModuleInventory;
import de.ruu.lab.modules.item.ItemCreated;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryServiceDefault implements InventoryService
{
	@Inject
	@ModuleInventory
	private EntityManager entityManager;

	@Override public Item create(Item item)
	{
		ItemDefault entity = new ItemDefault(item);

		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();

		return entity;
	}

	@Override public Item find(long id) { return entityManager.find(Item.class, id); }

	@Override public Item update(Item item)
	{
		ItemDefault entity = new ItemDefault(item);

		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();

		return entity;
	}

	@Override public void delete(Item item)
	{
		ItemDefault entity = new ItemDefault(item);

		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}

	@Override public Set<Item> findAll()
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
		log.info("item created: {}", event.item());
	}
}