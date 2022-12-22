module de.ruu.lab.modules.inventory
{
	exports de.ruu.lab.modules.inventory;
	opens   de.ruu.lab.modules.inventory;
	opens   de.ruu.lab.modules.inventory.internal;
	
	requires de.ruu.lab.modules.item;

	requires transitive jakarta.persistence;
	requires lombok;
	// makes java package org.slf4j visible, org.slf4j is contained in slf4j.api jar file
	requires slf4j.api;
	requires weld.se.shaded;
}