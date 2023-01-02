package de.ruu.lab.modules.shop.ui.fx.inventory;

import static javafx.scene.control.ButtonBar.ButtonData.OK_DONE;

import de.ruu.lab.modules.inventory.InventoryService;
import de.ruu.lab.modules.inventory.Item;
import de.ruu.lab.modules.item.ItemCreated;
import de.ruu.lab.modules.shop.ui.fx.inventory.edit.Edit;
import de.ruu.lab.modules.shop.ui.fx.inventory.edit.EditService;
import de.ruu.lib.fx.comp.DefaultFXCViewController;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableView;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class InventoryController extends DefaultFXCViewController
{
	/** visibility needs to be {@code package} to be proxyable not only by weld */
	@ApplicationScoped
	static class ItemCreatedDispatcher extends EventDispatcher<ItemCreated> { }

	@Inject private ItemCreatedDispatcher dispatcher;

	@Inject private InventoryService inventoryService;
	@Inject private Edit edit;

	@FXML private Button btnUpdate;
	@FXML private TableView<Item> tblVw;

	@Override
	@FXML protected void initialize()
	{
		log.debug("initialising");

		dispatcher.add(e -> onItemCreated(e));

		btnUpdate.setOnAction(e -> onUpdate());

		TableViewConfigurator.configure(tblVw);

		log.debug("initialised");
	}

	private void onItemCreated(ItemCreated itemCreated)
	{
		tblVw.getItems().add(Item.newInstance(itemCreated.item().name(), 0));
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
}