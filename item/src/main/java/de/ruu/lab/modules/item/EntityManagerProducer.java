package de.ruu.lab.modules.item;

import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerProducer
{
	@Produces public EntityManager createEntityManager()
	{
		return Persistence.createEntityManagerFactory("modules").createEntityManager();
	}

	public void close(@Disposes EntityManager entityManager) { entityManager.close(); }
}