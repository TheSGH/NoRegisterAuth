package com.theloneguy.plugins.noregisterauth.listeners;

import com.mongodb.BasicDBObject;
import com.theloneguy.plugins.noregisterauth.ActionManager.ProfileVerifier;
import com.theloneguy.plugins.noregisterauth.DataBase.Mongo;
import org.bson.Document;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Join implements Listener {

    @EventHandler
    public void OnJoinListener(AsyncPlayerPreLoginEvent e) {

        String name = e.getName();
        String name_lower = name.toLowerCase();
        Inet4Address ip = (Inet4Address) e.getAddress();

        Document mongores = Mongo.collection.find(new BasicDBObject("username", name_lower)).first();

        if (ip == null) {
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.RED + "No Session Found !");
            return;
        }


        if (mongores == null) {
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.RED + "No Session Found !");
            return;
        }

        String mongo_CaSeSeNsEtIvE_name = (String) mongores.get("name");
        String mongo_name = (String) mongores.get("username");
        Inet4Address mongo_login_ip = null;

        try {
            mongo_login_ip = (Inet4Address) Inet4Address.getByName(mongores.get("loginip").toString());
        } catch (UnknownHostException ex) {
            throw new RuntimeException(ex);
        }


        if (mongo_login_ip == null) {
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.RED + "No Session Found !");
            return;
        }

        if (mongo_CaSeSeNsEtIvE_name == null) {
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.RED + "No Session Found !");
            return;
        }

        if (mongo_name == null) {
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.RED + "No Session Found !");
            return;
        }

        if (ProfileVerifier.NameVerifier(name) && ProfileVerifier.DataVerifier(name, ip, mongo_CaSeSeNsEtIvE_name, mongo_login_ip)) {
            e.allow();
            return;
        }


        e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.RED + "No Session Found !");
    }
}
