package de.ruu.lab.modules.shop.ui.fx;

import de.ruu.lib.fx.comp.FXCAppRunner;
import lombok.extern.slf4j.Slf4j;

/**
 * {@link ShopAppRunner} application runner
 */
@Slf4j
public class ShopAppRunner extends FXCAppRunner 
{
	public static void main(String[] args)
	{
		log.debug("starting " + ShopApp.class.getName());
		FXCAppRunner.run(ShopApp.class, args);
		log.debug("finished " + ShopApp.class.getName());
	}
}