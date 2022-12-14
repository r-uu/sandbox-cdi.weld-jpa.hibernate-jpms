package de.ruu.lab.modules.common;

import jakarta.inject.Inject;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
public class CDITestContext
{
	@Getter
	@Inject
	private CDIGreeter greeter;
}