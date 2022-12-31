package de.ruu.lab.modules.shop.ui.fx;

import de.ruu.lab.modules.shop.ui.fx.catalog.Catalog;
import de.ruu.lab.modules.shop.ui.fx.inventory.Inventory;
import de.ruu.lab.modules.shop.ui.fx.item.Item;
import de.ruu.lab.modules.shop.ui.fx.order.Order;
import de.ruu.lib.fx.comp.DefaultFXCViewController;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShopController extends DefaultFXCViewController
{
	@Inject private Catalog   catalog;
	@Inject private Inventory inventory;
	@Inject private Item      item;
	@Inject private Order     order;

	@FXML private AnchorPane nchrPnCatalog;
	@FXML private AnchorPane nchrPnInventory;
	@FXML private AnchorPane nchrPnItem;
	@FXML private AnchorPane nchrPnItemOrder;

	@Override
	@FXML
	protected void initialize()
	{
		log.debug("initialising");

		nchrPnCatalog  .getChildren().add(catalog  .getLocalRoot());
		nchrPnInventory.getChildren().add(inventory.getLocalRoot());
		nchrPnItem     .getChildren().add(item     .getLocalRoot());
		nchrPnItemOrder.getChildren().add(order    .getLocalRoot());

		log.debug("initialised");
	}
}