package de.ruu.lab.modules.common;

import java.math.BigDecimal;

import de.ruu.lab.modules.common.internal.ItemDefaultImpl;

public interface Item
{
	String name();
	BigDecimal price();

	static ItemDefaultImpl newInstance(String name, BigDecimal price) { return new ItemDefaultImpl(name, price); }
}