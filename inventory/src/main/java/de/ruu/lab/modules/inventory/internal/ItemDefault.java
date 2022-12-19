package de.ruu.lab.modules.inventory.internal;

import de.ruu.lab.modules.inventory.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "item_inventory", schema = "inventory")
@Getter
@ToString
public class ItemDefault implements Item
{
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private long   stockQuantity;

	public ItemDefault(String name)
	{
		this.name          = name;
		this.stockQuantity = 0L;
	}

	public ItemDefault(Item item) { this(item.name()); }

	public Long id() { return id; }

	@Override public String name() { return getName(); }

	@Override public long stockQuantity() { return getStockQuantity(); }
}