package me.pastelrobots.trollcommandsdeluxe.commands;

import me.pastelrobots.trollcommandsdeluxe.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class PickpocketCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(!Config.getBoolean("commands.pickpocket.enabled")) return true;
        if(s instanceof Player p) {
            if(args.length != 1) {
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Invalid Arguments!");
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (p.hasPermission("trollcommandsdeluxe.pickpocket")) {
                    if(target instanceof Player) {
                        Inventory inv = target.getInventory();
                        Location loc = target.getLocation();
                        if(target.hasPermission("trollcommandsdeluxe.bypass")) {
                            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + target.getName() + " bypasses this as they have the bypass permission!");
                        } else {
                            p.openInventory(inv);
                        }
                    }
                }
            }
        } else {
            Bukkit.getLogger().info(ChatColor.RED + "This command is only runnable by a player!");
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
