package me.pastelrobots.trollcommandsdeluxe.commands;

import me.pastelrobots.trollcommandsdeluxe.Config;
import me.pastelrobots.trollcommandsdeluxe.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class RocketCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        Utils.logInfo("Checking if command is enabled");
        if(!Config.getBoolean("commands.rocket.enabled")) return true;
        Utils.logInfo("Checking if sender is a player or console");
        if(s instanceof Player p) {
            Utils.logInfo("Checking args");
            if(args.length != 1) {
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Invalid Arguments!");
            } else {
                Utils.logInfo("Grabbing Target");
                Player target = Bukkit.getPlayerExact(args[0]);
                Utils.logInfo("Checking perms");
                if (p.hasPermission("trollcommandsdeluxe.rocket")) {
                    Utils.logInfo("Checking if target is valid");
                    if(target instanceof Player) {
                        Utils.logInfo("Checking target's perms");
                        if(target.hasPermission("trollcommandsdeluxe.bypass")) {
                            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + target.getName() + " bypasses this as they have the bypass permission!");
                        } else {
                            target.setVelocity(new Vector(0, Config.getInt("commands.rocket.velocity"), 0));
                        }
                    }
                }
            }
        } else {
            Utils.logInfo("Checking args");
            if(args.length != 1) {
                Bukkit.getLogger().warning(ChatColor.RED + "" + ChatColor.BOLD + "Invalid Arguments!");
            } else {
                Utils.logInfo("Grabbing target");
                Player target = Bukkit.getPlayerExact(args[0]);
                Utils.logInfo("Checking if target is valid");
                if(target instanceof Player) {
                    Utils.logInfo("Checking target's perms");
                    if(target.hasPermission("trollcommandsdeluxe.bypass")) {
                        Bukkit.getLogger().warning(ChatColor.RED + "" + ChatColor.BOLD + target.getName() + " bypasses this as they have the bypass permission!");
                    } else {
                        target.setVelocity(new Vector(0, Config.getInt("commands.rocket.velocity"), 0));
                    }
                }
            }
        }
        return false;
    }
}
