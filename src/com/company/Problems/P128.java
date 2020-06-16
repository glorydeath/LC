package com.company.Problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

public class P128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        while(!set.isEmpty()) {
            int num = getNext(set);
            int ori = num;
            int left = 0;
            int right = 0;
            set.remove(num);
            while(set.contains(num+1)) {
                right++;
                set.remove(num + 1);
                num = num + 1;
            }
            num = ori;
            while(set.contains(num-1)) {
                left++;
                set.remove(num - 1);
                num = num - 1;
            }
            res = Math.max(res, left + right + 1);
        }
        return res;
    }

    public int getNext(Set<Integer> set) {
        for(Integer num : set) {
            return num;
        }
        return 0;
    }
}
