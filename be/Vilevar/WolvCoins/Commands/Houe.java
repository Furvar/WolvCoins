package be.Vilevar.WolvCoins.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.Vilevar.WolvCoins.WolvCoins;
import be.Vilevar.WolvCoins.Jobs.Jobs;

public class Houe implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(cmd.getName().equalsIgnoreCase("houe")){
			if(sender instanceof Player){
				Player p = (Player)sender;
				Jobs pkit = WolvCoins.getInstance().jobs.get(p.getUniqueId());
				
			}
		}
		return false;
	}

}
