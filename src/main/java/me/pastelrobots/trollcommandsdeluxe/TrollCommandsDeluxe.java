package me.pastelrobots.trollcommandsdeluxe;

import me.pastelrobots.trollcommandsdeluxe.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public final class TrollCommandsDeluxe extends JavaPlugin {
    public static Plugin plugin;
    private Set<String> commands = this.getDescription().getCommands().keySet();

    @Override
    public void onEnable() {

        createCustomConfig();
        plugin = this;
        int pluginId = 12566;
        Metrics metrics = new Metrics(this, pluginId);
        if (plugin.getConfig().getBoolean("console.enabled-msg")) {
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
                }
            }
        }
    }

    @Override
    public void onDisable() {
        if (plugin.getConfig().getBoolean("console.enabled-msg")) {
            Bukkit.getLogger().info(ChatColor.RED + "=============================================");
            Bukkit.getLogger().info(ChatColor.BLUE + "TrollCommandsDeluxe has been turned off!");
            Bukkit.getLogger().info(ChatColor.BLUE + "If you need help or support join the" + ChatColor.BLUE + " discord.");
            Bukkit.getLogger().info(ChatColor.DARK_BLUE + "discord.gg/VtgcZRnmMR");
            Bukkit.getLogger().info(ChatColor.BLUE + "Bye-bye!");
            Bukkit.getLogger().info(ChatColor.RED + "=============================================");
        }
    }


    private void createCustomConfig() {
            File configfile = new File(getDataFolder(), "config.yml");

            if (!configfile.exists()) {
                configfile.getParentFile().mkdirs();
                saveResource("config.yml", false);
            }
            FileConfiguration config = new YamlConfiguration();

            try {
                config.load(configfile);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }
        }
    }
