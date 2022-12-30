package de.ruu.lab.modules.shop.ui.fx.item.edit;

import de.ruu.lib.fx.comp.FXCAppRunner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EditAppRunner extends FXCAppRunner
{
	public static void main(String[] args)
	{
		log.debug("starting " + EditApp.class.getName());
		FXCAppRunner.run(EditApp.class, args);
		log.debug("finished " + EditApp.class.getName());
	}
}