package be.Vilevar.WolvCoins.Utils;

import java.util.ArrayList;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;

import be.Vilevar.WolvCoins.WolvCoins;

public class Shop implements Listener {

	//economy
	public Economy economy = null;
	public boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = WolvCoins.getPlugin(WolvCoins.class).getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			economy = economyProvider.getProvider();
		}
		return (economy != null);
	}
	
	public ArrayList<String> vente = new ArrayList<String>();
	
	public Shop(){
		vente.add(ChatColor.GOLD+"Event Hallow.");
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEventShopUtilise(PlayerInteractEvent e){
		
		Player p = e.getPlayer();
		
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
			BlockState block = e.getClickedBlock().getState();
			if(isShop(e.getClickedBlock()) && block!=null){
				Sign sign = (Sign) block;
				if(p.hasPermission("wolvcoins.shop.use") && setupEconomy()){
						
					double HallowPrice = Double.parseDouble(sign.getLine(3));
					//event halloween
					if(sign.getLine(2).equalsIgnoreCase(ChatColor.GOLD+"Event Hallow.")){
						if(p.getInventory().getItemInHand().isSimilar(getItem(Material.PUMPKIN, ChatColor.GOLD+"Event Halloween"))){
							if(!p.isSneaking()){
								p.getInventory().getItemInHand().setAmount(p.getInventory().getItemInHand().getAmount() - 1);
								economy.depositPlayer(p, HallowPrice);
								p.sendMessage(ChatColor.GREEN+"Achat réussi, vous avez désormais "+economy.getBalance(p)+" C.W.");
							}else{
								economy.depositPlayer(p, HallowPrice * p.getInventory().getItemInHand().getAmount());
								p.getInventory().setItemInHand(null);
								p.sendMessage(ChatColor.GREEN+"Achat réussi, vous avez désormais "+economy.getBalance(p)+" C.W.");
							}
						}else{
							p.sendMessage(ChatColor.DARK_RED+"Error:"+ChatColor.RED+" Vous n'avez pas de citrouilles "+ChatColor.GOLD+"Event Halloween"+ChatColor.RED+" dans votre main.");
						}
					}
				}else{
					p.sendMessage(ChatColor.DARK_RED+"Error: "+ChatColor.RED+"Vous n'avez pas la permission de vendre ˆ ce shop.");
				}
			}
		}
	}

	@EventHandler
	public void onSetShop(BlockPlaceEvent e){
		
		Player p = e.getPlayer();
		if(isShop(e.getBlock())){
			if(p.hasPermission("wolvcoins.shop.set")){
				p.sendMessage(ChatColor.GREEN+"Shop poser avec succs.");
			}else{
				p.sendMessage(ChatColor.DARK_RED+"Error:"+ChatColor.RED+" Vous ne pouvez ce poser de shop.");
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onRemoveShop(BlockBreakEvent e){
		
		Player p = e.getPlayer();
		if(isShop(e.getBlock())){
			if(p.hasPermission("wolvcoins.shop.remove")){
				p.sendMessage(ChatColor.GREEN+"Shop casser avec succs.");
			}else{
				p.sendMessage(ChatColor.DARK_RED+"Error:"+ChatColor.RED+" Vous ne pouvez ce casser de shop.");
				e.setCancelled(true);
			}
		}
	}
	
	private ItemStack getItem(Material mat, String name) {
		ItemStack i = new ItemStack(mat);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName(name);
		i.setItemMeta(iM);
		return i;
	}
	
	private boolean isShop(Block b){
		
		if(b == null)return false;
		
		BlockState block = b.getState();
		if(block instanceof Sign){
			Sign sign = (Sign)block;
			if(sign.getLine(0).equalsIgnoreCase("§d§lShop") && (sign.getLine(1).equalsIgnoreCase(ChatColor.RED+"Sell") || sign.getLine(1).equalsIgnoreCase(ChatColor.AQUA+"Buy")) && vente.contains(sign.getLine(2))){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}
