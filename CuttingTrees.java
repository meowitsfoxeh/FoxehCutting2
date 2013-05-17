package FoxehCutting2;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class CuttingTrees extends Node {

	@Override
	public boolean activate() {
		SceneObject tree = SceneEntities.getNearest(Main.mytree.getTreeID());
		return tree !=null && tree.getLocation ().distanceTo() < 5;
	}

	@Override
	public void execute() {
		SceneObject tree = SceneEntities.getNearest(Main.mytree.getTreeID());
		if (Players.getLocal().getAnimation()==-1) {
			if (tree.isOnScreen()) {
				tree.interact ("chop");
				final Timer wc = new Timer (2000);
				if (tree != null) {
					while(Players.getLocal().getAnimation() != -1 && wc.isRunning()) {
						Task.sleep (20);
					}
				}
			} else {
				Camera.turnTo(tree);
			}

		}
	}
}
