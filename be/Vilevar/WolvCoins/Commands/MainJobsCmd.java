package be.Vilevar.WolvCoins.Commands;

import java.util.UUID;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import be.Vilevar.WolvCoins.Jobs.Jobs;

public class MainJobsCmd implements CommandExecutor {

	public static String acceuilJ = ChatColor.YELLOW+"Jobs acceuil";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(cmd.getName().equalsIgnoreCase("jobs")){
			if(sender instanceof Player){
				Player p = (Player)sender;
				UUID uuid = p.getUniqueId();
				if(p.isOp()){
					if(args.length == 0){
						Inventory acceuil = Bukkit.createInventory(null, 9, acceuilJ);
						
						acceuil.setItem(Jobs.FERMIER.getSlot(), Jobs.FERMIER.getItem());
						acceuil.setItem(Jobs.MINEUR.getSlot(), Jobs.MINEUR.getItem());
						acceuil.setItem(Jobs.BUCHERON.getSlot(), Jobs.BUCHERON.getItem());
						acceuil.setItem(Jobs.CHASSEUR.getSlot(), Jobs.CHASSEUR.getItem());
						acceuil.setItem(Jobs.DEFENSEUR.getSlot(), Jobs.DEFENSEUR.getItem());
						acceuil.setItem(8, getItem(Material.WOOL, (byte)14, ChatColor.DARK_GRAY+"Quitter"));
						acceuil.setItem(7, getItem(Material.WOOL, (byte)3, ChatColor.AQUA+"Moi"));
					
						p.openInventory(acceuil);
					}
					if(args.length >= 1){
						if(args[0].equalsIgnoreCase("moi")){
							if(Jobs.FERMIER.getUtilisator(uuid) == null){
								p.sendMessage("Vous n'avez pas de métier");
							}else{	
								if(Jobs.FERMIER.getUtilisator(uuid) == Jobs.FERMIER){
									p.sendMessage("Vous êtes fermier");
								}
								if(Jobs.MINEUR.getUtilisator(uuid) == Jobs.MINEUR){
									p.sendMessage("Vous êtes mineur");
								}
								if(Jobs.BUCHERON.getUtilisator(uuid) == Jobs.BUCHERON){
									p.sendMessage("Vous êtes bucheron");
								}
								if(Jobs.CHASSEUR.getUtilisator(uuid) == Jobs.CHASSEUR){
									p.sendMessage("Vous êtes chasseur");
								}
								if(Jobs.DEFENSEUR.getUtilisator(uuid) == Jobs.DEFENSEUR){
									p.sendMessage("Vous êtes défenseur");
								}
								p.sendMessage("Votre niveau de métier est de "+Jobs.FERMIER.getLevel(uuid)+" et mini-niveau de "+Jobs.FERMIER.getminiLvl(uuid)+".");
							}
						}
						if(args[0].equalsIgnoreCase("addLvl")){
							if(Jobs.FERMIER.getUtilisator(uuid) != null){
								Jobs.FERMIER.addLevel(uuid, 1);
								p.sendMessage("vous montez de 1 niveau de métier.");
							}
						}else{
							p.sendMessage("Commande en création.");
						}
					}
				}else{
					p.sendMessage("vous n'êtes pas op !");
				}
			}
		}
		return false;
	}

	public ItemStack getItem(Material mat, byte data, String name) {
		ItemStack i = new ItemStack(mat, 1, data);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(name);
		i.setItemMeta(iM);
		return i;
	}

}
