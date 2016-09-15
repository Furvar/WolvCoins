package be.Vilevar.WolvCoins.Jobs;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import be.Vilevar.WolvCoins.WolvCoins;

public enum Jobs {

	FEMIER(1, "fermier", new ItemStack(Material.DIAMOND_HOE)),
	MINEUR(2, "mineur", new ItemStack(Material.DIAMOND_PICKAXE)),
	BUCHERON(3, "bucheron", new ItemStack(Material.DIAMOND_AXE)),
	CHASSEUR(4, "chasseur", new ItemStack(Material.GOLD_SWORD)),
	DEFENSEUR(5, "défenseur", new ItemStack(Material.DIAMOND_SWORD));
	
	private int slot;
	private String jobName;
	private ItemStack incon;
	
	Jobs(int slot, String jobName, ItemStack incon){
		this.slot = slot;
		this.jobName = jobName;
		this.incon = incon;
	}
	
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
	
	public Jobs getUtilisator(UUID uuid){
		
		if(uuid == null){
			return null;
		}
		if(WolvCoins.getInstance().jobs.get(uuid) != null){
			return WolvCoins.getInstance().jobs.get(uuid);
		}
		else{
			return null;
		}
	}
	
	public void add(UUID uuid){
		
		if(WolvCoins.getInstance().jobs.containsKey(uuid)){
			WolvCoins.getInstance().jobs.remove(uuid);
		}
		
		WolvCoins.getInstance().jobs.put(uuid, this);
	}
}