package de.ruu.lab.modules.item.internal;

import de.ruu.lab.modules.item.Item;
import de.ruu.lab.modules.item.ItemCreated;
import de.ruu.lab.modules.item.ItemService;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class ItemServiceDefault implements ItemService
{
	@Inject private EntityManager entityManager;
	@Inject private Event<ItemCreated> event;

	@Override public Item save(Item item)
	{
		ItemDefault entity = new ItemDefault(item);

		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();

		event.fire(new ItemCreatedDefault(entity));

		return entity;
	}
}