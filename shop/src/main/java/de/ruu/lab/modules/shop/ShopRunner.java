package de.ruu.lab.modules.shop;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShopRunner
{
	public static void main(String[] args)
	{
		log.debug("starting shop runner");

		log.debug("cdi container initialisation");
		try (final SeContainer container = SeContainerInitializer.newInstance().initialize())
		{
			log.debug("cdi container initialisation {}", container == null ? "unsuccessful" : "successful");
			Shop shop = container.select(Shop.class).get();

			log.info("shop inventory before populate\n{}", shop);
			shop.populateInventory();
			log.info("shop inventory after  populate\n{}", shop);
			shop.clearInventory();
			log.info("shop inventory after  clearing\n{}", shop);
		}
		finally
		{
			log.debug("cdi container shut down");
		}

		log.debug("finished shop runner");
	}
}