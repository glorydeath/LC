package com.company.Problems;

import java.util.Arrays;
import java.util.Random;

/**
 * 384. Shuffle an Array
 *
 * Shuffle a set of numbers without duplicates.
 *
 * Example:
 *
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 *
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 *
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
public class P384 {

    int[] originalConf;
    int[] curConf;
    Random rand;

    public P384(int[] nums) {
        originalConf = Arrays.copyOf(nums, nums.length);
        curConf = Arrays.copyOf(nums, nums.length);
        rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        curConf = Arrays.copyOf(originalConf, originalConf.length);
        return curConf;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = curConf.length;
        int[] newArr = new int[n];
        int lastIndex = n-1;

        for (int i=0; i<n; i++) {
            int randIndex = rand.nextInt(lastIndex + 1);
            newArr[i] = curConf[randIndex];
            int tmp = curConf[randIndex];
            curConf[randIndex] = curConf[lastIndex];
            curConf[lastIndex] = tmp;
            lastIndex--;
        }
        curConf = newArr;
        return newArr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */