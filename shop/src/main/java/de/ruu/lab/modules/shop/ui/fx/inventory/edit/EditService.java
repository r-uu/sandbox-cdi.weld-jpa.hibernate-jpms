package de.ruu.lab.modules.shop.ui.fx.inventory.edit;

import de.ruu.lib.fx.comp.FXCViewService;

public interface EditService extends FXCViewService
{
	String name();
	void name(String name);
	String stockQuantity();
	void stockQuantity(String stockQuantity);
}