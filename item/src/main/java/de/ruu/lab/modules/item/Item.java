package de.ruu.lab.modules.item;

import de.ruu.lab.modules.item.internal.ItemDefault;
import java.math.BigDecimal;

public interface Item
{
	Long id();
	String name();
	BigDecimal price();

	static Item newInstance(String name, BigDecimal price) { return new ItemDefault(name, price); }
	static Item newInstance(Item item) { return new ItemDefault(item); }
}