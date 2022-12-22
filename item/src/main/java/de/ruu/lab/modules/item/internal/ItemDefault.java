package de.ruu.lab.modules.item.internal;

import java.math.BigDecimal;

import de.ruu.lab.modules.item.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "item", schema = "item")
@Getter
@ToString
public class ItemDefault implements Item
{
	@Id
	@GeneratedValue
	private Long id;

	private String     name;
	private BigDecimal price;

	public ItemDefault(String name, BigDecimal price)
	{
		this.name  = name;
		this.price = price;
	}

	public ItemDefault(Item item) { this(item.name(), item.price()); }

	public Long id() { return id; }

	@Override public String name() { return getName(); }

	@Override public BigDecimal price() { return getPrice(); }
}