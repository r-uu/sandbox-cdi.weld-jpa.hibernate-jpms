package de.ruu.lab.modules.shop.ui.fx;

import static de.ruu.lib.fx.FXUtil.*;

import de.ruu.lab.modules.shop.ui.fx.catalog.Catalog;
import de.ruu.lab.modules.shop.ui.fx.inventory.Inventory;
import de.ruu.lab.modules.shop.ui.fx.item.Item;
import de.ruu.lab.modules.shop.ui.fx.order.Order;
import de.ruu.lib.fx.FXUtil;
import de.ruu.lib.fx.comp.DefaultFXCViewController;
import de.ruu.lib.fx.comp.FXCAppStartedEvent;
import jakarta.inject.Inject;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
//		nchrPnInventory.getChildren().add(inventory.getLocalRoot());
		Optional<Stage> optional = getStage(nchrPnInventory);
		if (optional.isPresent()) optional.get().setTitle("shop");
	}
}