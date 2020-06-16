package com.company.Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.
 *
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class P93 {
    public static List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> results = new ArrayList<String>();
        List<String> curResults = new ArrayList<String>();
        if (n == 0) {
            return results;
        }
        divideIpAddr("", results, curResults, 0, s, n);
        return results;
    }


    public static void divideIpAddr(String curIp, List<String> results, List<String> curResults, int index, String s, int n) {
        if (stringWithPrefixZero(curIp)) {
            return;
        }
        if (index >= n) {
            if (!curIp.isEmpty()) {
                curResults.add(curIp);
            }
            if (curResults.size() == 4) {
                results.add(String.join(".", curResults));
            }
            curResults.remove(curResults.size() - 1);
            return;
        }
        if (curResults.size() >= 4 && index < n) {
            return;
        }
        String newIp = curIp + s.charAt(index);
        if (Integer.valueOf(newIp) <= 255) {
            divideIpAddr(newIp, results, curResults, index+1, s, n);
        }
        if (curResults.size() < 4 && !curIp.isEmpty() && !stringWithPrefixZero(curIp)) {
            curResults.add(curIp);
            newIp = String.valueOf(s.charAt(index));
            divideIpAddr(newIp, results, curResults, index+1, s, n);
            curResults.remove(curResults.size() - 1);
        }
    }

    public static boolean stringWithPrefixZero(String s) {
        if (s.startsWith("0") && s.length() > 1) {
            return true;
        }
        return false;
    }
}
