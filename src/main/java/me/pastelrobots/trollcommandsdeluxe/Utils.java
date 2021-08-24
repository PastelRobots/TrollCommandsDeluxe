package me.pastelrobots.trollcommandsdeluxe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public final class Utils {

    public static void logInfo(String message) {
        if (TrollCommandsDeluxe.plugin.getConfig().getBoolean("console.debug-mode")) {
            Bukkit.getLogger().info(ChatColor.BLUE+message);
        }
    }
}
