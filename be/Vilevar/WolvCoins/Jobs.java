package be.Vilevar.WolvCoins.Jobs;

import java.util.UUID;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import be.Vilevar.WolvCoins.WolvCoins;

public enum Jobs {

	FERMIER(0, ChatColor.GREEN+"FERMIER", new ItemStack(Material.IRON_HOE)),
	MINEUR(1, ChatColor.GRAY+"MINEUR", new ItemStack(Material.STONE_PICKAXE)),
	BUCHERON(2, ChatColor.BLUE+"BUCHERON", new ItemStack(Material.WOOD_AXE)),
	CHASSEUR(3, ChatColor.GOLD+"CHASSEUR", new ItemStack(Material.GOLD_SWORD)),
	DEFENSEUR(4, ChatColor.RED+"DEFENSEUR", new ItemStack(Material.DIAMOND_SWORD));
	
	private int slot;
	private String jobName;
	private ItemStack incon;
	
	Jobs(int slot, String jobName, ItemStack incon){
		this.slot = slot;
		this.jobName = jobName;
		this.incon = incon;
	}
	
	//METHODES POUR LES ENUM
	public int getSlot(){
		return slot;
	}
	
	public String getJobName(){
		return jobName;
	}
	
	public ItemStack getIncon(){
		return incon;
	}
	
	public ItemStack getItem(){
		ItemStack i = incon;
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(jobName);
		i.setItemMeta(iM);
		return i;
	}
	
//METHODES D UTILISATION
	//REPERER S IL EST CE METIER
	public Jobs getUtilisator(UUID uuid){
		
		if(uuid == null) return null;
		
		if(WolvCoins.getInstance().jobs.get(uuid) != null){
			return WolvCoins.getInstance().jobs.get(uuid);
		}
		else{
			return null;
		}
	}
	
	//REPERER SES NIVEAUX DE METIERS
	public int getLevel(UUID uuid){
		
		if(uuid == null){
			return 0;
		}
		
		if(WolvCoins.getInstance().level.containsKey(uuid) && WolvCoins.getInstance().level.get(uuid) != null){
			return WolvCoins.getInstance().level.get(uuid);
			
		}else{
			return 0;
		}
	}
	
	//REPERER SES MINI-NIVEAUX DE METIERS
	public double getminiLvl(UUID uuid){
		
		if(uuid == null){
			return 0;
		}
		
		if(WolvCoins.getInstance().miniLvl.containsKey(uuid) && WolvCoins.getInstance().miniLvl.get(uuid) != null){
			return WolvCoins.getInstance().miniLvl.get(uuid);
			
		}else{
			return 0;
		}
	}
	
	//SUPPRIMER LES NIVEAUX DE QUELQU UN
	public void removeLevel(UUID uuid){
		
		if(uuid != null){
			
			if(WolvCoins.getInstance().level.containsKey(uuid)){
				WolvCoins.getInstance().level.remove(uuid);
			}
		}
	}
	
	//SUPPRIMER LES MINI-NIVEAUX DE QUELQU UN
	public void removeMiniLvl(UUID uuid){
		
		if(uuid != null){
			
			if(WolvCoins.getInstance().miniLvl.containsKey(uuid)){
				WolvCoins.getInstance().miniLvl.remove(uuid);
			}
		}
	}
	
	//RAJOUTER UN OU DES NIVEAUX A QUELQU UN
	public void addLevel(UUID uuid, int i){
		
		if(uuid != null && i > 0){
			
			int add = i;
			int finalLevel = 0;
			
			if(WolvCoins.getInstance().level.containsKey(uuid)){
				
				int level = WolvCoins.getInstance().level.get(uuid);
				int finaLlevel = level + add;
				finalLevel = finaLlevel;
				
				WolvCoins.getInstance().level.remove(uuid);
				
			}else{
				finalLevel = add;
			}
			
			WolvCoins.getInstance().level.put(uuid, finalLevel);
		}
	}
	
	//RAJOUTER UN OU DES MINI-NIVEAUX A QUELQU UN
	public void addMiniLvl(UUID uuid, double d){
		
		if(uuid != null && d > 0){
			
			double add = d;
			double finalMiniLvl = 0;
			
			if(!WolvCoins.getInstance().miniLvl.containsKey(uuid)){
				finalMiniLvl = add;
			}
			else if(WolvCoins.getInstance().miniLvl.containsKey(uuid)){
				
				double miniLvl = WolvCoins.getInstance().miniLvl.get(uuid);
				double miMiniLvl = add + miniLvl;
				finalMiniLvl = miMiniLvl;
				
				WolvCoins.getInstance().miniLvl.remove(uuid);
			}
			WolvCoins.getInstance().miniLvl.put(uuid, finalMiniLvl);
		}
	}
	
	//RAJOUTER QUELQU UN DANS UN METIER
	public void add(UUID uuid){
		
		if(uuid != null){
			
			if(WolvCoins.getInstance().jobs.containsKey(uuid)){
				
				if(Jobs.FERMIER.getUtilisator(uuid) == Jobs.FERMIER){
					Jobs.FERMIER.removeLevel(uuid);
				}
				if(Jobs.MINEUR.getUtilisator(uuid) == Jobs.MINEUR){
					Jobs.MINEUR.removeLevel(uuid);
				}
				if(Jobs.BUCHERON.getUtilisator(uuid) == Jobs.BUCHERON){
					Jobs.BUCHERON.removeLevel(uuid);
				}
				if(Jobs.CHASSEUR.getUtilisator(uuid) == Jobs.CHASSEUR){
					Jobs.CHASSEUR.removeLevel(uuid);
				}
				if(Jobs.DEFENSEUR.getUtilisator(uuid) == Jobs.DEFENSEUR){
					Jobs.DEFENSEUR.removeLevel(uuid);
				}
				
				WolvCoins.getInstance().jobs.remove(uuid);
			}
			
			WolvCoins.getInstance().jobs.put(uuid, this);
			WolvCoins.getInstance().level.put(uuid, 0);
			WolvCoins.getInstance().miniLvl.put(uuid, 0.0);
		}
	}
	
	//SUPPRIMER QUELQU'UN DE SON METIER
	public void remove(UUID uuid){
		
		if(uuid != null){
			
			if(WolvCoins.getInstance().jobs.containsKey(uuid)){
				
				if(Jobs.FERMIER.getUtilisator(uuid) == Jobs.FERMIER){
					Jobs.FERMIER.removeLevel(uuid);
				}
				if(Jobs.MINEUR.getUtilisator(uuid) == Jobs.MINEUR){
					Jobs.MINEUR.removeLevel(uuid);
				}
				if(Jobs.BUCHERON.getUtilisator(uuid) == Jobs.BUCHERON){
					Jobs.BUCHERON.removeLevel(uuid);
				}
				if(Jobs.CHASSEUR.getUtilisator(uuid) == Jobs.CHASSEUR){
					Jobs.CHASSEUR.removeLevel(uuid);
				}
				if(Jobs.DEFENSEUR.getUtilisator(uuid) == Jobs.DEFENSEUR){
					Jobs.DEFENSEUR.removeLevel(uuid);
				}
				
				WolvCoins.getInstance().jobs.remove(uuid);
			}
		}
	}
}