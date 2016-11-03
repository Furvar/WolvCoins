package be.Vilevar.WolvCoins.Commands;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import be.Vilevar.WolvCoins.WolvCoins;

public class Coins implements CommandExecutor {


	public Economy economy = null;
	
	 private boolean setupEconomy(){
	        RegisteredServiceProvider<Economy> economyProvider = WolvCoins.getInstance().getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
			if (economyProvider != null) {
	            economy = economyProvider.getProvider();
	        }

	        return (economy != null);
	    }
	
	 private String notCible = ChatColor.RED+"Le joueur cible n'existe pas ou n'est pas connecté.";
	 
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String msg, String[] args) {
		if(setupEconomy()){
			if(cmd.getName().equalsIgnoreCase("coins")){
				// /coins
				if(args.length == 0){
					s.sendMessage(ChatColor.LIGHT_PURPLE+"----------[*Help WolvCoins*]----------");
					s.sendMessage(ChatColor.GOLD+"/coins pay <joueur> <montant>: "+ChatColor.DARK_GREEN+"Pour transférer des C.W. à un joueur.");
					s.sendMessage(ChatColor.GOLD+"/coins check: "+ChatColor.DARK_GREEN+"Pour voir combien de C.W. vous avez.");
					s.sendMessage(ChatColor.GOLD+"/coins top: "+ChatColor.DARK_GREEN+"Pour voir le plus riche.");
					s.sendMessage(ChatColor.GOLD+"/coins premium info: "+ChatColor.DARK_GREEN+"Pour connaître les ajouts des différents niveaux premium.");
					s.sendMessage(ChatColor.LIGHT_PURPLE+"----------[*Help WolvCoins*]----------");
				}
				if(args.length == 1){
					// /check
					if(args[0].equalsIgnoreCase("check")){
						if(s instanceof Player){
						Player p = (Player) s;
							if(p.hasPermission("wolvcoins.check")){
							p.sendMessage(ChatColor.DARK_GREEN+"Vous avez "+ChatColor.YELLOW+economy.getBalance(p)+" C.W.");
							}
						}
					}
					// /top
					if(args[0].equalsIgnoreCase("top")){
						if(s.hasPermission("wolvcoins.top")){
							s.sendMessage(ChatColor.DARK_GREEN+"C'est "+ChatColor.AQUA+WolvCoins.getInstance().meilleurPlayer+ChatColor.DARK_GREEN+" qui "+ChatColor.GRAY+"a le plus de C.W. avec un montant de "+ChatColor.YELLOW+WolvCoins.getInstance().meilleurCW+" C.W.");
						}
					}
					// /resetTop
					if(args[0].equalsIgnoreCase("resettop")){
						if(s.isOp()){
							WolvCoins.getInstance().meilleurCW = 1;
							WolvCoins.getInstance().meilleurPlayer = ChatColor.DARK_BLUE+"§kpersonne";
							s.sendMessage(ChatColor.GREEN+"Vous venez de reset le "+ChatColor.ITALIC+"/coins top.");
						}
					}
					// /help
					if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")){
						if(s.hasPermission("wolvcoins.helpSecretCommands")){
							s.sendMessage(ChatColor.LIGHT_PURPLE+"----------[*Commandes Secrètes WolvCoins*]---------");
							s.sendMessage(ChatColor.GOLD+"/coins check <joueur>: "+ChatColor.DARK_GREEN+"Pour voir la banque d'un joueur.");
							s.sendMessage(ChatColor.GOLD+"/coins add <joueur> <montant>: "+ChatColor.DARK_GREEN+"Pour rajouter des W.C. à un joueur.");
							s.sendMessage(ChatColor.GOLD+"/coins remove <joueur> <montant>: "+ChatColor.DARK_GREEN+"Pour supprimer des W.C. à un joueur.");
							s.sendMessage(ChatColor.GOLD+"/coins set <joueur> <nb de coins>: "+ChatColor.DARK_GREEN+"Pour mettre un nombre précis de W.C. à un joueur.");							
							s.sendMessage(ChatColor.GOLD+"/coins resettop: "+ChatColor.DARK_GREEN+"Pour réinitialiser le /coins top.");
							s.sendMessage(ChatColor.LIGHT_PURPLE+"----------[*Commandes Secrètes WolvCoins*]---------");
						}
					}
				}
				if(args.length == 2){
					// /check player
					if(args[0].equalsIgnoreCase("check")){
						if(s.hasPermission("wolvcoins.getCheckPlayer")){
							Player cible = Bukkit.getPlayer(args[1]);
							if(cible != null){
								s.sendMessage(ChatColor.AQUA+cible.getName()+ChatColor.GRAY+" a "+ChatColor.YELLOW+economy.getBalance(cible));
							}else{
								s.sendMessage(notCible);
							}
						}
					}
				}
				if(args.length == 3){
					// /pay
					if(args[0].equalsIgnoreCase("pay")){
						if(s.hasPermission("wolvcoins.pay")){
							if(s instanceof Player){
								
								Player p = (Player)s;
								Player cible = Bukkit.getPlayer(args[1]);
								double montant = Double.parseDouble(args[2]);
						
								if(cible != null){
									if(cible != p){
										if(economy.getBalance(p) >= montant){
											economy.withdrawPlayer(p, montant);
											economy.depositPlayer(cible, montant);
											p.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"transférer "+ChatColor.YELLOW+montant+" C.W. à "+ChatColor.AQUA+cible.getName());
											cible.sendMessage(ChatColor.AQUA+p.getName()+ChatColor.DARK_GREEN+" Vient de vous "+ChatColor.GRAY+"transférer "+ChatColor.YELLOW+montant+" C.W.");
										
										}else{
											p.sendMessage(ChatColor.RED+"Vous n'avez pas les C.W. que vous voulez transférer.");
										}
									}else{
										p.sendMessage(ChatColor.RED+"Vous ne pouvez pas vous transférer à vous-même des C.W.");
									}
								}else{
									p.sendMessage(notCible);
								}
							}
						}
					}
					// /add
					if(args[0].equalsIgnoreCase("add")){
						if(s.hasPermission("wolvcoins.addPlayerCoins")){
						
							Player cible = Bukkit.getPlayer(args[1]);
							double montant = Double.parseDouble(args[2]);
						
							if(cible != null){
								economy.depositPlayer(cible, montant);
								s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"rajouter "+ChatColor.YELLOW+montant+" C.W. à "+ChatColor.AQUA+cible.getName());
								cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"rajouter "+ChatColor.YELLOW+montant+" C.W.");
							}else{
								s.sendMessage(notCible);
							}
						}
					}
					// /remove
					if(args[0].equalsIgnoreCase("remove")){
						if(s.hasPermission("wolvcoins.removeCoinsPlayer")){
						
							Player cible = Bukkit.getPlayer(args[1]);
							double montant = Double.parseDouble(args[2]);
								
							if(cible != null){
								if(economy.getBalance(cible) >= montant){
									economy.withdrawPlayer(cible, montant);
									cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"supprimer "+ChatColor.YELLOW+montant+" C.W.");
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"supprimer "+ChatColor.YELLOW+montant+" C.W. à "+ChatColor.AQUA+cible.getName());
									}else{
										s.sendMessage(ChatColor.RED+"Le joueur cible n'a pas la somme de C.W. que vous voulez lui retirer.");
									}
							}else{
								s.sendMessage(notCible);
							}
						}		
					}
					// /set
					if(args[0].equalsIgnoreCase("set")){
						//PAS OUBLIER DE METTRE LA PERMISSION
						if(s.isOp()){
							
							Player cible = Bukkit.getPlayer(args[1]);
							double set = Double.parseDouble(args[2]);
							double bank = economy.getBalance(cible);
							double montant = set - bank;
							if(cible != null){
								if(set >= 0){
									if(set < bank){
										economy.withdrawPlayer(cible, bank);
										economy.depositPlayer(cible, set);
										s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.DARK_GREEN+"le compte de "+ChatColor.AQUA+cible.getName()+ChatColor.DARK_GREEN+" à "+ChatColor.YELLOW+set+" C.W.");
										cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.DARK_GREEN+"votre compte à "+ChatColor.YELLOW+set+" C.W.");
									}
									else if(bank < set){
										economy.depositPlayer(cible, montant);
										s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.DARK_GREEN+"le compte de "+ChatColor.AQUA+cible.getName()+ChatColor.DARK_GREEN+" à "+ChatColor.YELLOW+set+" C.W.");
										cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.DARK_GREEN+"votre compte à "+ChatColor.YELLOW+set+" C.W.");
									}
								}else{
									s.sendMessage(ChatColor.RED+"Vous ne pouvez pas lui mettre un nombre inférieur à 0 C.W.");
								}
							}else{
								s.sendMessage(notCible);
							}
						}
					}
				}
			}
		}
		return false;
	}
}
