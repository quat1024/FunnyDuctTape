package agency.highlysuspect.funnyducttape;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FunnyDuctTape implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("funnyducttape");
	
	@Override
	public void onInitialize() {
		LOGGER.info("FUNNY DUCT TAPE IS HERE TO DUCT TAPE THE GAME TOGETHER.... LETS GO");
	}
}
