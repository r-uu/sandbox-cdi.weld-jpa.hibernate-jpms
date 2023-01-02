package de.ruu.lab.modules.item.internal;

import de.ruu.lab.modules.item.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.ToString;

@Entity(name = "item")
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

	/** required by jpa */
	protected ItemDefault() { }

	public ItemDefault(String name, BigDecimal price)
	{
		this.name  = name;
		this.price = price;
	}

	@Override public Long id() { return id; }

	@Override public String name() { return getName(); }

	@Override public BigDecimal price() { return getPrice(); }
}