package be.Vilevar.WolvCoins;


import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import be.Vilevar.WolvCoins.Commands.Coins;

public class WolvCoins extends JavaPlugin implements Listener{
	
	public static Economy economy = null;
	
	 private boolean setupEconomy(){
	        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
	        if (economyProvider != null) {
	            economy = economyProvider.getProvider();
	        }

	        return (economy != null);
	    }
	
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
		
		getCommand("coins").setExecutor(new Coins(this));
		
		//rajouts par minute
		
		int minute = 20*5;;
		final double montant = 1.0;
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
				if(setupEconomy()){
				Player p = (Player) Bukkit.getOnlinePlayers();
				economy.depositPlayer(p, montant);
				}
			}
			
		}, minute, minute);
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(economy.hasAccount(p)){
		}else{
			economy.createBank(getName(), p);
		}
	}
}
