package me.pastelrobots.trollcommandsdeluxe;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Config {
    public static int getInt(String intpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getInt(intpath);
    }

    public static boolean getBoolean(String booleanpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getBoolean(booleanpath);
    }

    public static double getDouble(String doublepath) {
        return TrollCommandsDeluxe.plugin.getConfig().getDouble(doublepath);
    }

    public static String getString(String stringpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getString(stringpath);
    }

    public static Object getObject(String objectpath, Class<Boolean> clazz) {
        return TrollCommandsDeluxe.plugin.getConfig().getObject(objectpath, clazz);
    }

    public static List<Boolean> getBooleanList(String booleanpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getBooleanList(booleanpath);
    }

    public static List<String> getStringList(String stringpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getStringList(stringpath);
    }

    public static List<Byte> getByteList(String bytepath) {
        return TrollCommandsDeluxe.plugin.getConfig().getByteList(bytepath);
    }

    public static List<Character> getCharacterList(String characterpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getCharacterList(characterpath);
    }

    public static Color getColour(String colourpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getColor(colourpath);
    }

    public static List<Double> getDoubleList(String doublepath) {
        return TrollCommandsDeluxe.plugin.getConfig().getDoubleList(doublepath);
    }

    public static List<Float> getFloatList(String floatpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getFloatList(floatpath);
    }

    public static List<Integer> getIntList(String intpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getIntegerList(intpath);
    }

    public static ItemStack getItemStack(String itemstackpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getItemStack(itemstackpath);
    }

    public static List getList(String listpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getList(listpath);
    }

    public static Vector getVector(String vecpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getVector(vecpath);
    }

    public static Set<String> getKeys(boolean deep) {
        return TrollCommandsDeluxe.plugin.getConfig().getKeys(deep);
    }

    public static Map<String, Object> getValues(boolean deep) {
        return TrollCommandsDeluxe.plugin.getConfig().getValues(deep);
    }

    public static List<Short> getShortList(String shortpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getShortList(shortpath);
    }

    public static OfflinePlayer getOfflinePlayer(String offlpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getOfflinePlayer(offlpath);
    }

    public static List<Map<?, ?>> getMapList(String mappath) {
        return TrollCommandsDeluxe.plugin.getConfig().getMapList(mappath);
    }

    public static List<Long> getLongList(String longpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getLongList(longpath);
    }

    public static Long getLong(String longpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getLong(longpath);
    }

    public static Location getLocation(String locpath) {
        return TrollCommandsDeluxe.plugin.getConfig().getLocation(locpath);
    }

    public static ConfigurationSection getConfigSection(String cspath) {
        return TrollCommandsDeluxe.plugin.getConfig().getConfigurationSection(cspath);
    }

}