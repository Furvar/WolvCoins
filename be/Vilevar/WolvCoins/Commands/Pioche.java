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

public class Pioche implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(cmd.getName().equalsIgnoreCase("pioche")){
			if(sender instanceof Player){
				Player p = (Player)sender;
				if(Jobs.MINEUR.getUtilisator(p.getUniqueId()) == Jobs.MINEUR){
					p.getInventory().addItem(getItem(Material.DIAMOND_AXE, 1, "Pioche du mineur", "Pioche du mineur"));
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
