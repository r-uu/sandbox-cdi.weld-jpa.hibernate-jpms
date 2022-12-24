package de.ruu.lab.modules.inventory;

import java.util.Set;

public interface InventoryService
{
	Item create(Item item);
	Item find(long id);
	Item update(Item item);
	void delete(Item item);
	Set<Item> findAll();
}