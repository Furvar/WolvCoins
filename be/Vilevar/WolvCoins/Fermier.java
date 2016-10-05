package be.Vilevar.WolvCoins.Jobs;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Fermier implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		UUID uuid = p.getUniqueId();
		Material b = e.getBlock().getType();
		if(Jobs.FERMIER.getUtilisator(uuid) == Jobs.FERMIER){
			if(b == Material.WHEAT || b == Material.POTATO || b == Material.CARROT || b == Material.PUMPKIN || b == Material.MELON_BLOCK){
				
			}
		}
	}
}
