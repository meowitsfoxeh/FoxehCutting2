package FoxehCutting2;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Timer;


public class BankWood extends Node{
	@Override
	public boolean activate() {
		return Inventory.isFull() && Main.mytree.getbankTile().distanceTo() < 2; 
	}

	@Override
	public void execute() {
		if (Bank.open()) {
			final Timer bank = new Timer (2000);
			while(bank.isRunning() && !Bank.isOpen()) {
				Task.sleep (50);
			}
			if (Inventory.contains (Main.mytree.getLogID ())){
				Bank.depositInventory(); 
				final Timer meow = new Timer (2000);
				while(meow.isRunning() && !Inventory.isFull()) {
					Task.sleep (50);
				}
			} else {
				Bank.close();
				final Timer close = new Timer (2000);
				while(close.isRunning() && Bank.isOpen ()) {
					Task.sleep (50);
				}
			}
		}
	}
}
