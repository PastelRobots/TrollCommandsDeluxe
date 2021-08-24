package me.pastelrobots.trollcommandsdeluxe.commands;

import me.pastelrobots.trollcommandsdeluxe.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeBanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(!Config.getBoolean("commands.fakeban.enabled")) return true;
        if(s instanceof Player p) {
            if(args.length != 1) {
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Invalid Arguments!");
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (p.hasPermission("trollcommandsdeluxe.fakebam")) {
                    if(target instanceof Player) {
                        if(target.hasPermission("trollcommandsdeluxe.bypass")) {
                            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + target.getName() + " bypasses this as they have the bypass permission!");
                        } else {
                            target.kickPlayer(ChatColor.translateAlternateColorCodes('&', Config.getString("commands.fakeban.message")));
                        }
                    }
                }
            }
        } else {
            if(args.length != 1) {
                Bukkit.getLogger().warning(ChatColor.RED + "" + ChatColor.BOLD + "Invalid Arguments!");
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if(target instanceof Player) {
                    if(target.hasPermission("trollcommandsdeluxe.bypass")) {
                        Bukkit.getLogger().warning(ChatColor.RED + "" + ChatColor.BOLD + target.getName() + " bypasses this as they have the bypass permission!");
                    } else {
                        target.kickPlayer(ChatColor.translateAlternateColorCodes('&', Config.getString("commands.fakeban.message")));
                    }
                }
            }
        }
        return false;
    }
}
