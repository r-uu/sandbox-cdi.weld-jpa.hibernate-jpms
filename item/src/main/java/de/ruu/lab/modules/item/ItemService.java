package de.ruu.lab.modules.item;

import java.util.Set;

public interface ItemService
{
	Item create(Item item);
	Item find(long id);
	Item update(Item item);
	void delete(Item id);
	Set<Item> findAll();
}