package de.ruu.lab.modules.item.internal;

import de.ruu.lab.modules.item.Item;
import de.ruu.lab.modules.item.ItemService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class ItemServiceDefault implements ItemService
{
	@Inject private EntityManager entityManager;

	@Override public Item save(Item item)
	{
		ItemDefault entity = new ItemDefault(item);

		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		
		return entity;
	}
}