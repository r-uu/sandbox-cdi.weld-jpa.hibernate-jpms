package de.ruu.lab.modules.shop.ui.fx.inventory;

import de.ruu.lab.modules.inventory.InventoryService;
import de.ruu.lab.modules.inventory.Item;
import de.ruu.lab.modules.inventory.ItemCreated;
import de.ruu.lab.modules.shop.ui.fx.inventory.edit.Edit;
import de.ruu.lab.modules.shop.ui.fx.inventory.edit.EditService;
import de.ruu.lib.fx.comp.DefaultFXCViewController;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Optional;

import static javafx.scene.control.ButtonBar.ButtonData.OK_DONE;

@Slf4j
class InventoryController extends DefaultFXCViewController
{
	@Inject private InventoryService inventoryService;
	@Inject private Edit edit;

	@FXML private Button btnUpdate;
	@FXML private TableView<Item> tblVw;

	@Override
	@FXML protected void initialize()
	{
		log.debug("initialising");

		btnUpdate.setOnAction(e -> onUpdate());

		TableViewConfigurator.configure(tblVw);

		log.debug("initialised");
	}

	private void onUpdate()
	{
		Dialog<Item> dialog = new Dialog<>();

		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.setContent(edit.getLocalRoot());
		dialogPane.getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);

		dialog.setTitle("new item");
		dialog.setResultConverter(btn -> dialogResultConverter(btn, edit));

		Item item = tblVw.getSelectionModel().getSelectedItem();
		edit.getService().name(item.name());
		edit.getService().stockQuantity("" + item.stockQuantity());

		// wait for editor result
		Optional<Item> optional = dialog.showAndWait();

		if (optional.isPresent())
		{
			tblVw.getItems().remove(item);
			tblVw.getItems().add(inventoryService.update(optional.get()));
		}
	}

	private void onDelete()
	{
		inventoryService.delete(tblVw.getSelectionModel().getSelectedItem());
	}

	private Item dialogResultConverter(ButtonType btn, Edit edit)
	{
		if (btn == null) return null;
		if (btn.getButtonData() == OK_DONE)
		{
			EditService editService = edit.getService();
			return Item.newInstance(editService.name(), Long.valueOf(editService.stockQuantity()));
		}
		return null;
	}

	@ApplicationScoped private class Observer
	{
		private void listen(@Observes ItemCreated event)
		{
			log.info("received event - item created: {}, adding item to table", event.item());
			tblVw.getItems().add(event.item());
		}
	}
}