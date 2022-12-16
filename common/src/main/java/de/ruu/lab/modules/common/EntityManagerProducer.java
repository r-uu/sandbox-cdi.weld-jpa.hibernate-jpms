package de.ruu.lab.modules.common;

import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerProducer
{
	@Produces public EntityManager createEntityManager()
	{
		return Persistence.createEntityManagerFactory("default").createEntityManager();
	}

	public void close(@Disposes EntityManager entityManager) { entityManager.close(); }
}