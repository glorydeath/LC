package com.company.Problems;

public class P8 {
    public static int myAtoi(String str) {
        long result = 0;
        int flag = 1;
        int n = str.length();
        if (n <= 0) {
            return 0;
        }
        int i = 0;
        while(i < n && str.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        char firstCh = str.charAt(i);
        i++;
        if (firstCh == '-') {
            flag = -1;
        } else if (isDigit(firstCh)) {
            result = firstCh - '0';
        } else if (firstCh == '+') {

        } else {
            return 0;
        }
        while(i < n && isDigit(str.charAt(i))) {
            int newInt = str.charAt(i) - '0';
            if (result < 0) {
                result = result * 10 - newInt;
            } else {
                result = result * 10 + newInt;
            }
            i++;
            if (result != 0 && flag < 0) {
                result = result * flag;
                flag = 1;
            }
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)result;

    }

    public static boolean isDigit(char ch) {
        return ch <= '9' && ch >= '0';
    }
}