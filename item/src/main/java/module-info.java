module de.ruu.lab.modules.common
{
	exports de.ruu.lab.modules.item;
	opens   de.ruu.lab.modules.item;
	opens   de.ruu.lab.modules.item.internal;

	requires transitive jakarta.persistence;
	requires lombok;
	// makes java package org.slf4j visible, org.slf4j is contained in slf4j.api jar file
	requires slf4j.api;
	requires weld.se.shaded;
}