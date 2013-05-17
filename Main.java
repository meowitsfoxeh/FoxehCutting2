package FoxehCutting2;

import java.util.ArrayList;

import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.util.Random;

@Manifest(authors = { "Foxeh" }, description = "WoodCutter", name = "Foxeh WoodCutter2") 



public class Main extends ActiveScript  {
	public static Trees mytree = Trees.MAPLE;  

	public static boolean droppingLogs = false;
	public static boolean burningLogs = false;
	public static boolean burning = false;
	public static boolean running = false;

	public ArrayList<Node> nodes = new ArrayList<Node>();
	public void onStart () {
		nodes.add (new BankWood ());
		nodes.add (new BirdNests ());
		nodes.add (new BurningLogs ());
		nodes.add (new CuttingTrees ());
		nodes.add (new DroppingLogs ());
		nodes.add (new WalkingToBank ());
		nodes.add (new WalkingToTrees ());
		new GUI ();
	}
	@Override
	public int loop() {
		System.out.println(running);
		if (running) {
			for (Node pewpew : nodes) {
				if (pewpew.activate()) {
					System.out.println (pewpew);
					pewpew.execute ();
				} 
			}
		}
		return Random.nextInt(10, 50);
	}
}

