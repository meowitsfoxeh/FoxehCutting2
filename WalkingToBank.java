package FoxehCutting2;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;


public class WalkingToBank extends Node {

	@Override
	public boolean activate() {
		return Inventory.isFull() && Main.mytree.getbankTile().distanceTo() > 2 && !Players.getLocal().isMoving();
	}

	@Override
	public void execute() {
		Main.mytree.getbankPath().traverse();
	}
}
