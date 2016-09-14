package be.Vilevar.WolvCoins.Events;

import be.Vilevar.WolvCoins.WolvCoins;
import be.Vilevar.WolvCoins.Commands.Coins;
import be.Vilevar.WolvCoins.Commands.Epee;
import be.Vilevar.WolvCoins.Commands.Hache;
import be.Vilevar.WolvCoins.Commands.Houe;
import be.Vilevar.WolvCoins.Commands.JobsMaincmd;
import be.Vilevar.WolvCoins.Commands.Pioche;

public class EventsManager {

	public WolvCoins pl;
	
	public EventsManager(WolvCoins wolvCoins) {
		this.pl = wolvCoins;
	}

	public void registerEvents() {
	
/*		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Fermier(), pl);
		pm.registerEvents(new Mineur(), pl);
		pm.registerEvents(new Bucheron(), pl);
		pm.registerEvents(new Chasseur(), pl);
		pm.registerEvents(new Defenseur(), pl);*/
		
		// for coins
		pl.getCommand("coins").setExecutor(new Coins());
		//for jobs
		pl.getCommand("jobs").setExecutor(new JobsMaincmd());
		pl.getCommand("houe").setExecutor(new Houe());
		pl.getCommand("pioche").setExecutor(new Pioche());
		pl.getCommand("hache").setExecutor(new Hache());
		pl.getCommand("epee").setExecutor(new Epee());
	}
}
