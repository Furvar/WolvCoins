package be.Vilevar.WolvCoins.Commands;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import be.Vilevar.WolvCoins.Jobs.Jobs;

public class Epee implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(cmd.getName().equalsIgnoreCase("epee")){
			if(sender instanceof Player){
				Player p = (Player)sender;
				if(Jobs.CHASSEUR.getUtilisator(p.getUniqueId()) == Jobs.CHASSEUR){
					p.getInventory().addItem(getItem(Material.DIAMOND_SWORD, 1, "Epée du chasseur", "Epée du chasseur"));
					p.updateInventory();
				}
				if(Jobs.DEFENSEUR.getUtilisator(p.getUniqueId()) == Jobs.DEFENSEUR){
					p.getInventory().addItem(getItem(Material.DIAMOND_SWORD, 1, "Epée du défenseur", "Epée du défenseur"));
					p.updateInventory();
				}
			}
		}
		return false;
	}

	private ItemStack getItem(Material mat, int nb, String name, String desc) {
		ItemStack i = new ItemStack(mat, nb);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(name);
		ArrayList<String> list = new ArrayList<>();
		list.add(desc);
		iM.setLore(list);
		i.setItemMeta(iM);
		return i;
	}

}
