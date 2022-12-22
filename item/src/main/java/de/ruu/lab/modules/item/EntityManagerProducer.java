package de.ruu.lab.modules.item;

import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerProducer
{
	@Produces
	@ModuleItem
	public EntityManager createEntityManager()
	{
		return Persistence.createEntityManagerFactory("modules_item").createEntityManager();
	}

	public void close(@Disposes @ModuleItem EntityManager entityManager) { entityManager.close(); }
}