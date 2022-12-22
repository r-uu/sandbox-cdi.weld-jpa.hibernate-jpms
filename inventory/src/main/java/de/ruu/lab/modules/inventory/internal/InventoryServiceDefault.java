package de.ruu.lab.modules.inventory.internal;

import de.ruu.lab.modules.inventory.InventoryService;
import de.ruu.lab.modules.inventory.Item;
import de.ruu.lab.modules.item.ItemCreated;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryServiceDefault implements InventoryService
{
	@Inject private EntityManager entityManager;

	@Override public Item add(Item item)
	{
		ItemDefault entity = new ItemDefault(item);

		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();

		return entity;
	}

	@SuppressWarnings("unused")
	private void listen(@Observes ItemCreated event)
	{
		log.info("item created: {}", event.item());
	}
}