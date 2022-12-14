package de.ruu.lab.modules.common;

import java.math.BigDecimal;

import de.ruu.lab.modules.common.internal.ItemDefaultImpl;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemServiceRunner
{
	@Inject private ItemService itemService;

	public static void main(String[] args)
	{
		testJPA();
		testCDI();
	}

	static void testCDI()
	{
//	Item item =
		ItemDefaultImpl item =
				new ItemDefaultImpl("item with cdi injection and jpa" + System.currentTimeMillis(), BigDecimal.ONE);

		try (final SeContainer container = SeContainerInitializer.newInstance().initialize())
		{
			log.debug("cdi container initialisation {}", container == null ? "unsuccessful" : "successful");
			ItemServiceRunner itemServiceRunner = container.select(ItemServiceRunner.class).get();
			log.info("item before save {}", item);
			itemServiceRunner.itemService.save(item);
			log.info("item after  save {}", item);
		}
		finally
		{
			log.debug("cdi container shut down");
		}
	}

	static void testJPA()
	{
//		Item item =
		ItemDefaultImpl item =
				new ItemDefaultImpl("item without cdi injection but with jpa" + System.currentTimeMillis(), BigDecimal.ONE);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(item);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}