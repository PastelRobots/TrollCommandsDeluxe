package me.pastelrobots.trollcommandsdeluxe.commands;

import me.pastelrobots.trollcommandsdeluxe.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FakeBanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(!Config.getBoolean("commands.fakeban.enabled")) return true;
        if(s instanceof Player p) {
            if(args.length != 1) {
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Invalid Arguments!");
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (p.hasPermission("trollcommandsdeluxe.fakeban")) {
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

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> playerNames = new ArrayList<>();
            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);
            for (Player player : players) {
                playerNames.add(player.getName());
            }
            return playerNames;

        }
        return null;
    }
}
