package FoxehCutting2;

import org.powerbot.core.script.job.state.Node;  
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

public class WalkingToTrees extends Node {

	@Override
	public boolean activate() {
		 int dist = Main.mytree == Trees.WILLOW ? 10 : 5;
		return Main.mytree.getTreeTile().getLocation ().distanceTo() > dist && !Inventory.isFull() && !Players.getLocal().isMoving();
	}

	@Override
	public void execute() {
		Main.mytree.gettreePath().traverse();

	}
}