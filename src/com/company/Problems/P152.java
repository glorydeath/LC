package com.company.Problems;

/**
 * 152. Maximum Product Subarray
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class P152 {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int localMax = nums[0];
        int localMin = nums[0];
        int max = localMax;
        for(int i=1; i<n; i++) {
            int maxCopy = localMax;
            localMax = Math.max(Math.max(nums[i] * maxCopy, nums[i]), nums[i] * localMin);
            localMin = Math.min(Math.min(nums[i] * maxCopy, nums[i]), nums[i] * localMin);
            if (localMax > max ) {
                max = localMax;
            }
        }
        return max;
    }
}
