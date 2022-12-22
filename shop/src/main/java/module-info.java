module de.ruu.lab.modules.shop
{
	exports de.ruu.lab.modules.shop;
	opens   de.ruu.lab.modules.shop;

	requires de.ruu.lab.modules.inventory;
	requires de.ruu.lab.modules.item;
	requires lombok;
	// makes java package org.slf4j visible, org.slf4j is contained in slf4j.api jar file
	requires slf4j.api;
	requires weld.se.shaded;
}