package be.Vilevar.WolvCoins.Jobs;

import java.util.Collection;
import java.util.Random;
import java.util.UUID;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.RegisteredServiceProvider;

import be.Vilevar.WolvCoins.WolvCoins;

public class Fermier implements Listener {
	
	//economy
	public Economy economy = null;
	public boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = WolvCoins.getPlugin(WolvCoins.class).getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			economy = economyProvider.getProvider();
		}
		return (economy != null);
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		UUID uuid = p.getUniqueId();
		Material b = e.getBlock().getType();
		if(Jobs.FERMIER.getUtilisator(uuid) != Jobs.FERMIER)return;
		if(Jobs.FERMIER.getUtilisator(uuid) == Jobs.FERMIER){
//			if(WolvCoins.getInstance().notJobsUtilise.contains(p))return;
//			else if(!WolvCoins.getInstance().notJobsUtilise.contains(p)){
				if(b == null)return;
				else if((b == Material.WHEAT || b == Material.POTATO || b == Material.CARROT || b == Material.PUMPKIN || b == Material.MELON_BLOCK || b == Material.BEETROOT_BLOCK || b == Material.COCOA || b == Material.SUGAR_CANE_BLOCK) && setupEconomy()){
/* unSurDix -> 10% 
 * unSurCinq -> 20%
 * unSurVingtCinq -> 4%
 * QuinzeSurCent -> 15%	
 * VingtCinqSurCent -> 25%
 */
					Random rand = new Random();
					int alea = rand.nextInt(99);
					
					if(Jobs.FERMIER.getLevel(uuid) == 0){
						if(WolvCoins.getInstance().unSurCinq.contains(alea)){
							Jobs.FERMIER.addMiniLvl(uuid, 20);
						}
						
					}else if(Jobs.FERMIER.getLevel(uuid) >= 1){
						
						switch(Jobs.FERMIER.getLevel(uuid)){
						
							case 1:
								if(WolvCoins.getInstance().unSurVingtCinq.contains(alea)){
									economy.depositPlayer(p, 2);
								}
								if(WolvCoins.getInstance().unSurDix.contains(alea)){
									Jobs.FERMIER.addMiniLvl(uuid, 15);
								}
							break;
				
							case 2:
								if(WolvCoins.getInstance().unSurVingtCinq.contains(alea)){
									economy.depositPlayer(p, 5);
								}
								if(WolvCoins.getInstance().unSurDix.contains(alea)){
									Jobs.FERMIER.addMiniLvl(uuid, 12.5);
								}
							break;
				
							case 3:
								if(WolvCoins.getInstance().unSurDix.contains(alea)){
									economy.depositPlayer(p, 5);
								}
								if(WolvCoins.getInstance().QuinzeSurCent.contains(alea)){
									Jobs.FERMIER.addMiniLvl(uuid, 10);
								}
							break;
				
							case 4:
								if(WolvCoins.getInstance().unSurDix.contains(alea)){
									economy.depositPlayer(p, 7);
								}
								if(WolvCoins.getInstance().QuinzeSurCent.contains(alea)){
									Jobs.FERMIER.addMiniLvl(uuid, 7.5);
								}
							break;
				
							case 5:
								if(WolvCoins.getInstance().QuinzeSurCent.contains(alea)){
									economy.depositPlayer(p, 8);
								}
								if(WolvCoins.getInstance().unSurDix.contains(alea)){
									Jobs.FERMIER.addMiniLvl(uuid, 10);
								}
							break;
				
							case 6:
								if(WolvCoins.getInstance().unSurCinq.contains(alea)){
									economy.depositPlayer(p, 10);
								}
								if(WolvCoins.getInstance().QuinzeSurCent.contains(alea)){
									Jobs.FERMIER.addMiniLvl(uuid, 7.5);
								}
							break;
				
							case 7:
								if(WolvCoins.getInstance().VingtCinqSurCent.contains(alea)){
									economy.depositPlayer(p, 10);
								}
								if(WolvCoins.getInstance().QuinzeSurCent.contains(alea)){
									Jobs.FERMIER.addMiniLvl(uuid, 6);
								}
							break;
						
							case 8:
								if(WolvCoins.getInstance().VingtCinqSurCent.contains(alea)){
									economy.depositPlayer(p, 15);
								}
								if(WolvCoins.getInstance().unSurCinq.contains(alea)){
									Jobs.FERMIER.addMiniLvl(uuid, 5);
								}
							break;
				
							case 9:
								if(alea >= 50){
									
									Random rand2 = new Random();
									int alea2 = rand2.nextInt(99);
							
									if(!WolvCoins.getInstance().VingtCinqSurCent.contains(alea2)){
										economy.depositPlayer(p, 10);
									}
									if(alea2 <= 49){
										Jobs.FERMIER.addMiniLvl(uuid, 3);
									}
									if(WolvCoins.getInstance().unSurDix.contains(alea2)){
										if(b == Material.WHEAT){
										
											int RDd = alea2+1;
										
											if(RDd == 57 || RDd == 79 || RDd == 17 || RDd == 85 || RDd == 17 || RDd == 41){
												int RDm = RDd-1;
												RDd = RDm;
											}
										
											if(RDd > 20){
												RDd = 20;
											}
											e.getBlock().getDrops().add(getItem(Material.BREAD, RDd, (byte)0));
										}
									}
								}
							break;
				
							case 10:
								if(alea >= 25){
								
									Random rand2 = new Random();
									int alea2 = rand2.nextInt(99);
							
									if(alea2 != 65 && alea2 != 21 && alea2 != 76 && alea2 != 14 && alea2 != 50){
										economy.depositPlayer(p, 10);
									}
									if(alea2 <= 49){
										economy.depositPlayer(p, 20);
									}
									if(WolvCoins.getInstance().unSurCinq.contains(alea2)){
									
										int RDd = alea2+1;
									
										if(RDd == 57 || RDd == 79 || RDd == 17 || RDd == 85 || RDd == 17 || RDd == 41){
											int RDm = RDd-1;
											RDd = RDm;
										}
									
										if(RDd > 20){
											RDd = 20;
										}
									
										Collection<ItemStack> d = e.getBlock().getDrops();
										
										if(b == Material.WHEAT){
											d.add(getItem(Material.BREAD, RDd, (byte)0));
										}
										if(b == Material.POTATO){
											d.add(getItem(Material.BAKED_POTATO, RDd, (byte)0));
										}
										if(b == Material.CARROT){
											d.add(getItem(Material.GOLDEN_CARROT, RDd, (byte)0));
										}
										if(b == Material.PUMPKIN){
											d.add(getItem(Material.PUMPKIN_PIE, RDd, (byte)0));
										}
										if(b == Material.MELON_BLOCK){
											d.add(getItem(Material.SPECKLED_MELON, RDd, (byte)0));
										}
										if(b == Material.BEETROOT_BLOCK){
											d.add(getItem(Material.BEETROOT_SOUP, RDd, (byte)0));
										}
										if(b == Material.COCOA){
											d.add(getItem(Material.COOKIE, RDd, (byte)0));
										}
										if(b == Material.SUGAR_CANE_BLOCK){
											d.add(getItem(Material.SUGAR, RDd, (byte)0));
										}
										p.sendMessage("Teste temps : "+RDd);
									}
								}
							break;
						}
					}
					if(Jobs.FERMIER.getminiLvl(uuid) >= 100){
						Jobs.FERMIER.removeMiniLvl(uuid);
						Jobs.FERMIER.addLevel(uuid, 1);
						p.sendMessage("Vous montez de 1 niveau de métier ("+Jobs.FERMIER.getLevel(uuid)+").");
					}
//					WolvCoins.getInstance()
				}
//			}
		}
	}

	private ItemStack getItem(Material mat, int nb, byte data) {
		ItemStack i = new ItemStack(mat, nb, data);
		return i;
	}
}