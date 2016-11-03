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
	
	Inventory Fermier;
	Inventory Mineur;
	Inventory Bucheron;
	Inventory Defenseur;
	Inventory Chasseur;
	Inventory Acceuil;
	
	public JobsClickMenu(){
		
/* §6 => ChatColor.GOLD
 * §a => ChatColor.GREEN
 * §b => ChatColor.AQUA
 * §d => ChatColor.LIGHT_PURPLE
 */
		
		item.add(getItem1(Material.WOOL, (byte)5, "Niveau 1", "§64% de chance de gagner 1 C.W.", "§a10% de chance de monter de 15 mini-niveaux"));
		item.add(getItem1(Material.WOOL, (byte)5, "Niveau 2", "§64% de chance de gagner 3 C.W.", "§a10% de chance de gagner 12,5 mini-niveaux"));
		item.add(getItem1(Material.WOOL, (byte)5, "Niveau 3", "§610% de chance de gagner 5 C.W.", "§a15% de chance de monter de 10 mini-niveaux"));
		item.add(getItem1(Material.WOOL, (byte)5, "Niveau 4", "§610% de chance de gagner 7 C.W.", "§a15% de chance de monter de 7,5 mini-niveaux"));
		item.add(getItem1(Material.WOOL, (byte)5, "Niveau 5", "§615% de chance de gagner 10 C.W.", "§a10% de chance de monter de 10 mini-niveaux"));
		item.add(getItem1(Material.WOOL, (byte)5, "Niveau 6", "§620% de chance de gagner 10 C.W.", "§a15% de chance de monter de 7,5 mini-niveaux"));
		item.add(getItem1(Material.WOOL, (byte)5, "Niveau 7", "§625% de chance de gagner 10 C.W.", "§a15% de chance de monter de 6 mini-niveaux"));
		item.add(getItem1(Material.WOOL, (byte)5, "Niveau 8", "§625% de chance de gagner 15 C.W.", "§a20% de chance de monter de 5 mini-niveaux"));
		item.add(getItem3(Material.WOOL, (byte)5, "Niveau 9", "§b50% de chance d'activer une capacité", "§675% de chance de gagner 10 C.W.", "§a50% de chance de monter de 3 mini-niveaux", "§d10% de chance de rajouter un drop mystère prédéfini"));
		item.add(getItem3(Material.NETHER_STAR, (byte)0, "Niveau 10", "§b75% de chance d'activer une capacité", "§695% de chance de gagner 10 C.W.", "§650% de chance de gagner 20 C.W.","§d20% de chance de rajouter des drops mystères prédéfinis"));
		
	//inventaires
		//fermier
		Inventory fermier = Bukkit.createInventory(null, 2*9, ChatColor.YELLOW+"Jobs "+ChatColor.GREEN+"Fermier");
		
		fermier.setItem(0, getItem1(Material.WOOL, (byte)5, "Niveau 1", "§64% de chance de gagner 1 C.W.", "§a10% de chance de monter de 15 mini-niveaux"));
		fermier.setItem(1, getItem1(Material.WOOL, (byte)5, "Niveau 2", "§64% de chance de gagner 3 C.W.", "§a10% de chance de gagner 12,5 mini-niveaux"));
		fermier.setItem(2, getItem1(Material.WOOL, (byte)5, "Niveau 3", "§610% de chance de gagner 5 C.W.", "§a15% de chance de monter de 10 mini-niveaux"));
		fermier.setItem(3, getItem1(Material.WOOL, (byte)5, "Niveau 4", "§610% de chance de gagner 7 C.W.", "§a15% de chance de monter de 7,5 mini-niveaux"));
		fermier.setItem(4, getItem1(Material.WOOL, (byte)5, "Niveau 5", "§615% de chance de gagner 10 C.W.", "§a10% de chance de monter de 10 mini-niveaux"));
		fermier.setItem(5, getItem1(Material.WOOL, (byte)5, "Niveau 6", "§620% de chance de gagner 10 C.W.", "§a15% de chance de monter de 7,5 mini-niveaux"));
		fermier.setItem(6, getItem1(Material.WOOL, (byte)5, "Niveau 7", "§625% de chance de gagner 10 C.W.", "§a15% de chance de monter de 6 mini-niveaux"));
		fermier.setItem(7, getItem1(Material.WOOL, (byte)5, "Niveau 8", "§25% de chance de gagner 15 C.W.", "§a20% de chance de monter de 5 mini-niveaux"));
		fermier.setItem(8, getItem3(Material.WOOL, (byte)5, "Niveau 9", "§b50% de chance d'activer une capacité", "§675% de chance de gagner 10 C.W.", "§a50% de chance de monter de 3 mini-niveaux", "§d10% de chance de rajouter un drop mystère prédéfini"));
		fermier.setItem(9, getItem3(Material.NETHER_STAR, (byte)0, "Niveau 10", "§b75% de chance d'activer une capacité", "§695% de chance de gagner 10 C.W.", "§650% de chance de gagner 20 C.W.","§d20% de chance de rajouter des drops mystères prédéfinis"));
		fermier.setItem(15, getItem0(Material.WOOL, (byte)14, ChatColor.RED+"Quitter ce métier"));
		fermier.setItem(16, getItem0(Material.FIREWORK, (byte)0, ChatColor.BLUE+"Aller dans ce métier"));
		fermier.setItem(17, getItem0(Material.ARROW, (byte)0, ChatColor.DARK_AQUA+"retour"));
		this.Fermier = fermier;
		
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
		mineur.setItem(15, getItem(Material.WOOL, (byte)14, "Quitter ce métier", "", "", "", "", ""));
		mineur.setItem(16, getItem(Material.FIREWORK, (byte)0, "Aller dans ce métier", "", "", "", "", ""));
		mineur.setItem(17, getItem(Material.ARROW, (byte)0, "retour", "", "", "", "", ""));
		this.Mineur = mineur;
		
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
		bucheron.setItem(15, getItem(Material.WOOL, (byte)14, "Quitter ce métier", "", "", "", "", ""));
		bucheron.setItem(16, getItem(Material.FIREWORK, (byte)0, "Aller dans ce métier", "", "", "", "", ""));
		bucheron.setItem(17, getItem(Material.ARROW, (byte)0, "retour", "", "", "", "", ""));
		this.Bucheron = bucheron;
		
		//defenseur
		Inventory defenseur = Bukkit.createInventory(null, 2*9, ChatColor.YELLOW+"Jobs "+ChatColor.RED+"Défenseur");
		
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
		defenseur.setItem(15, getItem(Material.WOOL, (byte)14, "Quitter ce métier", "", "", "", "", ""));
		defenseur.setItem(16, getItem(Material.FIREWORK, (byte)0, "Aller dans ce métier", "", "", "", "", ""));
		defenseur.setItem(17, getItem(Material.ARROW, (byte)0, "retour", "", "", "", "", ""));
		this.Defenseur = defenseur;
		
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
		chasseur.setItem(15, getItem(Material.WOOL, (byte)14, "Quitter ce métier", "", "", "", "", ""));
		chasseur.setItem(16, getItem(Material.FIREWORK, (byte)0, "Aller dans ce métier", "", "", "", "", ""));
		chasseur.setItem(17, getItem(Material.ARROW, (byte)0, "retour", "", "", "", "", ""));
		this.Chasseur = chasseur;
		
		//acceuil
		Inventory acceuil = Bukkit.createInventory(null, 9, MainJobsCmd.acceuilJ);
		
		acceuil.setItem(Jobs.FERMIER.getSlot(), Jobs.FERMIER.getItem());
		acceuil.setItem(Jobs.MINEUR.getSlot(), Jobs.MINEUR.getItem());
		acceuil.setItem(Jobs.BUCHERON.getSlot(), Jobs.BUCHERON.getItem());
		acceuil.setItem(Jobs.CHASSEUR.getSlot(), Jobs.CHASSEUR.getItem());
		acceuil.setItem(Jobs.DEFENSEUR.getSlot(), Jobs.DEFENSEUR.getItem());
		acceuil.setItem(8, getItem0(Material.WOOL, (byte)14, ChatColor.DARK_GRAY+"Quitter"));
		acceuil.setItem(7, getItem0(Material.WOOL, (byte)3, ChatColor.AQUA+"Moi"));
		this.Acceuil = acceuil;
	}

	//METHODES
	private ItemStack getItem3(Material mat, byte data, String name, String desc1, String desc2, String desc3, String desc4) {
		ItemStack i = new ItemStack(mat, 1, data);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(ChatColor.GREEN+name);
		ArrayList<String> desc = new ArrayList<>();
		desc.add(desc1);
		desc.add(desc2);
		desc.add(desc3);
		desc.add(desc4);
		iM.setLore(desc);
		i.setItemMeta(iM);
		return i;
	}

	private ItemStack getItem1(Material mat, byte data, String name, String desc1, String desc2) {
		ItemStack i = new ItemStack(mat, 1, data);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(ChatColor.GREEN+name);
		ArrayList<String> desc = new ArrayList<>();
		desc.add(desc1);
		desc.add(desc2);
		iM.setLore(desc);
		i.setItemMeta(iM);
		return i;
	}

	private ItemStack getItem0(Material mat, byte data, String name) {
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
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GRAY+"Quitter")){
				p.closeInventory();
				e.setCancelled(true);
			}
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+"Moi")){
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
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED+"Quitter ce métier")){ //laine rouge : quitter ce metier
				if(Jobs.FERMIER.getUtilisator(uuid) != Jobs.FERMIER){
					p.closeInventory();
					p.sendMessage("Vous n'êtes pas fermier.");
					e.setCancelled(true);
				}
				if(Jobs.FERMIER.getUtilisator(uuid) == Jobs.FERMIER){
					Jobs.FERMIER.remove(uuid);
					p.closeInventory();
					p.sendMessage("vous n'êtes plus fermier.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK){ //feu d artifice : devenir ce metier
				if(Jobs.FERMIER.getUtilisator(uuid) == Jobs.FERMIER){
					p.closeInventory();
					p.sendMessage("Vous êtes déjà fermier.");
					e.setCancelled(true);
				}else if(Jobs.FERMIER.getUtilisator(uuid) != Jobs.FERMIER){
					Jobs.FERMIER.add(uuid);
					p.closeInventory();
					p.sendMessage("Vous êtes désormais fermier.");
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
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Quitter ce métier")){ //laine rouge : quitter ce metier
				if(Jobs.MINEUR.getUtilisator(uuid) != Jobs.MINEUR){
					p.closeInventory();
					p.sendMessage("Vous n'êtes pas mineur.");
					e.setCancelled(true);
				}
				if(Jobs.MINEUR.getUtilisator(uuid) == Jobs.MINEUR){
					Jobs.MINEUR.remove(uuid);
					p.closeInventory();
					p.sendMessage("vous n'êtes plus mineur.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK){ //feu d artifice : devenir ce metier
				if(Jobs.MINEUR.getUtilisator(uuid) == Jobs.MINEUR){
					p.closeInventory();
					p.sendMessage("Vous êtes déjà mineur.");
					e.setCancelled(true);
				}else if(Jobs.MINEUR.getUtilisator(uuid) != Jobs.MINEUR){
					Jobs.MINEUR.add(uuid);
					p.closeInventory();
					p.sendMessage("Vous êtes désormais mineur.");
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
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equals("Quitter ce métier")){ //laine rouge : quitter ce metier
				if(Jobs.BUCHERON.getUtilisator(uuid) != Jobs.BUCHERON){
					p.closeInventory();
					p.sendMessage("Vous n'êtes pas bucheron.");
					e.setCancelled(true);
				}
				if(Jobs.BUCHERON.getUtilisator(uuid) == Jobs.BUCHERON){
					Jobs.BUCHERON.remove(uuid);
					p.closeInventory();
					p.sendMessage("vous n'êtes plus bucheron.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK){ //feu d artifice : devenir ce metier
				if(Jobs.BUCHERON.getUtilisator(uuid) == Jobs.BUCHERON){
					p.closeInventory();
					p.sendMessage("Vous êtes déjà bucheron.");
					e.setCancelled(true);
				}else if(Jobs.BUCHERON.getUtilisator(uuid) != Jobs.BUCHERON){
					Jobs.BUCHERON.add(uuid);
					p.closeInventory();
					p.sendMessage("Vous êtes désormais bucheron.");
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
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equals("Quitter ce métier")){ //laine rouge : quitter ce metier
				if(Jobs.CHASSEUR.getUtilisator(uuid) != Jobs.CHASSEUR){
					p.closeInventory();
					p.sendMessage("Vous n'êtes pas chasseur.");
					e.setCancelled(true);
				}
				if(Jobs.CHASSEUR.getUtilisator(uuid) == Jobs.CHASSEUR){
					Jobs.CHASSEUR.remove(uuid);
					p.closeInventory();
					p.sendMessage("vous n'êtes plus chasseur.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK){ //feu d artifice : devenir ce metier
				if(Jobs.CHASSEUR.getUtilisator(uuid) == Jobs.CHASSEUR){
					p.closeInventory();
					p.sendMessage("Vous êtes déjà chasseur.");
					e.setCancelled(true);
				}else if(Jobs.CHASSEUR.getUtilisator(uuid) != Jobs.CHASSEUR){
					Jobs.CHASSEUR.add(uuid);
					p.closeInventory();
					p.sendMessage("Vous êtes désormais chasseur.");
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
		if(e.getInventory().getTitle().equals(ChatColor.YELLOW+"Jobs "+ChatColor.RED+"Défenseur")){
			if(item.contains(ci)){ //laine verte : item descriptif de niveau
				e.setCancelled(true);
			}
			if(e.getCurrentItem().getType() == Material.WOOL && e.getCurrentItem().getItemMeta().getDisplayName().equals("Quitter ce métier")){ //laine rouge : quitter ce metier
				if(Jobs.DEFENSEUR.getUtilisator(uuid) != Jobs.DEFENSEUR){
					p.closeInventory();
					p.sendMessage("Vous n'êtes pas défenseur.");
					e.setCancelled(true);
				}
				if(Jobs.DEFENSEUR.getUtilisator(uuid) == Jobs.DEFENSEUR){
					Jobs.DEFENSEUR.remove(uuid);
					p.closeInventory();
					p.sendMessage("vous n'êtes plus défenseur.");
					e.setCancelled(true);
				}
			}
			if(e.getCurrentItem().getType() == Material.FIREWORK){ //feu d artifice : devenir ce metier
				if(Jobs.DEFENSEUR.getUtilisator(uuid) == Jobs.DEFENSEUR){
					p.closeInventory();
					p.sendMessage("Vous êtes déjà défenseur.");
					e.setCancelled(true);
				}else if(Jobs.DEFENSEUR.getUtilisator(uuid) != Jobs.DEFENSEUR){
					Jobs.DEFENSEUR.add(uuid);
					p.closeInventory();
					p.sendMessage("Vous êtes désormais défenseur.");
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
