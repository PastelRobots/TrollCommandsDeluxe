package me.pastelrobots.trollcommandsdeluxe.commands;

import me.pastelrobots.trollcommandsdeluxe.Config;
import me.pastelrobots.trollcommandsdeluxe.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SpamChatCommand implements CommandExecutor {
    public static String getAlphaNumericString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        Utils.logInfo("Checking if command is enabled");
        if(!Config.getBoolean("commands.spamchat.enabled")) return true;
        Utils.logInfo("Checking if sender is a player or console");
        if(s instanceof Player p) {
            Utils.logInfo("Checking args");
            if(args.length != 1) {
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Invalid Arguments!");
            } else {
                Utils.logInfo("Grabbing Target");
                Player target = Bukkit.getPlayerExact(args[0]);
                Utils.logInfo("Checking perms");
                if (p.hasPermission("trollcommandsdeluxe.spamchat")) {
                    Utils.logInfo("Checking if target is valid");
                    if(target instanceof Player) {
                        Utils.logInfo("Checking target's perms");
                        if(target.hasPermission("trollcommandsdeluxe.bypass")) {
                            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + target.getName() + " bypasses this as they have the bypass permission!");
                        } else {
                            for(int i=1;i<=250;i++){
                                target.sendMessage(getAlphaNumericString(20));
                            }
                        }
                    } else if(args[0].toLowerCase().equals("global")) {
                        if (s.hasPermission("trollcommandsdeluxe.spamchat.global")) {
                            long t = System.currentTimeMillis();
                            long end = t + 3000;
                            while (System.currentTimeMillis() < end) {
                                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                                    if (!player.isOp() || !player.hasPermission("trollcommandsdeluxe.bypass")) {
                                        player.sendMessage(getAlphaNumericString(20));
                                    }

                                }
                                try {
                                    Thread.sleep(25);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
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
                        long t= System.currentTimeMillis();
                        long end = t+3000;
                        while(System.currentTimeMillis() < end) {
                            target.sendMessage(getAlphaNumericString(20));
                            try {
                                Thread.sleep( 25 );
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else if(args[0].toLowerCase().equals("global")) {
                        long t = System.currentTimeMillis();
                        long end = t + 3000;
                        while (System.currentTimeMillis() < end) {
                            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                                if (!player.isOp() || !player.hasPermission("trollcommandsdeluxe.bypass")) {
                                    player.sendMessage(getAlphaNumericString(20));
                                }

                            }
                            try {
                                Thread.sleep(25);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
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
            playerNames.add("global");
            return playerNames;

        }
        return null;
    }
}
