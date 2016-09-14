package be.Vilevar.WolvCoins;

import java.util.HashMap;
import java.util.UUID;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import be.Vilevar.WolvCoins.Events.EventsManager;
import be.Vilevar.WolvCoins.Jobs.Jobs;

public class WolvCoins extends JavaPlugin {

	public HashMap<UUID, Jobs> jobs = new HashMap<>();
	public HashMap<UUID, Integer> level = new HashMap<>();
	public HashMap<UUID, Double> miniLvl = new HashMap<>();
	
	//PAS OUBLIER DE METTRE LA PERMISSION A LA COMMANDE /COINS SET <JOUEUR> <NB DE COINS>
	
	//premium
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

	//best coins
	public double meilleurCW = 1;
	public String meilleurPlayer = "";

	//economy
	public static Economy economy = null;
	public static boolean setupEconomy() {
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
		new EventsManager(this).registerEvents();
		
		// addCoins
		long temps = 20 * 60;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

					@Override
					public void run() {

						if (setupEconomy()) {
							for (Player pls : Bukkit.getOnlinePlayers()) {
								if (!premium.containsKey(pls.getUniqueId())) {
									economy.depositPlayer(pls, 1);
								}
								if (economy.getBalance(pls) > meilleurCW) {

									String meilleurP = pls.getName();
									meilleurCW = economy.getBalance(pls);
									meilleurPlayer = meilleurP;
								}
								if (premium1.containsKey(pls.getUniqueId())) {
									economy.depositPlayer(pls, 1.5);
								}
								if (premium2.containsKey(pls.getUniqueId())) {
									economy.depositPlayer(pls, 2);
								}
								if (premium3.containsKey(pls.getUniqueId())) {
									economy.depositPlayer(pls, 2.5);
								}
								if (premium4.containsKey(pls.getUniqueId())) {
									economy.depositPlayer(pls, 3);
								}
								if (premium5.containsKey(pls.getUniqueId())) {
									economy.depositPlayer(pls, 3.5);
								}
								if (premium6.containsKey(pls.getUniqueId())) {
									economy.depositPlayer(pls, 4);
								}
								if (premium7.containsKey(pls.getUniqueId())) {
									economy.depositPlayer(pls, 5);
								}
								if (premium8.containsKey(pls.getUniqueId())) {
									economy.depositPlayer(pls, 6);
								}
								if (premium9.containsKey(pls.getUniqueId())) {
									economy.depositPlayer(pls, 7);
								}
								if (premium10.containsKey(pls.getUniqueId())) {
									economy.depositPlayer(pls, 10);
								}
							}
						}
					}
				}, temps, temps);
	}
}