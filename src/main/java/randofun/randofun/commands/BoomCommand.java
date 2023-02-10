package randofun.randofun.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class BoomCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("boom")) {
            if (!sender.hasPermission("boom.use")) {
                sender.sendMessage(ChatColor.RED + "Error: You do not have permission to use this command.");
                return false;
            }
            if (sender instanceof Player) {
                Player player = (Player) sender;
                String playerName = sender.getName();
                if (args.length > 0) {
                    try {
                        float explosionSize = Float.parseFloat(args[0]);
                        if (explosionSize > 50.0f) {
                            player.sendMessage(ChatColor.RED + "Error: Maximum explosion size is 50.");
                            return false;
                        }
                        Bukkit.broadcastMessage("<" + player.getName() + ">" + ChatColor.RED + " BOOM " + explosionSize + ChatColor.RESET + "!");
                        Location explosionLocation = player.getLocation();
                        World world = player.getWorld();

                        // Default values
                        boolean destroyBlocks = false;
                        boolean setFire = false;

                        if (player.hasPermission("boom.options")) {
                            if (args.length > 1) {
                                destroyBlocks = Boolean.parseBoolean(args[1]);
                            }
                            if (args.length > 2) {
                                setFire = Boolean.parseBoolean(args[2]);
                            }
                        }

                        world.createExplosion(explosionLocation, explosionSize, setFire, destroyBlocks, player);

                        for (Entity entity : player.getNearbyEntities(explosionSize, explosionSize, explosionSize)) {
                            if (entity instanceof Player) {
                                Player target = (Player) entity;
                                target.damage(explosionSize * 5);
                            }
                        }
                        player.damage(explosionSize * 5);
                        return true;
                    } catch (NumberFormatException e) {
                        player.sendMessage(ChatColor.RED + "Error: Please enter a valid number for the explosion size.");
                        return false;
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Error: Please specify the size of the explosion.");
                    return false;
                }
            } else {
                sender.sendMessage("This command can only be used by a player.");
                return false;
            }
        }
        return false;
    }
}
