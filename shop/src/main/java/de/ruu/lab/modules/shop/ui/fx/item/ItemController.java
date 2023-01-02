package de.ruu.lab.modules.shop.ui.fx.item;

import static javafx.scene.control.ButtonBar.ButtonData.OK_DONE;

import de.ruu.lab.modules.item.Item;
import de.ruu.lab.modules.item.ItemCreated;
import de.ruu.lab.modules.item.ItemService;
import de.ruu.lab.modules.shop.ui.fx.item.edit.Edit;
import de.ruu.lab.modules.shop.ui.fx.item.edit.EditService;
import de.ruu.lib.fx.comp.DefaultFXCViewController;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableView;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ItemController extends DefaultFXCViewController
{
	/** visibility needs to be {@code package} to be proxyable not only by weld */
	@ApplicationScoped
	static class ItemCreatedDispatcher extends EventDispatcher<ItemCreated>
	{ }

	@Inject private ItemCreatedDispatcher dispatcher;

	@Inject private ItemService itemService;
	@Inject private Edit edit;

	@FXML private Button btnCreate;
	@FXML private Button btnDelete;
	@FXML private TableView<Item> tblVw;

	@Override
	@FXML protected void initialize()
	{
		log.debug("initialising");

		dispatcher.add(itemCreated -> onItemCreated(itemCreated));

		btnCreate.setOnAction(e -> onCreate());
		btnDelete.setOnAction(e -> onDelete());

		TableViewConfigurator.configure(tblVw);

		log.debug("initialised");
	}

	private void onItemCreated(ItemCreated itemCreated)
	{
		tblVw.getItems().add(Item.newInstance(itemCreated.item()));
	}

	private void onCreate()
	{
		Dialog<Item> dialog = new Dialog<>();

		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.setContent(edit.getLocalRoot());
		dialogPane.getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);

		dialog.setTitle("new item");
		dialog.setResultConverter(btn -> dialogResultConverter(btn, edit));

		// wait for editor result
		Optional<Item> optional = dialog.showAndWait();

		if (optional.isPresent())
		{
			Item item = itemService.create(optional.get());
		}
	}

	private void onDelete()
	{
		itemService.delete(tblVw.getSelectionModel().getSelectedItem());
	}

	private Item dialogResultConverter(ButtonType btn, Edit edit)
	{
		if (btn == null) return null;
		if (btn.getButtonData() == OK_DONE)
		{
			EditService editService = edit.getService();
			return Item.newInstance(editService.name(), new BigDecimal(editService.price()));
		}
		return null;
	}
}