//package de.ruu.lab.modules.item;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.not;
//import static org.hamcrest.Matchers.nullValue;
//import static org.hamcrest.core.Is.is;
//
//import java.math.BigDecimal;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import jakarta.enterprise.inject.se.SeContainer;
//import jakarta.enterprise.inject.se.SeContainerInitializer;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//class SandboxTestCDIWeldJPAHibernateJPMS
//{
//	private static SeContainer seContainer;
//
//// TODO find out why @Inject does not compile
////	@Inject private ItemService itemService;
//
//	@BeforeAll static void beforeAll()
//	{
//		log.debug("cdi container initialisation");
//		try
//		{
//			seContainer = SeContainerInitializer.newInstance().initialize();
//		}
//		catch (Exception e)
//		{
//			log.error("failure initialising seContainer", e);
//		}
//		log.debug("cdi container initialisation {}", seContainer == null ? "unsuccessful" : "successful");
//	}
//
//	@AfterAll static void afterAll()
//	{
//		log.debug("cdi container shut down");
//		seContainer.close();
//		log.debug("cdi container shut down {}", seContainer.isRunning() ? "unsuccessful" : "successful");
//	}
//
//	@BeforeEach void beforeEach()
//	{
//// TODO find out why @Inject does not compile
////		itemService = CDI.current().select(ItemService.class).get();
//	}
//
//	@Test void testJPA()
//	{
//		var name  = "jpa test at "  + System.currentTimeMillis();
//		var price = BigDecimal.ONE;
//
//		var item = Item.newInstance(name, price);
//
//		log.info("item before save {}", item);
//// TODO find out why @Inject does not compile
////		itemService.save(item);
//		log.info("item after  save {}", item);
//
//		assertThat(item.getId   (), is(not(nullValue())));
//		assertThat(item.getName (), is(name));
//		assertThat(item.getPrice(), is(price));
//	}
//
//	@Test void testCDI()
//	{
//// TODO find out why @Inject does not compile
////		assertThat(itemService, is(not(nullValue())));
//	}
//}