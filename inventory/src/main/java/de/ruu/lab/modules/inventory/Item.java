package de.ruu.lab.modules.inventory;

import de.ruu.lab.modules.inventory.internal.ItemDefault;

public interface Item
{
	String name();
	long stockQuantity();

	static Item newInstance(String name) { return new ItemDefault(name); }
}