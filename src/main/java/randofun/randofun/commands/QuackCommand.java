package randofun.randofun.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QuackCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("quack")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                String playerName = sender.getName();
                Bukkit.broadcastMessage(playerName + ChatColor.GOLD + " Quacked");
                player.sendMessage("You just " + ChatColor.GOLD + "Quacked");
                return true;
            } else {
                sender.sendMessage("This command can only be used by a player.");
                return false;
            }
        }
        return false;
    }
}
