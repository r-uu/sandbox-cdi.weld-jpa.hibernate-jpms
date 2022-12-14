package de.ruu.lab.modules.common;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.enterprise.inject.spi.CDI;
import lombok.extern.slf4j.Slf4j;

//@Disabled("TODO: test fails for unknown reason")
@Slf4j class CDITest
{
	private static SeContainer seContainer;

	// load greeter inside context
	private CDITestContext context;
	// load greeter directly
	private CDIGreeter greeter;

	@BeforeAll static void beforeAll()
	{
		log.debug("cdi container initialisation");
		try
		{
			seContainer = SeContainerInitializer.newInstance().initialize();
		}
		catch (Exception e)
		{
			log.error("failure initialising seContainer", e);
		}
		log.debug("cdi container initialisation {}", seContainer == null ? "unsuccessful" : "successful");
	}

	@AfterAll static void afterAll()
	{
		log.debug("cdi container shut down");
		seContainer.close();
		log.debug("cdi container shut down {}", seContainer.isRunning() ? "unsuccessful" : "successful");
	}

	@BeforeEach void beforeEach()
	{
		context = CDI.current().select(CDITestContext.class).get();
		greeter = CDI.current().select(CDIGreeter.class).get();
	}

	@Test void testContextNotNull()
	{
		assertThat(context, is(not(nullValue())));
		assertThat(greeter, is(not(nullValue())));
	}

	@Test void testContextGreeterNotNull()
	{
		assertThat(context.greeter(), is(not(nullValue())));
	}

	@Test void testContextGreeterGreetNotNull()
	{
		assertThat(context.greeter().greet(), is(not(nullValue())));
		log.debug("greetings from context.greeter {}", context.greeter().greet());
		assertThat(greeter.greet(), is(not(nullValue())));
		log.debug("greetings from greeter {}", greeter.greet());
	}
}