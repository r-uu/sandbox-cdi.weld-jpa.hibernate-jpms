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
@Table(name = "item")
@Getter
@ToString
public class ItemDefaultImpl implements Item
{
	@Id
	@GeneratedValue
	private Long id;

	private String     name;
	private BigDecimal price;

	public ItemDefaultImpl(String name, BigDecimal price)
	{
		this.name  = name;
		this.price = price;
	}

	public Long id() { return id; }

	@Override public String name() { return getName(); }

	@Override public BigDecimal price() { return getPrice(); }
}