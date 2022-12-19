package de.ruu.lab.modules.inventory.internal;

import de.ruu.lab.modules.inventory.InventoryService;
import de.ruu.lab.modules.inventory.Item;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

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
}