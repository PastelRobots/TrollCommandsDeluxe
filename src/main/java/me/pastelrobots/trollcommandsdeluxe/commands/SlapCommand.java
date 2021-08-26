package me.pastelrobots.trollcommandsdeluxe.commands;

import me.pastelrobots.trollcommandsdeluxe.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SlapCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(!Config.getBoolean("commands.slap.enabled")) return true;
        if(s instanceof Player p) {
            if(args.length != 1) {
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Invalid Arguments!");
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (p.hasPermission("trollcommandsdeluxe.slap")) {
                    if(target instanceof Player) {
                        Location loc = target.getLocation();
                        if(target.hasPermission("trollcommandsdeluxe.bypass")) {
                            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + target.getName() + " bypasses this as they have the bypass permission!");
                        } else {
                            for (int i = 0; i < 10; ++i) {
                                loc.setYaw((float) (loc.getYaw() + (Math.random() * 10)));
                                try {
                                    Thread.sleep(20);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            target.teleport(loc);
                            if (!(target.getHealth() >= Config.getInt("commands.slap.health"))) {
                                target.setHealth(0);
                            } else {
                                target.setHealth(target.getHealth() - Config.getInt("commands.slap.health"));
                            }
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
                    Location loc = target.getLocation();
                    if(target.hasPermission("trollcommandsdeluxe.bypass")) {
                        Bukkit.getLogger().warning(ChatColor.RED + "" + ChatColor.BOLD + target.getName() + " bypasses this as they have the bypass permission!");
                    } else {
                        for (int i = 0; i < 10; ++i) {
                            loc.setYaw((float) (loc.getYaw() + (Math.random() * 10)));
                            try {
                                Thread.sleep(20);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        target.teleport(loc);
                        if (!(target.getHealth() >= Config.getInt("commands.slap.health"))) {
                            target.setHealth(0);
                        } else {
                            target.setHealth(target.getHealth() - Config.getInt("commands.slap.health"));
                        }
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
