package randofun.randofun.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HugCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("hug")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    Bukkit.broadcastMessage("[" + ChatColor.YELLOW + player.getName() + ChatColor.GREEN + " send " + ChatColor.GOLD + "hugs " + ChatColor.GREEN + "to " + ChatColor.YELLOW + "everyone!" + ChatColor.RESET + "]");
                } else {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target == null) {
                        player.sendMessage(ChatColor.RED + "Player not found.");
                    } else {
                        target.sendMessage("[" + ChatColor.YELLOW + player.getName() + ChatColor.GREEN + " sends you a " + ChatColor.GOLD + "hug" + ChatColor.RESET + "]");
                        player.sendMessage("[" + ChatColor.GREEN + "You send a " + ChatColor.GOLD + "hug " + ChatColor.GREEN + "to " + ChatColor.YELLOW + target.getName() + ChatColor.RESET + "]");
                    }
                }
                return true;
            } else {
                sender.sendMessage("This command can only be used by a player.");
                return false;
            }
        }
        return false;
    }
}
