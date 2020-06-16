package com.company.Problems;

import java.util.HashSet;
import java.util.Set;

public class P202 {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        int nextN = n;
        while (true) {
            nextN = calculateDigitsSquares(nextN);
            if (nextN == 1) {
                return true;
            }
            if (set.contains(nextN)) {
                return false;
            }
            set.add(nextN);
        }
    }

    public static int calculateDigitsSquares(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
