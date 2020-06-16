package com.company.Problems;

public class P12 {
    public String intToRoman(int num) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuilder sb = new StringBuilder();
        int n = num;
        int thousand = n / 1000;
        n = n % 1000;
        if (thousand > 0) {
            sb.append(M[thousand]);
        }
        int hundred = n / 100;
        n = n % 100;
        if (hundred > 0) {
            sb.append(C[hundred]);
        }
        int ten = n / 10;
        n = n % 10;
        if (ten > 0) {
            sb.append(X[ten]);
        }
        if (n > 0) {
            sb.append(I[n]);
        }

        return sb.toString();
    }
}
