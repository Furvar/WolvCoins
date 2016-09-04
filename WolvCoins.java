package be.Vilevar.WolvCoins;

import java.util.HashMap;
import java.util.UUID;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import be.Vilevar.WolvCoins.Commands.Coins;

public class WolvCoins extends JavaPlugin implements Listener{

public HashMap<UUID, Integer> premium = new HashMap<>();
public HashMap<UUID, Integer> premium1 = new HashMap<>();
public HashMap<UUID, Integer> premium2 = new HashMap<>();
public HashMap<UUID, Integer> premium3 = new HashMap<>();
public HashMap<UUID, Integer> premium4 = new HashMap<>();
public HashMap<UUID, Integer> premium5 = new HashMap<>();
public HashMap<UUID, Integer> premium6 = new HashMap<>();
public HashMap<UUID, Integer> premium7 = new HashMap<>();
public HashMap<UUID, Integer> premium8 = new HashMap<>();
public HashMap<UUID, Integer> premium9 = new HashMap<>();
public HashMap<UUID, Integer> premium10 = new HashMap<>();
	
public double meilleurCW = 1;
public String meilleurPlayer = "";

@SuppressWarnings("unused")
private int p1;
@SuppressWarnings("unused")
private int p2;
@SuppressWarnings("unused")
private int p3;
@SuppressWarnings("unused")
private int p4;
@SuppressWarnings("unused")
private int p5;
@SuppressWarnings("unused")
private int p6;
@SuppressWarnings("unused")
private int p7;
@SuppressWarnings("unused")
private int p8;
@SuppressWarnings("unused")
private int p9;
@SuppressWarnings("unused")
private int p10;
@SuppressWarnings("unused")

private int addCoins;
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
		
		//commands
		getCommand("coins").setExecutor(new Coins(this));
		//addCoins
		long temps = 20*60;
		addCoins = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
			
			if(setupEconomy()){
				for(Player pls : Bukkit.getOnlinePlayers()){
					if(!premium.containsKey(pls.getUniqueId())){
					economy.depositPlayer(pls, 1);
					}
					if(economy.getBalance(pls) > meilleurCW){

						String meilleurP = pls.getName();
						meilleurCW = economy.getBalance(pls);
						meilleurPlayer = meilleurP;
					}
				}
				}
			}
		}, temps, temps);
		
		p1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
			
				if(setupEconomy()){
					for(Player pls : Bukkit.getOnlinePlayers()){
						if(premium1.containsKey(pls.getUniqueId())){
							economy.depositPlayer(pls, 1.5);
						}
					}
				}
			}
		},temps, temps);
		
		p2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
			
				if(setupEconomy()){
					for(Player pls : Bukkit.getOnlinePlayers()){
						if(premium2.containsKey(pls.getUniqueId())){
							economy.depositPlayer(pls, 2);
						}
					}
				}
			}
		},temps, temps);
		
		p3 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
			
				if(setupEconomy()){
					for(Player pls : Bukkit.getOnlinePlayers()){
						if(premium3.containsKey(pls.getUniqueId())){
							economy.depositPlayer(pls, 2.5);
						}
					}
				}
			}
		},temps, temps);
		
		p4 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
			
				if(setupEconomy()){
					for(Player pls : Bukkit.getOnlinePlayers()){
						if(premium4.containsKey(pls.getUniqueId())){
							economy.depositPlayer(pls, 3);
						}
					}
				}
			}
		},temps, temps);
		
		p5 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
			
				if(setupEconomy()){
					for(Player pls : Bukkit.getOnlinePlayers()){
						if(premium5.containsKey(pls.getUniqueId())){
							economy.depositPlayer(pls, 3.5);
						}
					}
				}
			}
		},temps, temps);
		
		p6 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
			
				if(setupEconomy()){
					for(Player pls : Bukkit.getOnlinePlayers()){
						if(premium6.containsKey(pls.getUniqueId())){
							economy.depositPlayer(pls, 4);
						}
					}
				}
			}
		},temps, temps);
		
		p7 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
			
				if(setupEconomy()){
					for(Player pls : Bukkit.getOnlinePlayers()){
						if(premium7.containsKey(pls.getUniqueId())){
							economy.depositPlayer(pls, 5);
						}
					}
				}
			}
		},temps, temps);
		
		p8 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
			
				if(setupEconomy()){
					for(Player pls : Bukkit.getOnlinePlayers()){
						if(premium8.containsKey(pls.getUniqueId())){
							economy.depositPlayer(pls, 6);
						}
					}
				}
			}
		},temps, temps);
		
		p9 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
			
				if(setupEconomy()){
					for(Player pls : Bukkit.getOnlinePlayers()){
						if(premium9.containsKey(pls.getUniqueId())){
							economy.depositPlayer(pls, 7);
						}
					}
				}
			}
		},temps, temps);
		
		p10 = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
			
				if(setupEconomy()){
					for(Player pls : Bukkit.getOnlinePlayers()){
						if(premium10.containsKey(pls.getUniqueId())){
							economy.depositPlayer(pls, 10);
						}
					}
				}
			}
		},temps, temps);
	}
}