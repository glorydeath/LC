package com.company.Problems;

import java.util.Arrays;
import java.util.Comparator;

public class P179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numsStr = new String[n];
        for(int i=0; i<n; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=n-1; i>=0; i--) {
            sb.append(numsStr[i]);
        }

        while (sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
