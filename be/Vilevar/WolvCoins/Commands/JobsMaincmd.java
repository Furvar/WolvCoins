package be.Vilevar.WolvCoins.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.Vilevar.WolvCoins.Jobs.Jobs;

public class JobsMaincmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(cmd.getName().equalsIgnoreCase("jobs")){
			if(sender instanceof Player){
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("fermier")){
						Jobs.FEMIER.add(((Player) sender).getUniqueId());
						sender.sendMessage("Vous venez de passez fermier !");
					}
					if(args[0].equalsIgnoreCase("mineur")){
						Jobs.MINEUR.add(((Player) sender).getUniqueId());
						sender.sendMessage("Vous venez de passez mineur !");
					}
					if(args[0].equalsIgnoreCase("bucheron")){
						Jobs.BUCHERON.add(((Player) sender).getUniqueId());
						sender.sendMessage("Vous venez de passez bucheron !");
					}
					if(args[0].equalsIgnoreCase("chasseur")){
						Jobs.CHASSEUR.add(((Player) sender).getUniqueId());
						sender.sendMessage("Vous venez de passez chasseur !");
					}
					if(args[0].equalsIgnoreCase("défenseur")){
						Jobs.DEFENSEUR.add(((Player) sender).getUniqueId());
						sender.sendMessage("Vous venez de passez défenseur !");
					}
				}
			}
		}
		return false;
	}
}
