package com.company.Problems;

import java.util.Random;

/**
 * 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

// TODO: wrong answer
// [3,2,1,5,6,4]
// 2
public class P215 {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n-k;
        if (n == 0) {
            return 0;
        }
        int left = 0;
        int right = n-1;
        while(true) {
            int p = partition(nums, left, right);
            if (p < target) {
                left = p + 1;
            } else if (p > target) {
                right = p - 1;
            } else {
                return nums[p];
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int m = (left + right) / 2;
        int pivot = nums[left];
        int i = left; int j = right;
        while (i < j) {
            while (nums[i] <= pivot) i++;
            while (nums[j] >= pivot) j--;
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        int t = nums[j];
        nums[j] = nums[m];
        nums[m] = t;
        return j;
    }

}
