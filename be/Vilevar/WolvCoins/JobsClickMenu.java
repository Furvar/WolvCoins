package be.Vilevar.WolvCoins.Jobs;

import java.util.ArrayList;
import java.util.UUID;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import be.Vilevar.WolvCoins.Commands.MainJobsCmd;

public class JobsClickMenu implements Listener {

	ArrayList<ItemStack> item = new ArrayList<>();
	
	Inventory Fermier = null;
	Inventory Mineur = null;
	Inventory Bucheron = null;
	Inventory Defenseur = null;
	Inventory Chasseur = null;
	Inventory Acceuil = null;
	
	public JobsClickMenu(){
		
		//fermier
		item.add(getItem(Material.WOOL, (byte)5, "Niveau 1", "t", "d", "g", "a", "n"));
		item.add(getItem(Material.WOOL, (byte)5, "Niveau 2", "t", "d", "g", "a", "n"));
		item.add(getItem(Material.WOOL, (byte)5, "Niveau 3", "t", "d", "g", "a", "n"));
		item.add(getItem(Material.WOOL, (byte)5, "Niveau 4", "t", "d", "g", "a", "n"));
		item.add(getItem(Material.WOOL, (byte)5, "Niveau 5", "t", "d", "g", "a", "n"));
		item.add(getItem(Material.WOOL, (byte)5, "Niveau 6", "t", "d", "g", "a", "n"));
		item.add(getItem(Material.WOOL, (byte)5, "Niveau 7", "t", "d", "g", "a", "n"));
		item.add(getItem(Material.WOOL, (byte)5, "Niveau 8", "t", "d", "g", "a", "n"));
		item.add(getItem(Material.WOOL, (byte)5, "Niveau 9", "t", "d", "g", "a", "n"));
		item.add(getItem(Material.NETHER_STAR, (byte)0, "Niveau 10", "t", "d", "g", "a", "n"));
		
		//fermier
		Inventory fermier = Bukkit.createInventory(null, 2*9, ChatColor.YELLOW+"Jobs "+ChatColor.GREEN+"Fermier");
		
		fermier.setItem(0, getItem(Material.WOOL, (byte)5, "Niveau 1", "t", "d", "g", "a", "n"));
		fermier.setItem(1, getItem(Material.WOOL, (byte)5, "Niveau 2", "t", "d", "g", "a", "n"));
		fermier.setItem(2, getItem(Material.WOOL, (byte)5, "Niveau 3", "t", "d", "g", "a", "n"));
		fermier.setItem(3, getItem(Material.WOOL, (byte)5, "Niveau 4", "t", "d", "g", "a", "n"));
		fermier.setItem(4, getItem(Material.WOOL, (byte)5, "Niveau 5", "t", "d", "g", "a", "n"));
		fermier.setItem(5, getItem(Material.WOOL, (byte)5, "Niveau 6", "t", "d", "g", "a", "n"));
		fermier.setItem(6, getItem(Material.WOOL, (byte)5, "Niveau 7", "t", "d", "g", "a", "n"));
		fermier.setItem(7, getItem(Material.WOOL, (byte)5, "Niveau 8", "t", "d", "g", "a", "n"));
		fermier.setItem(8, getItem(Material.WOOL, (byte)5, "Niveau 9", "t", "d", "g", "a", "n"));
		fermier.setItem(9, getItem(Material.NETHER_STAR, (byte)0, "Niveau 10", "t", "d", "g", "a", "n"));
		fermier.setItem(15, getItem(Material.WOOL, (byte)14, "Quitter ce m�tier", "", "", "", "", ""));
		fermier.setItem(16, getItem(Material.FIREWORK, (byte)0, "Aller dans ce m�tier", "", "", "", "", ""));
		fermier.setItem(17, getItem(Material.ARROW, (byte)0, "retour", "", "", "", "", ""));
		Fermier = fermier;
		
		//mineur
		Inventory mineur = Bukkit.createInventory(null, 2*9, ChatColor.YELLOW+"Jobs "+ChatColor.GRAY+"Mineur");
		
		mineur.setItem(0, getItem(Material.WOOL, (byte)5, "Niveau 1", "t", "d", "g", "a", "n"));
		mineur.setItem(1, getItem(Material.WOOL, (byte)5, "Niveau 2", "t", "d", "g", "a", "n"));
		mineur.setItem(2, getItem(Material.WOOL, (byte)5, "Niveau 3", "t", "d", "g", "a", "n"));
		mineur.setItem(3, getItem(Material.WOOL, (byte)5, "Niveau 4", "t", "d", "g", "a", "n"));
		mineur.setItem(4, getItem(Material.WOOL, (byte)5, "Niveau 5", "t", "d", "g", "a", "n"));
		mineur.setItem(5, getItem(Material.WOOL, (byte)5, "Niveau 6", "t", "d", "g", "a", "n"));
		mineur.setItem(6, getItem(Material.WOOL, (byte)5, "Niveau 7", "t", "d", "g", "a", "n"));
		mineur.setItem(7, getItem(Material.WOOL, (byte)5, "Niveau 8", "t", "d", "g", "a", "n"));
		mineur.setItem(8, getItem(Material.WOOL, (byte)5, "Niveau 9", "t", "d", "g", "a", "n"));
		mineur.setItem(9, getItem(Material.NETHER_STAR, (byte)0, "Niveau 10", "t", "d", "g", "a", "n"));
		mineur.setItem(15, getItem(Material.WOOL, (byte)14, "Quitter ce m�tier", "", "", "", "", ""));
		mineur.setItem(16, getItem(Material.FIREWORK, (byte)0, "Aller dans ce m�tier", "", "", "", "", ""));
		mineur.setItem(17, getItem(Material.ARROW, (byte)0, "retour", "", "", "", "", ""));
		Mineur = mineur;
		
		//bucheron
		Inventory bucheron = Bukkit.createInventory(null, 2*9, ChatColor.YELLOW+"Jobs "+ChatColor.BLUE+"Bucheron");
		
		bucheron.setItem(0, getItem(Material.WOOL, (byte)5, "Niveau 1", "t", "d", "g", "a", "n"));
		bucheron.setItem(1, getItem(Material.WOOL, (byte)5, "Niveau 2", "t", "d", "g", "a", "n"));
		bucheron.setItem(2, getItem(Material.WOOL, (byte)5, "Niveau 3", "t", "d", "g", "a", "n"));
		bucheron.setItem(3, getItem(Material.WOOL, (byte)5, "Niveau 4", "t", "d", "g", "a", "n"));
		bucheron.setItem(4, getItem(Material.WOOL, (byte)5, "Niveau 5", "t", "d", "g", "a", "n"));
		bucheron.setItem(5, getItem(Material.WOOL, (byte)5, "Niveau 6", "t", "d", "g", "a", "n"));
		bucheron.setItem(6, getItem(Material.WOOL, (byte)5, "Niveau 7", "t", "d", "g", "a", "n"));
		bucheron.setItem(7, getItem(Material.WOOL, (byte)5, "Niveau 8", "t", "d", "g", "a", "n"));
		bucheron.setItem(8, getItem(Material.WOOL, (byte)5, "Niveau 9", "t", "d", "g", "a", "n"));
		bucheron.setItem(9, getItem(Material.NETHER_STAR, (byte)0, "Niveau 10", "t", "d", "g", "a", "n"));
		bucheron.setItem(15, getItem(Material.WOOL, (byte)14, "Quitter ce m�tier", "", "", "", "", ""));
		bucheron.setItem(16, getItem(Material.FIREWORK, (byte)0, "Aller dans ce m�tier", "", "", "", "", ""));
		bucheron.setItem(17, getItem(Material.ARROW, (byte)0, "retour", "", "", "", "", ""));
		Bucheron = bucheron;
		
		//defenseur
		Inventory defenseur = Bukkit.createInventory(null, 2*9, ChatColor.YELLOW+"Jobs "+ChatColor.RED+"D�fenseur");
		
		defenseur.setItem(0, getItem(Material.WOOL, (byte)5, "Niveau 1", "t", "d", "g", "a", "n"));
		defenseur.setItem(1, getItem(Material.WOOL, (byte)5, "Niveau 2", "t", "d", "g", "a", "n"));
		defenseur.setItem(2, getItem(Material.WOOL, (byte)5, "Niveau 3", "t", "d", "g", "a", "n"));
		defenseur.setItem(3, getItem(Material.WOOL, (byte)5, "Niveau 4", "t", "d", "g", "a", "n"));
		defenseur.setItem(4, getItem(Material.WOOL, (byte)5, "Niveau 5", "t", "d", "g", "a", "n"));
		defenseur.setItem(5, getItem(Material.WOOL, (byte)5, "Niveau 6", "t", "d", "g", "a", "n"));
		defenseur.setItem(6, getItem(Material.WOOL, (byte)5, "Niveau 7", "t", "d", "g", "a", "n"));
		defenseur.setItem(7, getItem(Material.WOOL, (byte)5, "Niveau 8", "t", "d", "g", "a", "n"));
		defenseur.setItem(8, getItem(Material.WOOL, (byte)5, "Niveau 9", "t", "d", "g", "a", "n"));
		defenseur.setItem(9, getItem(Material.NETHER_STAR, (byte)0, "Niveau 10", "t", "d", "g", "a", "n"));
		defenseur.setItem(15, getItem(Material.WOOL, (byte)14, "Quitter ce m�tier", "", "", "", "", ""));
		defenseur.setItem(16, getItem(Material.FIREWORK, (byte)0, "Aller dans ce m�tier", "", "", "", "", ""));
		defenseur.setItem(17, getItem(Material.ARROW, (byte)0, "retour", "", "", "", "", ""));
		Defenseur = defenseur;
		
		//chasseur
		Inventory chasseur = Bukkit.createInventory(null, 2*9, ChatColor.YELLOW+"Jobs "+ChatColor.GOLD+"Chasseur");
		
		chasseur.setItem(0, getItem(Material.WOOL, (byte)5, "Niveau 1", "t", "d", "g", "a", "n"));
		chasseur.setItem(1, getItem(Material.WOOL, (byte)5, "Niveau 2", "t", "d", "g", "a", "n"));
		chasseur.setItem(2, getItem(Material.WOOL, (byte)5, "Niveau 3", "t", "d", "g", "a", "n"));
		chasseur.setItem(3, getItem(Material.WOOL, (byte)5, "Niveau 4", "t", "d", "g", "a", "n"));
		chasseur.setItem(4, getItem(Material.WOOL, (byte)5, "Niveau 5", "t", "d", "g", "a", "n"));
		chasseur.setItem(5, getItem(Material.WOOL, (byte)5, "Niveau 6", "t", "d", "g", "a", "n"));
		chasseur.setItem(6, getItem(Material.WOOL, (byte)5, "Niveau 7", "t", "d", "g", "a", "n"));
		chasseur.setItem(7, getItem(Material.WOOL, (byte)5, "Niveau 8", "t", "d", "g", "a", "n"));
		chasseur.setItem(8, getItem(Material.WOOL, (byte)5, "Niveau 9", "t", "d", "g", "a", "n"));
		chasseur.setItem(9, getItem(Material.NETHER_STAR, (byte)0, "Niveau 10", "t", "d", "g", "a", "n"));
		chasseur.setItem(15, getItem(Material.WOOL, (byte)14, "Quitter ce m�tier", "", "", "", "", ""));
		chasseur.setItem(16, getItem(Material.FIREWORK, (byte)0, "Aller dans ce m�tier", "", "", "", "", ""));
		chasseur.setItem(17, getItem(Material.ARROW, (byte)0, "retour", "", "", "", "", ""));
		Chasseur = chasseur;
		
		//acceuil
		Inventory acceuil = Bukkit.createInventory(null, 9, MainJobsCmd.acceuilJ);
		
		acceuil.setItem(Jobs.FERMIER.getSlot(), Jobs.FERMIER.getItem());
		acceuil.setItem(Jobs.MINEUR.getSlot(), Jobs.MINEUR.getItem());
		acceuil.setItem(Jobs.BUCHERON.getSlot(), Jobs.BUCHERON.getItem());
		acceuil.setItem(Jobs.CHASSEUR.getSlot(), Jobs.CHASSEUR.getItem());
		acceuil.setItem(Jobs.DEFENSEUR.getSlot(), Jobs.DEFENSEUR.getItem());
		acceuil.setItem(8, getItem2(Material.WOOL, (byte)14, "Quitter"));
		acceuil.setItem(7, getItem2(Material.WOOL, (byte)3, "Moi"));
		Acceuil = acceuil;
	}
	
	private ItemStack getItem2(Material mat, byte data, String name) {
		ItemStack i = new ItemStack(mat, 1, data);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(name);
		i.setItemMeta(iM);
		return i;
	}

	private ItemStack getItem(Material mat, byte data, String name, String desc1, String desc2, String desc3, String desc4, String desc5) {
		ItemStack i = new ItemStack(mat, 1, data);
		ItemMeta iM = i.getItemMeta();
		ArrayList<String> list = new ArrayList<>();
		list.add(desc1);
		list.add(desc2);
		list.add(desc3);
		list.add(desc4);
		list.add(desc5);
		iM.setLore(list);
		iM.setDisplayName(name);
		i.setItemMeta(iM);
		return i;
	}

	@EventHandler
	public void click(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		UUID uuid = p.getUniqueId();
		ItemStack ci = e.getCurrentItem();
		//inventory acceuil
		if(e.getInventory().getTitle().equalsIgnoreCase(MainJobsCmd.acceuilJ)){
			if(e.getCurrentItem().getType() == Material.IRON_HOE){
				p.closeInventory();
				p.openInventory(Fermier);
				e.setCancelled(true);
			}
			if(e.getCurrentItem().getType() == Material.STONE_PICKAXE){
				p.closeInventory();
				p.openInventory(Mineur);
				e.setCancelled(true);
			}
			if(e.getCurrentItem().getType() == Material.WOOD_AXE){
				p.closeInventory();
				p.openInventory(Bucheron);
				e.setCancelled(true);
			}
			if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
				p.closeInventory();
				p.openInventory(Defenseur);
				e.setCancelled(true);
			}
			if(e.getCurrentItem().getType() == Material.GOLD_SWORD){
				p.closeInventory();
				p.openInventory(Chasseur);
				e.setCancelled(true);
			}
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equals("Quitter")){
				p.closeInventory();
				e.setCancelled(true);
			}
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equals("Moi")){
				p.closeInventory();
				p.performCommand("jobs moi");
				e.setCancelled(true);
			}
		}
		//inventory fermier 
		if(e.getInventory().getTitle().equalsIgnoreCase(ChatColor.YELLOW+"Jobs "+ChatColor.GREEN+"Fermier")){
			if(item.contains(ci)){ //laine verte : item descriptif de niveau
				e.setCancelled(true);
			}
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equals("Quitter ce m�tier")){ //laine rouge : quitter ce metier
				if(Jobs.FERMIER.getUtilisator(uuid) != Jobs.FERMIER){
					p.closeInventory();
					p.sendMessage("Vous n'�tes pas fermier.");
					e.setCancelled(true);
				}
				if(Jobs.FERMIER.getUtilisator(uuid) == Jobs.FERMIER){
					Jobs.FERMIER.remove(uuid);
					p.closeInventory();
					p.sendMessage("vous n'�tes plus fermier.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK){ //feu d artifice : devenir ce metier
				if(Jobs.FERMIER.getUtilisator(uuid) == Jobs.FERMIER){
					p.closeInventory();
					p.sendMessage("Vous �tes d�j� fermier.");
					e.setCancelled(true);
				}else if(Jobs.FERMIER.getUtilisator(uuid) != Jobs.FERMIER){
					Jobs.FERMIER.add(uuid);
					p.closeInventory();
					p.sendMessage("Vous �tes d�sormais fermier.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.ARROW){ //fleche : retour
				p.closeInventory();
				p.openInventory(Acceuil);
				e.setCancelled(true);
			}
		}
		//mineur
		if(e.getInventory().getTitle().equals(ChatColor.YELLOW+"Jobs "+ChatColor.GRAY+"Mineur")){
			if(item.contains(ci)){ //laine verte : item descriptif de niveau
				e.setCancelled(true);
			}
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equals("Quitter ce m�tier")){ //laine rouge : quitter ce metier
				if(Jobs.MINEUR.getUtilisator(uuid) != Jobs.MINEUR){
					p.closeInventory();
					p.sendMessage("Vous n'�tes pas mineur.");
					e.setCancelled(true);
				}
				if(Jobs.MINEUR.getUtilisator(uuid) == Jobs.MINEUR){
					Jobs.MINEUR.remove(uuid);
					p.closeInventory();
					p.sendMessage("vous n'�tes plus mineur.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK){ //feu d artifice : devenir ce metier
				if(Jobs.MINEUR.getUtilisator(uuid) == Jobs.MINEUR){
					p.closeInventory();
					p.sendMessage("Vous �tes d�j� mineur.");
					e.setCancelled(true);
				}else if(Jobs.MINEUR.getUtilisator(uuid) != Jobs.MINEUR){
					Jobs.MINEUR.add(uuid);
					p.closeInventory();
					p.sendMessage("Vous �tes d�sormais mineur.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.ARROW){ //fleche : retour
				p.closeInventory();
				p.openInventory(Acceuil);
				e.setCancelled(true);
			}
		}
		//bucheron
		if(e.getInventory().getTitle().equals(ChatColor.YELLOW+"Jobs "+ChatColor.BLUE+"Bucheron")){
			if(item.contains(ci)){ //laine verte : item descriptif de niveau
				e.setCancelled(true);
			}
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equals("Quitter ce m�tier")){ //laine rouge : quitter ce metier
				if(Jobs.BUCHERON.getUtilisator(uuid) != Jobs.BUCHERON){
					p.closeInventory();
					p.sendMessage("Vous n'�tes pas bucheron.");
					e.setCancelled(true);
				}
				if(Jobs.BUCHERON.getUtilisator(uuid) == Jobs.BUCHERON){
					Jobs.BUCHERON.remove(uuid);
					p.closeInventory();
					p.sendMessage("vous n'�tes plus bucheron.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK){ //feu d artifice : devenir ce metier
				if(Jobs.BUCHERON.getUtilisator(uuid) == Jobs.BUCHERON){
					p.closeInventory();
					p.sendMessage("Vous �tes d�j� bucheron.");
					e.setCancelled(true);
				}else if(Jobs.BUCHERON.getUtilisator(uuid) != Jobs.BUCHERON){
					Jobs.BUCHERON.add(uuid);
					p.closeInventory();
					p.sendMessage("Vous �tes d�sormais bucheron.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.ARROW){ //fleche : retour
				p.closeInventory();
				p.openInventory(Acceuil);
				e.setCancelled(true);
			}
		}
		//chasseur
		if(e.getInventory().getTitle().equals(ChatColor.YELLOW+"Jobs "+ChatColor.GOLD+"Chasseur")){
			if(item.contains(ci)){ //laine verte : item descriptif de niveau
				e.setCancelled(true);
			}
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equals("Quitter ce m�tier")){ //laine rouge : quitter ce metier
				if(Jobs.CHASSEUR.getUtilisator(uuid) != Jobs.CHASSEUR){
					p.closeInventory();
					p.sendMessage("Vous n'�tes pas chasseur.");
					e.setCancelled(true);
				}
				if(Jobs.CHASSEUR.getUtilisator(uuid) == Jobs.CHASSEUR){
					Jobs.CHASSEUR.remove(uuid);
					p.closeInventory();
					p.sendMessage("vous n'�tes plus chasseur.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK){ //feu d artifice : devenir ce metier
				if(Jobs.CHASSEUR.getUtilisator(uuid) == Jobs.CHASSEUR){
					p.closeInventory();
					p.sendMessage("Vous �tes d�j� chasseur.");
					e.setCancelled(true);
				}else if(Jobs.CHASSEUR.getUtilisator(uuid) != Jobs.CHASSEUR){
					Jobs.CHASSEUR.add(uuid);
					p.closeInventory();
					p.sendMessage("Vous �tes d�sormais chasseur.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.ARROW){ //fleche : retour
				p.closeInventory();
				p.openInventory(Acceuil);
				e.setCancelled(true);
			}
		}
		//defenseur
		if(e.getInventory().getTitle().equals(ChatColor.YELLOW+"Jobs "+ChatColor.RED+"D�fenseur")){
			if(item.contains(ci)){ //laine verte : item descriptif de niveau
				e.setCancelled(true);
			}
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equals("Quitter ce m�tier")){ //laine rouge : quitter ce metier
				if(Jobs.DEFENSEUR.getUtilisator(uuid) != Jobs.DEFENSEUR){
					p.closeInventory();
					p.sendMessage("Vous n'�tes pas d�fenseur.");
					e.setCancelled(true);
				}
				if(Jobs.DEFENSEUR.getUtilisator(uuid) == Jobs.DEFENSEUR){
					Jobs.DEFENSEUR.remove(uuid);
					p.closeInventory();
					p.sendMessage("vous n'�tes plus d�fenseur.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK){ //feu d artifice : devenir ce metier
				if(Jobs.DEFENSEUR.getUtilisator(uuid) == Jobs.DEFENSEUR){
					p.closeInventory();
					p.sendMessage("Vous �tes d�j� d�fenseur.");
					e.setCancelled(true);
				}else if(Jobs.DEFENSEUR.getUtilisator(uuid) != Jobs.DEFENSEUR){
					Jobs.DEFENSEUR.add(uuid);
					p.closeInventory();
					p.sendMessage("Vous �tes d�sormais d�fenseur.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.ARROW){ //fleche : retour
				p.closeInventory();
				p.openInventory(Acceuil);
				e.setCancelled(true);
			}
		}
	}
}
