package be.Vilevar.WolvCoins.Events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import be.Vilevar.WolvCoins.WolvCoins;
import be.Vilevar.WolvCoins.Commands.Coins;
import be.Vilevar.WolvCoins.Commands.MainJobsCmd;
import be.Vilevar.WolvCoins.Jobs.Fermier;
import be.Vilevar.WolvCoins.Jobs.JobsClickMenu;
import be.Vilevar.WolvCoins.Utils.Shop;

public class EventsManager {

	public WolvCoins pl;
	
	public EventsManager(WolvCoins wolvCoins) {
		this.pl = wolvCoins;
	}

	public void registerEvents() {

		PluginManager pm = Bukkit.getPluginManager();
		
		//for coins
		pl.getCommand("coins").setExecutor(new Coins());
		
		//for jobs
		pl.getCommand("jobs").setExecutor(new MainJobsCmd());
		pm.registerEvents(new JobsClickMenu(), pl);
		pm.registerEvents(new Fermier(), pl);
/*		pm.registerEvents(new Mineur(), pl);
		pm.registerEvents(new Bucheron(), pl);
		pm.registerEvents(new Chasseur(), pl);
		pm.registerEvents(new Defenseur(), pl);*/
		
		//for shop
		pm.registerEvents(new Shop(), pl);
	}
}
