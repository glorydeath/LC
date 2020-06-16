package com.company.Problems;

public class P204 {
    public static int countPrimes(int n) {
        int maxTarget = (int)Math.sqrt(n);
        boolean[] nums = new boolean[n];
        for(int i=2; i<=maxTarget; i++) {
            int sum = i + i;
            while (sum < n) {
                nums[sum] = true;
                sum = sum + i;
            }
        }
        int count = 0;
        for(int i=1; i<n; i++) {
            if (!nums[i]) {
                count++;
            }
        }
        return count;
    }
}
