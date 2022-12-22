package de.ruu.lab.modules.item.internal;

import de.ruu.lab.modules.item.Item;
import de.ruu.lab.modules.item.ItemCreated;

public class ItemCreatedDefault implements ItemCreated
{
	private Item item;

	public ItemCreatedDefault(Item item) { this.item = item; }

	@Override public Item item() { return item; }
}