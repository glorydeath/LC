package com.company.Playground;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
    public static List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<String>();
        int n = s.length();
        if (n == 0) {
            return results;
        }
        int index = 0;
        String curIp = "";
        List<String> curIpAddress = new ArrayList<String>();
        // todo: here, curIpAddress should have some initial value (string element)
        curIpAddress.add(curIp);
        restore(results, s, index, curIp, curIpAddress, n);
        return results;
    }

    public static void restore(List<String> results, String s, int index, String curIp, List<String> curIpAddress, int n) {
        if (index >= n) {
            System.out.println("n : " + n + " cur ip size: " + curIpAddress.size());
            if (curIpAddress.size() == 4) {
                results.add(String.join(".", curIpAddress));
            }
            return;
        }
        char curCh = s.charAt(index);
        int curIpInt = 0;
        // todo: here, check for empty string
        if (!"".equals(curIp)) {
            curIpInt = Integer.valueOf(curIp);
        }
        curIpInt = curIpInt * 10 + curCh - '0';
        if (curIpInt <= 255) {
            curIp = curIp + curCh;
            // todo: check if string has trailing zero
            if (!stringWithPrefixZero(curIp)) {
                curIpAddress.set(curIpAddress.size() - 1, curIp);
                restore(results, s, index + 1, curIp, curIpAddress, n);
                curIp = curIp.substring(0, curIp.length() - 1);
                curIpAddress.set(curIpAddress.size() - 1, curIp);
            }
        }
        // todo: check current should not be empty string
        if (curIpAddress.size() < 4 && !"".equals(curIpAddress.get(curIpAddress.size() - 1))) {
            curIp = String.valueOf(curCh);
            curIpAddress.add(curIp);
            restore(results, s, index + 1, curIp, curIpAddress, n);
            curIpAddress.remove(curIpAddress.size() - 1);
            curIp = curIpAddress.get(curIpAddress.size() - 1);
        }
    }

    public static boolean stringWithPrefixZero(String str) {
        // TODO: here, whether there's a not in front
        return str.startsWith("0") && str.length() > 1;
    }
}
