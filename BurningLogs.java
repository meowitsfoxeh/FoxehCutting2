package FoxehCutting2;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class BurningLogs extends Node {

	@Override
	public boolean activate() {
		return Inventory.isFull() && Main.burningLogs;
	}

	@Override
	public void execute() {
		SceneObject fire = SceneEntities.getNearest(Constants.FIRE_ID);
		if (fire !=null) {
			if (Players.getLocal().getAnimation() == -1) {
				if(Inventory.contains(Main.mytree.getLogID())) {
					Item log = Inventory.getItem(Main.mytree.getLogID()); 
					if (log !=null) {
						final Timer bonfire = new Timer (2000);
						while (Players.getLocal().getAnimation()==-1 && bonfire.isRunning()) {
							Task.sleep (20);
						}
						if (fire.click(true)) {
							Main.burning = true;
						}
					}
				}
			}
		} else {

			if (Players.getLocal().getAnimation()==-1) {
				if(Inventory.contains(Main.mytree.getLogID())) {
					Item log = Inventory.getItem(Main.mytree.getLogID());
					if(log != null) {
						log.getWidgetChild().interact("Light");
						final Timer lightFire = new Timer (2000);
						while (Players.getLocal().getAnimation()==-1 && lightFire.isRunning()) {
							Task.sleep (20);
						}
					}
				}
			}
		}   
	}
}
