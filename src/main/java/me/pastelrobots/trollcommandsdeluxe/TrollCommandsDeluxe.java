package me.pastelrobots.trollcommandsdeluxe;

import com.tchristofferson.configupdater.ConfigUpdater;
import me.pastelrobots.trollcommandsdeluxe.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public final class TrollCommandsDeluxe extends JavaPlugin {
    public static Plugin plugin;
    private Set<String> commands = this.getDescription().getCommands().keySet();
    List<String> fakeJoinNames = Arrays.asList("PastelRobots", "Herobrine", "epicgamer123", "Notch");

    @Override
    public void onEnable() {
        plugin = this;
        ConfigFile.setup();
        saveDefaultConfig();
        File configFile = new File(getDataFolder(), "config.yml");

        try {
            ConfigUpdater.update(plugin, "config.yml", configFile, Arrays.asList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        reloadConfig();
        int pluginId = 12566;
        Metrics metrics = new Metrics(this, pluginId);
        if (Config.getBoolean("console.enabled-msg")) {
            Bukkit.getLogger().info(ChatColor.GOLD + "=============================================");
            Bukkit.getLogger().info(ChatColor.GREEN + "TrollCommandsDeluxe has been turned on!");
            Bukkit.getLogger().info(ChatColor.GREEN + "If you need help or support join the" + ChatColor.BLUE + " discord.");
            Bukkit.getLogger().info(ChatColor.BLUE + "discord.gg/VtgcZRnmMR");
            Bukkit.getLogger().info(ChatColor.GOLD + "=============================================");
        }
        for (String c : this.commands) {
            Utils.logInfo("Registering the " + c + " command.");
            switch (c) {
                case "fakeop": {
                    getCommand(c).setExecutor(new FakeOPCommand());
                    break;
                }
            }
            switch (c) {
                case "fakeban": {
                    getCommand(c).setExecutor(new FakeBanCommand());
                    break;
                }
            }
            switch (c) {
                case "rocket": {
                    getCommand(c).setExecutor(new RocketCommand());
                    break;
                }
            }
            switch (c) {
                case "explode": {
                    getCommand(c).setExecutor(new ExplodeCommand());
                    break;
                }
            }
            switch (c) {
                case "butterfingers": {
                    getCommand(c).setExecutor(new ButterFingersCommand());
                    break;
                }
            }
            switch (c) {
                case "fire": {
                    getCommand(c).setExecutor(new FireCommand());
                    break;
                }
            }
            switch (c) {
                case "smite": {
                    getCommand(c).setExecutor(new LightningCommand());
                    break;
                }
            }
            switch (c) {
                case "spamchat": {
                    getCommand(c).setExecutor(new SpamChatCommand());
                    break;
                }
            }
            switch (c) {
                case "closeinventory": {
                    getCommand(c).setExecutor(new CloseInventoryCommand());
                    break;
                }
            }
            switch (c) {
                case "weak": {
                    getCommand(c).setExecutor(new WeakCommand());
                    break;
                }
            }
            switch (c) {
                case "creeper": {
                    getCommand(c).setExecutor(new CreeperCommand());
                    break;
                }
            }
            switch (c) {
                case "fakejoin": {
                    getCommand(c).setExecutor(new FakeJoinCommand());
                    break;
                }
            }
            switch (c) {
                case "fakecrash": {
                    getCommand(c).setExecutor(new FakeCrashCommand());
                    break;
                }
            }
            switch (c) {
                case "flip": {
                    getCommand(c).setExecutor(new FlipCommand());
                }
            }
        }
    }

    @Override
    public void onDisable() {
        ConfigFile.save();
        if (Config.getBoolean("console.enabled-msg")) {
            Bukkit.getLogger().info(ChatColor.RED + "=============================================");
            Bukkit.getLogger().info(ChatColor.BLUE + "TrollCommandsDeluxe has been turned off!");
            Bukkit.getLogger().info(ChatColor.BLUE + "If you need help or support join the" + ChatColor.BLUE + " discord.");
            Bukkit.getLogger().info(ChatColor.DARK_BLUE + "discord.gg/VtgcZRnmMR");
            Bukkit.getLogger().info(ChatColor.BLUE + "Bye-bye!");
            Bukkit.getLogger().info(ChatColor.RED + "=============================================");
        }
    }
}


