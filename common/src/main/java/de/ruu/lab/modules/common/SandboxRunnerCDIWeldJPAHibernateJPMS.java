package de.ruu.lab.modules.common;

import java.math.BigDecimal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
class SandboxRunnerCDIWeldJPAHibernateJPMS
{
	@Inject private ItemService itemService;

	void run()
	{
		runCDI();
	}

	void runCDI()
	{
		var item = Item.newInstance("cdi inject" + System.currentTimeMillis(), BigDecimal.ONE);

		log.info("item before save {}", item);
		itemService.save(item);
		log.info("item after  save {}", item);
	}

	public static void main(String[] args)
	{
		log.debug("cdi container initialisation, creating initialiser");
		var initializer = SeContainerInitializer.newInstance();
		log.debug("cdi container initialisation, created  initialiser");

		log.debug("cdi container initialisation");
		try (final var container = initializer.initialize())
		{
			log.debug("cdi container initialised");

			log.info("looking up runner");
			var runner = CDI.current().select(SandboxRunnerCDIWeldJPAHibernateJPMS.class).get();
			log.info("looked  up runner");

			log.info("starting runner");
			runner.run();
			log.info("finished runner");
		}
		catch (Throwable t)
		{
			log.error("cdi container initialisation failed", t);
		}
		finally
		{
			log.debug("cdi container shut down");
		}
	}
}