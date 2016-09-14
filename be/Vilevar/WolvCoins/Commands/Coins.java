package be.Vilevar.WolvCoins.Commands;

import java.util.UUID;

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

	private WolvCoins WolvCoins;
	public static Economy economy = null;
	
	public Coins(WolvCoins wolvCoins) {
		this.WolvCoins = wolvCoins;
	}
	
	 private boolean setupEconomy(){
	        RegisteredServiceProvider<Economy> economyProvider = WolvCoins.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
	        if (economyProvider != null) {
	            economy = economyProvider.getProvider();
	        }

	        return (economy != null);
	    }
	
	 private String notCible = ChatColor.RED+"Le joueur cible n'existe pas ou n'est pas connecté.";
	 
	@SuppressWarnings({ "deprecation", "unused" })
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
							s.sendMessage(ChatColor.DARK_GREEN+"C'est "+ChatColor.AQUA+WolvCoins.meilleurPlayer+ChatColor.DARK_GREEN+" qui "+ChatColor.GRAY+"a le plus de C.W. avec un montant de "+ChatColor.YELLOW+WolvCoins.meilleurCW+" C.W.");
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
							s.sendMessage(ChatColor.GOLD+"/coins addpremium <joueur>: "+ChatColor.DARK_GREEN+"Pour mettre un joueur premium, s'il l'est déjà, le monté de niveau.");
							s.sendMessage(ChatColor.GOLD+"/coins removepremium <joueur>: "+ChatColor.DARK_GREEN+"Pour mettre un joueur normal, s'il a plusieurs niveaux premium, le descendre de 1.");
							s.sendMessage(ChatColor.GOLD+"/coins setpremium <joueur> <niveau>: "+ChatColor.DARK_GREEN+"Pour mettre un joueur premium au niveau que vous souhaitez.");
							s.sendMessage(ChatColor.GOLD+"/coins unsetpremium <joueur>: "+ChatColor.DARK_GREEN+"Pour mettre un joueur normal quelque soit son niveau premium.");
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
							s.sendMessage(ChatColor.AQUA+cible.getName()+ChatColor.GRAY+" a "+ChatColor.YELLOW+economy.getBalance(cible)+" C.W.");
							}else{
								s.sendMessage(ChatColor.RED+"Le joueur cible n'existe pas ou n'est pas connecté.");
							}
						}
					}
					// /addPremium
					if(args[0].equalsIgnoreCase("addpremium")){
						if(s.hasPermission("wolvcoins.addPremium")){
							Player cible = Bukkit.getPlayer(args[1]);
							UUID uuid = cible.getUniqueId();
							if(cible != null){
								if(WolvCoins.premium1.containsKey(uuid)){
									WolvCoins.premium1.remove(uuid);
									WolvCoins.premium2.put(uuid, 2);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(2).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(2).");
								}
								if(WolvCoins.premium2.containsKey(uuid)){
									WolvCoins.premium2.remove(uuid);
									WolvCoins.premium3.put(uuid, 3);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(3).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(3).");
								}
								if(WolvCoins.premium3.containsKey(uuid)){
									WolvCoins.premium3.remove(uuid);
									WolvCoins.premium4.put(uuid, 4);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(4).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(4).");
								}
								if(WolvCoins.premium4.containsKey(uuid)){
									WolvCoins.premium4.remove(uuid);
									WolvCoins.premium5.put(uuid, 5);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(5).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(5).");
								}
								if(WolvCoins.premium5.containsKey(uuid)){
									WolvCoins.premium5.remove(uuid);
									WolvCoins.premium6.put(uuid, 6);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(6).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(6).");
								}
								if(WolvCoins.premium6.containsKey(uuid)){
									WolvCoins.premium6.remove(uuid);
									WolvCoins.premium7.put(uuid, 7);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(7).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(7).");
								}
								if(WolvCoins.premium7.containsKey(uuid)){
									WolvCoins.premium7.remove(uuid);
									WolvCoins.premium8.put(uuid, 8);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(8).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(8).");
								}
								if(WolvCoins.premium8.containsKey(uuid)){
									WolvCoins.premium8.remove(uuid);
									WolvCoins.premium9.put(uuid, 9);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(9).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(9).");
								}
								if(WolvCoins.premium9.containsKey(uuid)){
									WolvCoins.premium9.remove(uuid);
									WolvCoins.premium10.put(uuid, 10);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(10).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(10).");
									Bukkit.broadcastMessage(ChatColor.YELLOW+cible.getName()+" vient de passer niveau 10 "+ChatColor.UNDERLINE+""+ChatColor.GREEN+" premium "+ChatColor.RESET+""+ChatColor.YELLOW+"!");
								}
								if(WolvCoins.premium10.containsKey(uuid)){
									s.sendMessage(ChatColor.RED+"Vous ne pouvez pas améliorer le niveau premium de "+cible.getName()+" car il est déjà au niveau maximal.");
								}
								if(!WolvCoins.premium.containsKey(uuid)){
									WolvCoins.premium1.put(uuid, 1);
									WolvCoins.premium.put(uuid, 1);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(1).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(1).");
								}
							}else{
								s.sendMessage(ChatColor.RED+"Le joueur cible n'existe pas ou n'est pas connecté.");
							}
						}
					}
					// /removePremium
					if(args[0].equalsIgnoreCase("removepremium")){
						if(s.hasPermission("wolvcoins.removePremium")){
							Player cible = Bukkit.getPlayer(args[1]);
							UUID uuid = cible.getUniqueId();
							if(cible != null){
								if(WolvCoins.premium1.containsKey(uuid)){
									WolvCoins.premium1.remove(uuid);
									WolvCoins.premium.remove(uuid);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" normal.");
									cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"normal.");
								}
								if(WolvCoins.premium2.containsKey(uuid)){
									WolvCoins.premium2.remove(uuid);
									WolvCoins.premium1.put(uuid, 1);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(1).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(1).");
								}
								if(WolvCoins.premium3.containsKey(uuid)){
									WolvCoins.premium3.remove(uuid);
									WolvCoins.premium2.put(uuid, 2);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(2).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(2).");
								}
								if(WolvCoins.premium4.containsKey(uuid)){
									WolvCoins.premium4.remove(uuid);
									WolvCoins.premium3.put(uuid, 3);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(3).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(3).");
								}
								if(WolvCoins.premium5.containsKey(uuid)){
									WolvCoins.premium5.remove(uuid);
									WolvCoins.premium4.put(uuid, 4);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(4).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(4).");
								}
								if(WolvCoins.premium6.containsKey(uuid)){
									WolvCoins.premium6.remove(uuid);
									WolvCoins.premium5.put(uuid, 5);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(5).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(5).");
								}
								if(WolvCoins.premium7.containsKey(uuid)){
									WolvCoins.premium7.remove(uuid);
									WolvCoins.premium6.put(uuid, 6);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(6).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(6).");
								}
								if(WolvCoins.premium8.containsKey(uuid)){
									WolvCoins.premium8.remove(uuid);
									WolvCoins.premium7.put(uuid, 7);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(7).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(7).");
								}
								if(WolvCoins.premium9.containsKey(uuid)){
									WolvCoins.premium9.remove(uuid);
									WolvCoins.premium8.put(uuid, 8);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(8).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(8).");
								}
								if(WolvCoins.premium10.containsKey(uuid)){
									WolvCoins.premium10.remove(uuid);
									WolvCoins.premium9.put(uuid, 9);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(9).");
									cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(9).");
								}if(!WolvCoins.premium.containsKey(uuid)){
									s.sendMessage(ChatColor.RED+"Vous ne pouvez pas baissez le niveau premium du joueur cible car il ne l'est pas.");
								}
							}else{
								s.sendMessage(ChatColor.RED+"Le joueur cible n'existe pas ou n'est pas connecté.");
							}
						}
					}
					// /unsetPremium
					if(args[0].equalsIgnoreCase("unsetpremium")){
						if(s.hasPermission("wolvcoins.unsetPremium")){
							Player cible = Bukkit.getPlayer(args[1]);
							if(cible != null){
								if(WolvCoins.premium.containsKey(cible.getUniqueId())){
									WolvCoins.premium.remove(cible.getUniqueId());
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" normal.");
									cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"normal.");
									if(WolvCoins.premium1.containsKey(cible.getUniqueId())){
										WolvCoins.premium1.remove(cible.getUniqueId());
									}
									if(WolvCoins.premium2.containsKey(cible.getUniqueId())){
										WolvCoins.premium2.remove(cible.getUniqueId());
									}
									if(WolvCoins.premium3.containsKey(cible.getUniqueId())){
										WolvCoins.premium3.remove(cible.getUniqueId());
									}
									if(WolvCoins.premium4.containsKey(cible.getUniqueId())){
										WolvCoins.premium4.remove(cible.getUniqueId());
									}
									if(WolvCoins.premium5.containsKey(cible.getUniqueId())){
										WolvCoins.premium5.remove(cible.getUniqueId());
									}
									if(WolvCoins.premium6.containsKey(cible.getUniqueId())){
										WolvCoins.premium6.remove(cible.getUniqueId());
									}
									if(WolvCoins.premium7.containsKey(cible.getUniqueId())){
										WolvCoins.premium7.remove(cible.getUniqueId());
									}
									if(WolvCoins.premium8.containsKey(cible.getUniqueId())){
										WolvCoins.premium8.remove(cible.getUniqueId());
									}
									if(WolvCoins.premium9.containsKey(cible.getUniqueId())){
										WolvCoins.premium9.remove(cible.getUniqueId());
									}
									if(WolvCoins.premium10.containsKey(cible.getUniqueId())){
										WolvCoins.premium10.remove(cible.getUniqueId());
									}
								}else{
									s.sendMessage(ChatColor.RED+"Le joueur cible n'est pas premium.");
								}
							}else{
								s.sendMessage(ChatColor.RED+"Le joueur cible n'existe pas ou n'est pas connecté.");
							}
						}
					}
					// /premium info
					if(args[0].equalsIgnoreCase("premium") && args[1].equalsIgnoreCase("info")){
						if(s.hasPermission("wolvcoins.premiumInfo")){
							s.sendMessage(ChatColor.LIGHT_PURPLE+"-----------[*Premium Info*]----------");
							s.sendMessage(ChatColor.GOLD+"niveau 1:  "+ChatColor.DARK_GREEN+"-reçois 1.5 C.W. par minute.");
							s.sendMessage(ChatColor.DARK_GREEN+"           -Nous attendons une idée pour mettre un nouvel ajout.");
							s.sendMessage(ChatColor.GOLD+"niveau 2:  "+ChatColor.DARK_GREEN+"-reçois 2 C.W. par minute.");
							s.sendMessage(ChatColor.DARK_GREEN+"           -Nous attendons une idée pour mettre un nouvel ajout.");
							s.sendMessage(ChatColor.GOLD+"niveau 3:  "+ChatColor.DARK_GREEN+"-reçois 2.5 C.W. par minute.");
							s.sendMessage(ChatColor.DARK_GREEN+"           -Nous attendons une idée pour mettre un nouvel ajout.");
							s.sendMessage(ChatColor.GOLD+"niveau 4:  "+ChatColor.DARK_GREEN+"-reçois 3.0 C.W. par minute.");
							s.sendMessage(ChatColor.DARK_GREEN+"           -Nous attendons une idée pour mettre un nouvel ajout.");
							s.sendMessage(ChatColor.GOLD+"niveau 5:  "+ChatColor.DARK_GREEN+"-reçois 3.5 C.W. par minute.");
							s.sendMessage(ChatColor.DARK_GREEN+"           -Nous attendons une idée pour mettre un nouvel ajout.");
							s.sendMessage(ChatColor.GOLD+"niveau 6:  "+ChatColor.DARK_GREEN+"-reçois 4.0 C.W. par minute.");
							s.sendMessage(ChatColor.DARK_GREEN+"           -Nous attendons une idée pour mettre un nouvel ajout.");
							s.sendMessage(ChatColor.GOLD+"niveau 7:  "+ChatColor.DARK_GREEN+"-reçois 5.0 C.W. par minute.");
							s.sendMessage(ChatColor.DARK_GREEN+"           -Nous attendons une idée pour mettre un nouvel ajout.");
							s.sendMessage(ChatColor.GOLD+"niveau 8:  "+ChatColor.DARK_GREEN+"-reçois 6.0 C.W. par minute.");
							s.sendMessage(ChatColor.DARK_GREEN+"           -Nous attendons une idée pour mettre un nouvel ajout.");
							s.sendMessage(ChatColor.GOLD+"niveau 9:  "+ChatColor.DARK_GREEN+"-reçois 7 C.W. par minute.");
							s.sendMessage(ChatColor.DARK_GREEN+"           -Nous attendons une idée pour mettre un nouvel ajout.");
							s.sendMessage(ChatColor.GOLD+"niveau 10: "+ChatColor.DARK_GREEN+"-reçois 10.0 C.W. par minute.");
							s.sendMessage(ChatColor.DARK_GREEN+"           -Nous attendons une idée pour mettre un nouvel ajout.");
							s.sendMessage(ChatColor.AQUA+"Contactez un membre du staff ou Vilevar si vous avez une idée pour un nouvel ajout.");
							s.sendMessage(ChatColor.AQUA+"Contactez un membre du staff pour devenir premium.");
							s.sendMessage(ChatColor.LIGHT_PURPLE+"-----------[*Premium Info*]----------");
						}
					}
				}
				if(args.length == 3){
					// /pay
					if(args[0].equalsIgnoreCase("pay")){
						if(s.hasPermission("wolvcoins.pay")){
							if(s instanceof Player){
								
								Player p = (Player)s;
								UUID uuid = p.getUniqueId();
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
									p.sendMessage(ChatColor.RED+"Le joueur cible n'existe pas ou n'est pas connecté.");
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
									economy.depositPlayer(cible, montant);
									s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.DARK_GREEN+"le compte de "+ChatColor.AQUA+cible.getName()+ChatColor.DARK_GREEN+" à "+ChatColor.YELLOW+set+" C.W.");
									cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.DARK_GREEN+"votre compte à "+ChatColor.YELLOW+set+" C.W.");
								}else{
									s.sendMessage(ChatColor.RED+"Vous ne pouvez pas lui mettre un nombre inférieur à 0 C.W.");
								}
							}else{
								s.sendMessage(notCible);
							}
						}
					}
					// /setPremium
					if(args[0].equalsIgnoreCase("setpremium")){
						if(s.hasPermission("wolvcoins.setPremium")){
							
							Player cible = Bukkit.getPlayer(args[1]);
							UUID uuid = cible.getUniqueId();
							
							if(cible != null){
								if(WolvCoins.premium.containsKey(uuid)){
									if(WolvCoins.premium1.containsKey(uuid)){
										WolvCoins.premium1.remove(uuid);
									}
									if(WolvCoins.premium2.containsKey(uuid)){
										WolvCoins.premium2.remove(uuid);
									}
									if(WolvCoins.premium2.containsKey(uuid)){
										WolvCoins.premium2.remove(uuid);
									}
									if(WolvCoins.premium3.containsKey(uuid)){
										WolvCoins.premium3.remove(uuid);
									}
									if(WolvCoins.premium4.containsKey(uuid)){
										WolvCoins.premium4.remove(uuid);
									}
									if(WolvCoins.premium5.containsKey(uuid)){
										WolvCoins.premium5.remove(uuid);
									}
									if(WolvCoins.premium6.containsKey(uuid)){
										WolvCoins.premium6.remove(uuid);
									}
									if(WolvCoins.premium7.containsKey(uuid)){
										WolvCoins.premium7.remove(uuid);
									}
									if(WolvCoins.premium8.containsKey(uuid)){
										WolvCoins.premium8.remove(uuid);
									}
									if(WolvCoins.premium9.containsKey(uuid)){
										WolvCoins.premium9.remove(uuid);
									}
									if(WolvCoins.premium10.containsKey(uuid)){
										WolvCoins.premium10.remove(uuid);
									}
									WolvCoins.premium.remove(uuid);
								}
									if(args[2].equalsIgnoreCase("1")){
										WolvCoins.premium.put(uuid, 1);
										WolvCoins.premium1.put(uuid, 1);
										s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(1).");
										cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(1).");
									}
									if(args[2].equalsIgnoreCase("2")){
										WolvCoins.premium.put(uuid, 2);
										WolvCoins.premium2.put(uuid, 2);
										s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(2).");
										cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(2).");
									}
									if(args[2].equalsIgnoreCase("3")){
										WolvCoins.premium.put(uuid, 3);
										WolvCoins.premium3.put(uuid, 3);
										s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(3).");
										cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(3).");
									}
									if(args[2].equalsIgnoreCase("4")){
										WolvCoins.premium.put(uuid, 4);
										WolvCoins.premium4.put(uuid, 4);
										s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(4).");
										cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(4).");
									}
									if(args[2].equalsIgnoreCase("5")){
										WolvCoins.premium.put(uuid, 5);
										WolvCoins.premium5.put(uuid, 5);
										s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(5).");
										cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(5).");
									}
									if(args[2].equalsIgnoreCase("6")){
										WolvCoins.premium.put(uuid, 6);
										WolvCoins.premium6.put(uuid, 6);
										s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(6).");
										cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(6).");
									}
									if(args[2].equalsIgnoreCase("7")){
										WolvCoins.premium.put(uuid, 7);
										WolvCoins.premium7.put(uuid, 7);
										s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(7).");
										cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(7).");
									}
									if(args[2].equalsIgnoreCase("8")){
										WolvCoins.premium.put(uuid, 8);
										WolvCoins.premium8.put(uuid, 8);
										s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(8).");
										cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(8).");
									}
									if(args[2].equalsIgnoreCase("9")){
										WolvCoins.premium.put(uuid, 9);
										WolvCoins.premium9.put(uuid, 9);
										s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(9).");
										cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(9).");
									}
									if(args[2].equalsIgnoreCase("10")){
										WolvCoins.premium.put(uuid, 10);
										WolvCoins.premium10.put(uuid, 10);
										s.sendMessage(ChatColor.DARK_GREEN+"Vous venez de "+ChatColor.GRAY+"mettre "+ChatColor.AQUA+cible.getName()+ChatColor.YELLOW+" premium(10).");
										cible.sendMessage(ChatColor.AQUA+s.getName()+ChatColor.DARK_GREEN+" vient de vous "+ChatColor.GRAY+"mettre "+ChatColor.YELLOW+"premium(10).");
									}
							}else{
								s.sendMessage(ChatColor.RED+"Le joueur cible n'existe pas ou n'est pas connecté.");
							}
						}
					}
				}
			}
		}
		return false;
	}
}