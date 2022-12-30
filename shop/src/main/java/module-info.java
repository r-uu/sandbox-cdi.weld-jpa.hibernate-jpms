module de.ruu.lab.modules.shop
{
	exports de.ruu.lab.modules.shop;
	exports de.ruu.lab.modules.shop.ui.fx;
	exports de.ruu.lab.modules.shop.ui.fx.catalog;
	exports de.ruu.lab.modules.shop.ui.fx.inventory;
	exports de.ruu.lab.modules.shop.ui.fx.item;
	exports de.ruu.lab.modules.shop.ui.fx.order;
	exports de.ruu.lab.modules.shop.ui.fx.item.edit to javafx.graphics;

	opens   de.ruu.lab.modules.shop;
	opens   de.ruu.lab.modules.shop.ui.fx           to weld.se.shaded;
	opens   de.ruu.lab.modules.shop.ui.fx.catalog   to weld.se.shaded;
	opens   de.ruu.lab.modules.shop.ui.fx.inventory to weld.se.shaded;
	opens   de.ruu.lab.modules.shop.ui.fx.item      to weld.se.shaded;
	opens   de.ruu.lab.modules.shop.ui.fx.item.edit to weld.se.shaded;
	opens   de.ruu.lab.modules.shop.ui.fx.order     to weld.se.shaded;

	requires javafx.controls;
	requires javafx.fxml;

	requires static lombok;
	// makes java package org.slf4j visible, org.slf4j is contained in slf4j.api jar file
	requires slf4j.api;
	requires weld.se.shaded;

	requires ruu.lib.fx.comp;
	requires ruu.lib.fx.core;

	requires de.ruu.lab.modules.inventory;
	requires de.ruu.lab.modules.item;
}