package com.company.Problems;

public class P468 {
    public static String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    public static boolean isIPv4(String IP) {
        if (IP.startsWith(".") || IP.endsWith(".")) {
            return false;
        }
        String[] ips = IP.split("\\.");
        if (ips.length != 4) {
            return false;
        }
        for(int i=0; i<4; i++) {
            try {
                int num = Integer.parseInt(ips[i]);
                if (num > 255 || num < 0) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIPv6(String IP) {
        if (IP.startsWith(":") || IP.endsWith(":")) {
            return false;
        }
        String[] ips = IP.split(":");
        if (ips.length != 8) {
            return false;
        }
        for(int i=0; i<8; i++) {
            String hex = ips[i];
            if (hex.length() > 4) {
                return false;
            }
            try {
                int num = Integer.parseInt(hex, 16);
                if (num > 65535 || num < 0) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
