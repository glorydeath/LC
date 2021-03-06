package com.company.Problems;

/**
 * 213. House Robber II
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */
public class P213 {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] robSum = new int[n];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        robSum[0] = nums[0];
        for(int i=1; i<n-1; i++) {
            robSum[i] = Math.max(robSum[i-1], (i==1?0: robSum[i-2]) + nums[i]);
        }
        int maxSum1 = robSum[n-2];
        robSum[1] = nums[1];
        for(int i=2; i<n; i++) {
            robSum[i] = Math.max(robSum[i-1], (i==2?0: robSum[i-2]) + nums[i]);
        }
        int maxSum2 = robSum[n-1];
        return Math.max(maxSum1, maxSum2);
    }
}
