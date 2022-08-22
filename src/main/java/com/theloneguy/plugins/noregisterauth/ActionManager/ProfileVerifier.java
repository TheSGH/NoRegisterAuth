package com.theloneguy.plugins.noregisterauth.ActionManager;

import java.net.Inet4Address;
import java.util.Objects;
import java.util.regex.Pattern;

public class ProfileVerifier {

    public static boolean NameVerifier(String name) {

        String regex = "[a-zA-Z0-9_]*";

        return Pattern.matches(regex, name);
    }

//    public static boolean NameCaseVerifier(String joinname, String Mongoname) {
//
//        return joinname == Mongoname;
//
//    }

    public static boolean DataVerifier(String name, Inet4Address ip, String mongoname, Inet4Address mongoip) {

        return Objects.equals(name, mongoname) && Objects.equals(ip, mongoip);

    }

}
