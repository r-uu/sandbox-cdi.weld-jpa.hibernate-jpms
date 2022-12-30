package de.ruu.lab.modules.shop.ui.fx.item.edit;

import de.ruu.lib.fx.comp.DefaultFXCView;
import de.ruu.lib.fx.comp.FXCViewService;

public class Edit extends DefaultFXCView
{
	@Override public EditService getService()
	{
		FXCViewService service = super.getService();

		if (service instanceof EditService) return (EditService) service;

		throw new IllegalStateException(
				  "unexpected service type " + service.getClass().getName()
				+ ", expected " + EditService.class.getName());
	}
}