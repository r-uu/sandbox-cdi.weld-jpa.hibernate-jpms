package de.ruu.lab.modules.shop.ui.fx.item.edit;

import de.ruu.lib.fx.comp.DefaultFXCViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

class EditController extends DefaultFXCViewController implements EditService
{
	@FXML private TextField txtFldName;
	@FXML private TextField txtFldPrice;

	@Override public String name()  { return txtFldName .getText(); }
	@Override public String price() { return txtFldPrice.getText(); }

	@Override protected void initialize()
	{
		// empty implementation, do not call super.initialize() as that would throw ExceptionInInitializerError
	}
}