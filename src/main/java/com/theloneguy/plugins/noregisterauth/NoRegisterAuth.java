package com.theloneguy.plugins.noregisterauth;

import com.theloneguy.plugins.noregisterauth.DataBase.Mongo;
import com.theloneguy.plugins.noregisterauth.listeners.Join;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class NoRegisterAuth extends JavaPlugin {

    public static NoRegisterAuth plugin;

    public static void GlobalLogger(Level level, String message) {
        plugin.getLogger().log(level, message);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();

        new Mongo().connect();

        plugin.getServer().getPluginManager().registerEvents(new Join(), plugin);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
