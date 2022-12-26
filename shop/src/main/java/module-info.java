module de.ruu.lab.modules.shop
{
	exports de.ruu.lab.modules.shop;
	exports de.ruu.lab.modules.shop.ui.fx;
	exports de.ruu.lab.modules.shop.ui.fx.catalog;
	exports de.ruu.lab.modules.shop.ui.fx.inventory;
	exports de.ruu.lab.modules.shop.ui.fx.item;
	exports de.ruu.lab.modules.shop.ui.fx.order;
	opens   de.ruu.lab.modules.shop;

	requires javafx.controls;
	requires javafx.fxml;
	requires r.uu.lib.fx.comp;

	requires de.ruu.lab.modules.inventory;
	requires de.ruu.lab.modules.item;
	requires static lombok;
	// makes java package org.slf4j visible, org.slf4j is contained in slf4j.api jar file
	requires slf4j.api;
	requires weld.se.shaded;
}