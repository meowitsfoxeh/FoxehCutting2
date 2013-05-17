package FoxehCutting2;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.GroundItem;

public class BirdNests extends Node {

	@Override
	public boolean activate() {
		GroundItem nest = GroundItems.getNearest(Constants.BIRDS_NESTS);
		return nest !=null;
	}

	@Override
	public void execute() {
		GroundItem nest = GroundItems.getNearest(Constants.BIRDS_NESTS);
		if (nest !=null) 
			nest.interact("Take");
		final Timer birdNest = new Timer (2000);
		while (nest != null && birdNest.isRunning()) {
			Task.sleep (20);
		}
	}
}
