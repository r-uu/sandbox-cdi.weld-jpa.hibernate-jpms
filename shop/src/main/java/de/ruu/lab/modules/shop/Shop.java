package de.ruu.lab.modules.shop;

import java.math.BigDecimal;
import java.util.Set;

import de.ruu.lab.modules.item.ItemCreated;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Shop
{
	@SuppressWarnings("unused")
	private void listen(@Observes ItemCreated event)
	{
		log.info("item created: {}", event.item());
	}

	@Inject private Inventory inventory;

	public void populateInventory()
	{
		inventory.add(Item.create("1", BigDecimal.ONE));
		inventory.add(Item.create("2", BigDecimal.TWO));
		inventory.add(Item.create("3", BigDecimal.valueOf(3L)));
	}

	public void clearInventory() { inventory.clear(); }

	public Set<Item> inventory() { return inventory.items(); }
}