package de.ruu.lab.modules.item;

import java.math.BigDecimal;

import de.ruu.lab.modules.item.internal.ItemDefault;

public interface Item
{
	String name();
	BigDecimal price();

	static Item newInstance(String name, BigDecimal price) { return new ItemDefault(name, price); }
}