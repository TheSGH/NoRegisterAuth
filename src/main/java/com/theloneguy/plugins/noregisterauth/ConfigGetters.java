package com.theloneguy.plugins.noregisterauth;

public class ConfigGetters {

    public static String getconfig(String key) {

        String val = NoRegisterAuth.plugin.getConfig().getString(key);
        return val;

    }

}
