package de.ruu.lab.modules.inventory.internal;

import de.ruu.lab.modules.inventory.Item;
import de.ruu.lab.modules.inventory.ItemCreated;

public class ItemCreatedDefault implements ItemCreated
{
	private Item item;

	public ItemCreatedDefault(Item item) { this.item = item; }

	@Override public Item item() { return item; }
}