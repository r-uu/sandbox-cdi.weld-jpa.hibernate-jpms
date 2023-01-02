package de.ruu.lab.modules.inventory;

import de.ruu.lab.modules.inventory.internal.ItemDefault;

public interface Item
{
	Long id();
	String name();
	long stockQuantity();

	static Item newInstance(String name, long stockQuantity) { return new ItemDefault(name, stockQuantity); }
	static Item newInstance(de.ruu.lab.modules.item.Item item) { return new ItemDefault(item); }
}