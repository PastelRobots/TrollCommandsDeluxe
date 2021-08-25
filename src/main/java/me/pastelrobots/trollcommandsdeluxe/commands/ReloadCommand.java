package me.pastelrobots.trollcommandsdeluxe.commands;

import me.pastelrobots.trollcommandsdeluxe.ConfigFile;
import me.pastelrobots.trollcommandsdeluxe.TrollCommandsDeluxe;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player p) {
            if(p.hasPermission("trollcommandsdeluxe.reload")) {
                ConfigFile.save();
                ConfigFile.reload();
                TrollCommandsDeluxe.plugin.getPluginLoader().disablePlugin(TrollCommandsDeluxe.plugin);
                TrollCommandsDeluxe.plugin.getPluginLoader().enablePlugin(TrollCommandsDeluxe.plugin);
                p.sendMessage(ChatColor.GREEN + "Plugin reloaded!");
            }

        } else {
            ConfigFile.save();
            ConfigFile.reload();
            TrollCommandsDeluxe.plugin.getPluginLoader().disablePlugin(TrollCommandsDeluxe.plugin);
            TrollCommandsDeluxe.plugin.getPluginLoader().enablePlugin(TrollCommandsDeluxe.plugin);
            Bukkit.getLogger().info(ChatColor.GREEN + "Plugin reloaded!");
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
