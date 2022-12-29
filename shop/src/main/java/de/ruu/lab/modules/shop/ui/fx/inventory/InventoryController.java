package de.ruu.lab.modules.shop.ui.fx.inventory;

import de.ruu.lib.fx.comp.DefaultFXCViewController;
import javafx.fxml.FXML;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryController extends DefaultFXCViewController
{
	@Override
	@FXML
	protected void initialize()
	{
		log.debug("initialising");
	}
}