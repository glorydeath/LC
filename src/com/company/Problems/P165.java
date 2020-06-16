package com.company.Problems;

public class P165 {
    public static int compareVersion(String version1, String version2) {
        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");
        int n = v1Arr.length;
        int m = v2Arr.length;
        int i = 0;
        while(i < n && i < m) {
            int v1 = Integer.valueOf(v1Arr[i]);
            int v2 = Integer.valueOf(v2Arr[i]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
            i++;
        }
        while(i < n) {
            if (Integer.valueOf(v1Arr[i]) > 0) {
                return 1;
            }
            i++;
        }
        while (i < m) {
            if (Integer.valueOf(v2Arr[i]) > 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }
}
