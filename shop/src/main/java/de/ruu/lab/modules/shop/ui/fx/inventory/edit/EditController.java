package de.ruu.lab.modules.shop.ui.fx.inventory.edit;

import de.ruu.lib.fx.comp.DefaultFXCViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

class EditController extends DefaultFXCViewController implements EditService
{
	@FXML private TextField txtFldName;
	@FXML private TextField txtFldStockQuantity;

	@Override public String name() { return txtFldName.getText(); }
	@Override public void   name(String name) { txtFldName.setText(name); }

	@Override public String stockQuantity() { return txtFldStockQuantity.getText(); }
	@Override public void stockQuantity(String stockQuantity) { txtFldStockQuantity.setText(stockQuantity); }

	@Override protected void initialize()
	{
		txtFldName.requestFocus();
	}
}