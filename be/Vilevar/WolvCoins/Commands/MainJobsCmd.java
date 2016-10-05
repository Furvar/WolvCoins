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
						acceuil.setItem(8, getItem(Material.WOOL, (byte)14, "Quitter"));
						acceuil.setItem(7, getItem(Material.WOOL, (byte)3, "Moi"));
					
						p.openInventory(acceuil);
					}
					if(args.length >= 1){
						if(args[0].equalsIgnoreCase("moi")){
							if(Jobs.FERMIER.getUtilisator(uuid) == null){
								p.sendMessage("Vous n'avez pas de m�tier");
							}else{	
								switch(Jobs.FERMIER.getLevel(uuid)){
							
									case 0:
										p.sendMessage("Votre niveau de m�tier est 0.");
									break;
							
									case 1:
										p.sendMessage("Vous �tes niveau 1 de m�tier.");
									break;
								
									case 2:
										p.sendMessage("Vous �tes niveau 2 de m�tier");
									break;
								
									case 3:
										p.sendMessage("Vous �tes niveau 3 de m�tier");
									break;
								
									case 4:
										p.sendMessage("Vous �tes niveau 4 de m�tier");
									break;
								
									case 5:
										p.sendMessage("Vous �tes niveau 5 de m�tier");
									break;
								
									case 6:
										p.sendMessage("Vous �tes niveau 6 de m�tier");
									break;
								
									case 7:
										p.sendMessage("Vous �tes niveau 7 de m�tier");
									break;
								
									case 8:
										p.sendMessage("Vous �tes niveau 8 de m�tier");
									break;
								
									case 9:
										p.sendMessage("Vous �tes niveau 9 de m�tier");
									break;
								
									case 10:
										p.sendMessage("Vous �tes niveau 10 de m�tier");
									break;
								}
									if(Jobs.FERMIER.getUtilisator(uuid) == Jobs.FERMIER){
										p.sendMessage("Vous �tes fermier");
									}
									if(Jobs.MINEUR.getUtilisator(uuid) == Jobs.MINEUR){
										p.sendMessage("Vous �tes mineur");
									}
									if(Jobs.BUCHERON.getUtilisator(uuid) == Jobs.BUCHERON){
										p.sendMessage("Vous �tes bucheron");
									}
									if(Jobs.CHASSEUR.getUtilisator(uuid) == Jobs.CHASSEUR){
										p.sendMessage("Vous �tes chasseur");
									}
									if(Jobs.DEFENSEUR.getUtilisator(uuid) == Jobs.DEFENSEUR){
										p.sendMessage("Vous �tes d�fenseur");
								}
							}
						}
						if(args[0].equalsIgnoreCase("addLvl")){
							if(Jobs.FERMIER.getUtilisator(uuid) != null){
								Jobs.FERMIER.addLevel(uuid, 1);
								p.sendMessage("vous montez de 1 niveau de m�tier.");
							}
						}else{
							p.sendMessage("Commande en cr�ation.");
						}
					}
				}else{
					p.sendMessage("vous n'�tes pas op !");
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
