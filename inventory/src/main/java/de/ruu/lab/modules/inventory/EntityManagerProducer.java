package de.ruu.lab.modules.inventory;

import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerProducer
{
	@Produces
	@ModuleInventory
	public EntityManager createEntityManager()
	{
		return Persistence.createEntityManagerFactory("modules_inventory").createEntityManager();
	}

	public void close(@Disposes @ModuleInventory EntityManager entityManager) { entityManager.close(); }
}