package de.ruu.lab.modules.shop.ui.fx.inventory;

import jakarta.enterprise.event.Observes;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Consumer;

abstract class EventDispatcher<E>
{
	private Set<Consumer<E>> consumers = new LinkedHashSet<>();

	public boolean add(Consumer<E> consumer) { return consumers.add(consumer); }

	public boolean remove(Consumer<E> consumer) { return consumers.remove(consumer); }

	protected void observe(@Observes E event) { consumers.forEach(consumer -> consumer.accept(event)); }
}