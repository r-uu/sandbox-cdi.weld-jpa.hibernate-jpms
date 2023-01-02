package de.ruu.lab.modules.shop.ui.fx.item;

import de.ruu.lab.modules.item.Item;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

abstract class TableViewConfigurator
{
	static void configure(TableView<Item> tblVw)
	{
		tblVw.getColumns().add(createColumnId());
		tblVw.getColumns().add(createColumnName());
		tblVw.getColumns().add(createColumnPrice());
	}

	private static TableColumn<Item, String> createColumnId()
	{
		TableColumn<Item, String> result = new TableColumn<>("id");
		result.setCellValueFactory(data -> getReadOnlyStringWrapperForId(data));
		result.setCellFactory(TextFieldTableCell.forTableColumn());
		return result;
	}

	private static TableColumn<Item, String> createColumnName()
	{
		TableColumn<Item, String> result = new TableColumn<>("name");
		result.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().name()));
		result.setCellFactory(TextFieldTableCell.forTableColumn());
		return result;
	}

	private static TableColumn<Item, String> createColumnPrice()
	{
		TableColumn<Item, String> result = new TableColumn<>("price");
		result.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().price().toString()));
		result.setCellFactory(TextFieldTableCell.forTableColumn());
		return result;
	}

	private static ReadOnlyStringWrapper getReadOnlyStringWrapperForId(CellDataFeatures<Item, String> data)
	{
		if (data.getValue().id() == null) return new ReadOnlyStringWrapper("");
		return new ReadOnlyStringWrapper(data.getValue().id().toString());
	}
}