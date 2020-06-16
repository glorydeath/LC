package com.company.Problems;

// TODO: find better solution
/**
 * 43. Multiply Strings
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class P43 {
    public static void debug() {
        long sum = 0;
        long num = 123456789;
        for(int i=1; i<=9; i++) {
            long r = num * i;
            for (int j=1; j<i; j++) {
                r = r * 10;
            }
            System.out.println(r);
            sum = sum + r;
            System.out.println(sum);
            System.out.println();
        }
    }

    public static String multiply(String num1, String num2) {
//        debug();
        if (num1.length() == 0 || num2.length() == 0 || num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num2.length();
        int trailingZeros = 0;
        String result = "0";
        for(int i=m-1; i>=0; i--) {
            String tmpResult = multiplySingleDigit(num1, num2.charAt(i) - '0', trailingZeros);
            System.out.println(tmpResult);
            result = add(result, tmpResult);
            System.out.println(result);
            System.out.println();
            trailingZeros++;
        }
        return result;
    }

    public static String multiplySingleDigit(String num1, int num2, int trailingZeros) {
        if (num1.length() == 0) {
            return "0";
        }
        int n = num1.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=n-1; i>=0; i--) {
            int r = (num1.charAt(i) - '0') * num2 + carry;
            carry = r / 10;
            sb.insert(0, r % 10);
        }
        while (carry > 0) {
            sb.insert(0, carry % 10);
            carry = carry / 10;
        }
        for (int i=0; i<trailingZeros; i++) {
            sb.append(0);
        }
        return sb.toString();
    }

    public static String add(String num1, String num2) {
        if (num1.length() == 0) {
            return num2;
        }
        if (num2.length() == 0) {
            return num1;
        }
        int n = num1.length();
        int m = num2.length();
        int carry = 0;
        int i = n-1;
        int j = m-1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int r = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            carry = r / 10;
            sb.insert(0, r % 10);
            i--;
            j--;
        }
        while (i >= 0) {
            int r = num1.charAt(i) - '0' + carry;
            carry = r / 10;
            sb.insert(0, r % 10);
            i--;
        }
        while (j >= 0) {
            int r = num2.charAt(j) - '0' + carry;
            carry = r / 10;
            sb.insert(0, r % 10);
            j--;
        }
        while (carry > 0) {
            sb.insert(0, carry % 10);
            carry = carry / 10;
        }
        return sb.toString();
    }
}
