package de.ruu.lab.modules.inventory.internal;

import de.ruu.lab.modules.inventory.InventoryService;
import de.ruu.lab.modules.inventory.Item;
import de.ruu.lab.modules.inventory.ItemCreated;
import de.ruu.lab.modules.inventory.ModuleInventory;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryServiceDefault implements InventoryService
{
	/** visibility needs to be {@code package} to be proxyable not only by weld */
	@ApplicationScoped
	static class ItemCreatedDispatcher extends EventDispatcher<de.ruu.lab.modules.item.ItemCreated> { }

	@Inject private ItemCreatedDispatcher dispatcher;

	@Inject
	@ModuleInventory
	private EntityManager entityManager;

	@Inject private Event<ItemCreated> event;

	@PostConstruct
	private void postConstruct()
	{
		dispatcher.add(itemCreated -> onItemCreated(itemCreated));
	}

	@Override public Item create(Item item)
	{
		ItemDefault entity = new ItemDefault(item.name(), 0);

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

	@Override public void delete(Item item)
	{
		ItemDefault entity = entityManager.find(ItemDefault.class, item.id());

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
		return new HashSet<>(allQuery.getResultList());
	}

	@SuppressWarnings("unused")
	private void onItemCreated(de.ruu.lab.modules.item.ItemCreated itemCreated)
	{
		log.info("item created: {}", itemCreated.item() + ", updating inventory");
		Item item = create(Item.newInstance(itemCreated.item().name(), 0L));
		log.info("item created: {}", item               + ", updated  inventory");
	}
}