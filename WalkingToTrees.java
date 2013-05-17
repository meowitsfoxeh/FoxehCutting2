package FoxehCutting2;

import org.powerbot.core.script.job.state.Node;  
import org.powerbot.game.api.methods.tab.Inventory;

public class WalkingToTrees extends Node {

	@Override
	public boolean activate() {
		return Main.mytree.getTreeTile().getLocation ().distanceTo() > 2 && !Inventory.isFull();
	}

	@Override
	public void execute() {
		Main.mytree.gettreePath().traverse();

	}
}