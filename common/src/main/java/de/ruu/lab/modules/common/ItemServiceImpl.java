package de.ruu.lab.modules.common;

import de.ruu.lab.modules.common.internal.ItemDefaultImpl;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class ItemServiceImpl implements ItemService
{
	@Inject private EntityManager entityManager;

//	@Override public void save(Item item)
	@Override public void save(ItemDefaultImpl item)
	{
		entityManager.getTransaction().begin();
		entityManager.persist(item);
		entityManager.getTransaction().commit();
	}
}