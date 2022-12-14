package de.ruu.lab.modules.common.internal;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ItemDefaultImpl// implements Item
{
	@Id
	@GeneratedValue
	private Long id;

	private String     name;
	private BigDecimal price;

////	ItemDefaultImpl() { }
//	public ItemDefaultImpl() { }

	public ItemDefaultImpl(String name, BigDecimal price)
	{
		this.name  = name;
		this.price = price;
	}

//	public Long id() { return id; }

//	@Override public String name() { return name; }
//
//	@Override public BigDecimal price() { return price; }
}