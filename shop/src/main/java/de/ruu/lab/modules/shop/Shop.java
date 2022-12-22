package de.ruu.lab.modules.shop;

import java.math.BigDecimal;
import java.util.Set;

import de.ruu.lab.modules.inventory.InventoryService;
import de.ruu.lab.modules.inventory.Item;
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

	@Inject private InventoryService inventory;

	public void populateInventory()
	{
	}

	public void clearInventory() { inventory.clear(); }

	public Set<Item> inventory() { return inventory.items(); }
}