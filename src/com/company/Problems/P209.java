package com.company.Problems;

public class P209 {
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int res = n + 1;
        int sum = 0;
        int j = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
            while (sum >= s && j < i) {
                res = Math.min(res, i-j+1);
                sum -= nums[j];
                j++;
            }
        }
        if (res == n+1) {
            return 0;
        }
        return res;
    }
}
