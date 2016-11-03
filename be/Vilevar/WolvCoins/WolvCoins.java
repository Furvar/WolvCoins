package be.Vilevar.WolvCoins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
//import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import be.Vilevar.WolvCoins.Events.EventsManager;
import be.Vilevar.WolvCoins.Jobs.Jobs;
import be.Vilevar.WolvCoins.Jobs.JobsClickMenu;
import be.Vilevar.WolvCoins.Utils.Shop;

public class WolvCoins extends JavaPlugin implements Listener {

	public HashMap<UUID, Jobs> jobs = new HashMap<>();
	public HashMap<UUID, Integer> level = new HashMap<>();
	public HashMap<UUID, Double> miniLvl = new HashMap<>();
	
	public ArrayList<Integer> unSurDix = new ArrayList<>(); // 10%
	public ArrayList<Integer> unSurCinq = new ArrayList<>(); // 20%
	public ArrayList<Integer> unSurVingtCinq = new ArrayList<>(); // 4%
	public ArrayList<Integer> QuinzeSurCent = new ArrayList<>(); // 15%
	public ArrayList<Integer> VingtCinqSurCent = new ArrayList<>(); // 25%
	
//	public ArrayList<Player> notJobsUtilise = new ArrayList<>();

	//best coins
	public double meilleurCW = 1;
	public String meilleurPlayer = ChatColor.DARK_BLUE+"¤kpersonne";

	//economy
	public Economy economy = null;
	public boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = WolvCoins.getPlugin(WolvCoins.class).getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			economy = economyProvider.getProvider();
		}
		return (economy != null);
	}

	public static WolvCoins instance;
	
	public static WolvCoins getInstance(){
		return instance;
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		new EventsManager(this).registerEvents();

		//config
//		getConfig().options().copyDefaults(true);
//		saveConfig();
		
		//constructor
		new JobsClickMenu();
		new Shop();
		
		int temps = 5*20;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
			
			if(setupEconomy()){
				for(Player pls : Bukkit.getOnlinePlayers()){
						if (economy.getBalance(pls) > meilleurCW) {

							String meilleurP = pls.getName();
							meilleurCW = economy.getBalance(pls);
							meilleurPlayer = meilleurP;
						}
					}
				}
			}	
		}, temps, temps);
		
		// 10%
		unSurDix.add(5);
		unSurDix.add(56);
		unSurDix.add(78);
		unSurDix.add(91);
		unSurDix.add(7); 
		unSurDix.add(16);
		unSurDix.add(35);
		unSurDix.add(84);
		unSurDix.add(26);
		unSurDix.add(40);
		
		// 20%
		unSurCinq.add(4);
		unSurCinq.add(58);
		unSurCinq.add(69);
		unSurCinq.add(31);
		unSurCinq.add(68);
		unSurCinq.add(2);
		unSurCinq.add(60);
		unSurCinq.add(71);
		unSurCinq.add(35);
		unSurCinq.add(94);
		unSurCinq.add(11);
		unSurCinq.add(0);
		unSurCinq.add(96);
		unSurCinq.add(15);
		unSurCinq.add(34);
		unSurCinq.add(86);
		unSurCinq.add(73);
		unSurCinq.add(10);
		unSurCinq.add(99);
		unSurCinq.add(84);
		unSurCinq.add(12);
		
		// 4%
		unSurVingtCinq.add(75);
		unSurVingtCinq.add(50);
		unSurVingtCinq.add(25);
		unSurVingtCinq.add(99);
		
		// 15%
		QuinzeSurCent.add(3);
		QuinzeSurCent.add(5);
		QuinzeSurCent.add(96);
		QuinzeSurCent.add(45);
		QuinzeSurCent.add(73);
		QuinzeSurCent.add(16);
		QuinzeSurCent.add(29);
		QuinzeSurCent.add(67);
		QuinzeSurCent.add(88);
		QuinzeSurCent.add(34);
		QuinzeSurCent.add(70);
		QuinzeSurCent.add(30);
		QuinzeSurCent.add(20);
		QuinzeSurCent.add(19);
		QuinzeSurCent.add(48);
		
		// 25%
		VingtCinqSurCent.add(4);
		VingtCinqSurCent.add(58);
		VingtCinqSurCent.add(69);
		VingtCinqSurCent.add(31);
		VingtCinqSurCent.add(68);
		VingtCinqSurCent.add(2);
		VingtCinqSurCent.add(60);
		VingtCinqSurCent.add(71);
		VingtCinqSurCent.add(35);
		VingtCinqSurCent.add(94);
		VingtCinqSurCent.add(11);
		VingtCinqSurCent.add(0);
		VingtCinqSurCent.add(96);
		VingtCinqSurCent.add(15);
		VingtCinqSurCent.add(34);
		VingtCinqSurCent.add(86);
		VingtCinqSurCent.add(73);
		VingtCinqSurCent.add(10);
		VingtCinqSurCent.add(99);
		VingtCinqSurCent.add(84);
		VingtCinqSurCent.add(12);
		VingtCinqSurCent.add(54);
		VingtCinqSurCent.add(3);
		VingtCinqSurCent.add(98);
		VingtCinqSurCent.add(7);
		VingtCinqSurCent.add(59);
	}
}




















