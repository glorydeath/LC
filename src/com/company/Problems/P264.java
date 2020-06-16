package com.company.Problems;

/**
 * 264. Ugly Number II
 *
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */
public class P264 {
    public static int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int count = 1;
        int countFor2 = 0;
        int countFor3 = 0;
        int countFor5 = 0;
        for(int i=1; i<n; i++) {
            int numFor2 = 2 * uglyNums[countFor2];
            int numFor3 = 3 * uglyNums[countFor3];
            int numFor5 = 5 * uglyNums[countFor5];
            int minUgly = Math.min(numFor2, Math.min(numFor3, numFor5));
            uglyNums[i] = minUgly;
            if (minUgly == numFor2) {
                countFor2++;
            }
            if (minUgly == numFor3) {
                countFor3++;
            }
            if (minUgly == numFor5) {
                countFor5++;
            }

        }
        return uglyNums[n-1];

    }
}
