package be.Vilevar.WolvCoins.Commands;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import be.Vilevar.WolvCoins.WolvCoins;

public class Coins implements CommandExecutor {

	private WolvCoins wolvcoins;
	public static Economy economy = null;
	
	public Coins(WolvCoins wolvCoins) {
		this.wolvcoins = wolvCoins;
	}
	
	 private boolean setupEconomy(){
	        RegisteredServiceProvider<Economy> economyProvider = wolvcoins.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
	        if (economyProvider != null) {
	            economy = economyProvider.getProvider();
	        }

	        return (economy != null);
	    }

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg,String[] args) {
		if(setupEconomy()){
			if(sender instanceof Player){
				
			Player p = (Player)sender;
			Player cible = Bukkit.getPlayer(args[1]);
			int montant = Integer.valueOf(args[2]);
			double balance = economy.getBalance(p);
			double balanceC = economy.getBalance(cible);
			
			// /coins
			if(cmd.getName().equalsIgnoreCase("coins"))
				if(args.length == 0){
				p.sendMessage("---------------[*Help WolvCoins*]---------------");
				p.sendMessage("/coins pay <joueur> <montant>: Pour payer un joueur.");
				p.sendMessage("/coins chek: pour voir votre balance.");
				p.sendMessage("/coins top: pour voir le classement des plus riche.");
				p.sendMessage("---------------[*Help WolvCoins*]---------------");
				
			}else if(args.length == 1){
				// /check
				if(args[0].equalsIgnoreCase("check")){
					if(p.hasPermission("WolvCoins.chek.use")){
					p.sendMessage("Vous avez "+balance+" C.W.");
						}
						}else 
						// /top	
						if(args[0].equalsIgnoreCase("top")){
							if(p.hasPermission("WolvCoins.top.use")){
							p.sendMessage("Commande en création.");		
					}
				}
			}else if(args.length == 2){
				// /check player
				if(args[0].equalsIgnoreCase("check")){
					if(p.hasPermission("WolvCoins.checkPlayer.use")){
						if(cible != null){
							p.sendMessage(cible.getName()+" a "+balanceC+" C.W.");
						}else{
							p.sendMessage("Le joueur n'existe pas ou n'est pas connecté.");
						}
					}
				}
			}else if(args.length == 3){
				// /add
				if(args[0].equalsIgnoreCase("add")){
					if(p.hasPermission("WolvCoins.add.use")){
						if(cible != null){
						economy.depositPlayer(cible, montant);
						p.sendMessage("Vous venez de d'ajouter "+montant+" C.W. à la banque de "+cible.getName());
						cible.sendMessage(p.getName()+" vient d'ajouter "+montant+" C.W. à votre banque.");
						}else{
							p.sendMessage("Le joueur n'existe pas ou n'est pas connecté.");
						}
					}
				}else
				// /remove
				if(args[0].equalsIgnoreCase("remove")){
					if(p.hasPermission("wolvCoins.remove.use")){
						if(cible != null){
							economy.withdrawPlayer(cible, montant);
							p.sendMessage("Vous venez de supprimer "+montant+" C.W. à la banque de "+cible.getName());
							cible.sendMessage(p.getName()+" vient de supprimer "+montant+" C.W. à votre banque.");
						}else{
							p.sendMessage("Le joueur n'existe pas ou n'est pas connecté.");	
						}
					}
				}else
				// /pay
				if(args[0].equalsIgnoreCase("pay")){
					if(p.hasPermission("WolvCoins.pay.use")){
						if(cible != null){
							if(economy.getBalance(p) >= montant){
								economy.withdrawPlayer(p, montant);
								p.sendMessage("Vous venez de verser "+montant+" C.W. à "+cible.getName());
								economy.depositPlayer(cible, montant);
								cible.sendMessage(p.getName()+" vient de vous verser "+montant+" C.W.");
							}else{
								p.sendMessage("Vous n'avez pas assez de C.W. que pour versez une telle somme.");
							}
						}else{
							p.sendMessage("Le joueur n'existe pas ou n'est pas connecté.");
						}
					}
				}
			}
		}
		}
		return false;
	}
}
