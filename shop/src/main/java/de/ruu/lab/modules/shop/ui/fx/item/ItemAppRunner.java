package de.ruu.lab.modules.shop.ui.fx.item;

import de.ruu.lib.fx.comp.FXCAppRunner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ItemAppRunner extends FXCAppRunner
{
	public static void main(String[] args)
	{
		log.debug("starting " + ItemApp.class.getName());
		FXCAppRunner.run(ItemApp.class, args);
		log.debug("finished " + ItemApp.class.getName());
	}
}