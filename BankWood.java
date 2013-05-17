package FoxehCutting2;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;


public class BankWood extends Node{
	@Override
	public boolean activate() {
		return Inventory.isFull() && Main.mytree.getbankTile().distanceTo() < 2; 
	}

	@Override
	public void execute() {
		if (Bank.open()) {
			if (Inventory.contains (Main.mytree.getLogID ())){
				Bank.depositInventory();}
			Bank.close();
		}
	}
}


