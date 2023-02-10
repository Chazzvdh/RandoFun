// Main code

package randofun.randofun;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import randofun.randofun.commands.BoomCommand;
import randofun.randofun.commands.HugCommand;
import randofun.randofun.commands.QuackCommand;

public final class RandoFun extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "RandoFun " + ChatColor.GRAY + "has been " + ChatColor.GREEN + "Enabled " + ChatColor.GRAY + "and is now ready to bring some " + ChatColor.AQUA + "RANDOM " + ChatColor.GRAY + "fun to your game!");
        Bukkit.getPluginCommand("boom").setExecutor(new BoomCommand());
        Bukkit.getPluginCommand("hug").setExecutor(new HugCommand());
        Bukkit.getPluginCommand("quack").setExecutor(new QuackCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "RandoFun " + ChatColor.GRAY + "has been " + ChatColor.RED + "Disabled " + ChatColor.GRAY + "and will no longer bring " + ChatColor.AQUA + "RANDOM " + ChatColor.GRAY + "fun to your game. " + ChatColor.YELLOW + "Goodbye " + ChatColor.GRAY + "for now!");
    }
}
