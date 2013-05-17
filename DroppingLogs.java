package FoxehCutting2;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;

public class DroppingLogs extends Node {

	@Override
	public boolean activate() {

		return Inventory.isFull() && Main.droppingLogs;
	}

	@Override
	public void execute() {
		Item log = Inventory.getItem(Main.mytree.getLogID());
		if (Inventory.contains(Main.mytree.getLogID())) {
			if (log !=null) {
				log.getWidgetChild().interact("Drop");
			}
		}
	}
}
