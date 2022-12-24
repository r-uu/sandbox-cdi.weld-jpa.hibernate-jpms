package de.ruu.lab.modules.shop;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import de.ruu.lab.modules.inventory.InventoryService;
import de.ruu.lab.modules.inventory.Item;
import de.ruu.lab.modules.item.ItemCreated;
import de.ruu.lab.modules.item.ItemService;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Shop
{
	@Inject private InventoryService inventory;
	@Inject private ItemService itemService;

	public void populateInventory()
	{
		for (int i = 0; i < 10; i++)
		{
			inventory.create(Item.newInstance("item " + i));
		}
	}

	public void clearInventory()
	{
		for (Item item : inventory.findAll())
		{
			inventory.delete(item);
		}
	}

	public void populateItems()
	{
		for (int i = 0; i < 10; i++)
		{
			itemService.create(
					de.ruu.lab.modules.item.Item.newInstance("item " + i, BigDecimal.ONE));
		}
	}

	public String reportInventory()
	{
		return
				inventory
						.findAll()
						.stream()
						.sorted((i1, i2) -> i1.name().compareTo(i2.name()))
						.map(Item::toString)
						.collect(Collectors.joining("\n"));
	}

	public String reportItems()
	{
		return
				itemService
						.findAll()
						.stream()
						.sorted(
								   (de.ruu.lab.modules.item.Item i1, de.ruu.lab.modules.item.Item i2)
								-> i1.name().compareTo(i2.name()))
						.map(de.ruu.lab.modules.item.Item::toString)
						.collect(Collectors.joining("\n"));
	}

	@SuppressWarnings("unused")
	private void listen(@Observes ItemCreated event)
	{
		log.info("item created: {}", event.item());
	}
}