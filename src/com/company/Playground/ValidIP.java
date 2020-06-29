package com.company.Playground;

public class ValidIP {

    public boolean isValid(String IP) {
        if (IP.isEmpty()) {
            return false;
        }
        if (IP.startsWith(".") || IP.endsWith(".")) {
            return false;
        }
        String[] ips = IP.split("\\.");
        if (ips.length != 4) {
            return false;
        }
        for (int i=0; i<ips.length; i++) {
            try {
                if (ips[i].equals("-0")) {
                    return false;
                }
                int ip = Integer.parseInt(ips[i]);
                if (ip < 0 || ip >255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
