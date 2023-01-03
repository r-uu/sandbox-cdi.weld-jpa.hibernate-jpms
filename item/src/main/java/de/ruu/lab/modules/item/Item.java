package de.ruu.lab.modules.item;

import de.ruu.lab.modules.item.internal.ItemDefault;
import java.math.BigDecimal;

public interface Item
{
	Long id();

	String name();
	void name(String name);

	BigDecimal price();
	void price(BigDecimal price);

	static Item newInstance(String name, BigDecimal price) { return new ItemDefault(name, price); }
}