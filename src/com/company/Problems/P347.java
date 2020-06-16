package com.company.Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. Top K Frequent Elements
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 */
public class P347 {
    public static int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] bucket = new List[n+1];
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for(int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        for(Integer key : frequency.keySet()) {
            int value = frequency.get(key);
            if (bucket[value] == null) {
                bucket[value] = new ArrayList<Integer>();
            }
            bucket[value].add(key);
        }
        int[] res = new int[k];
        for(int i = n, j = 0; i> 0; i--) {
            if(bucket[i] != null) {
                for(Integer value: bucket[i]) {
                    res[j++] = value;
                }
            }
            if (j >= k) {
                break;
            }
        }
        return res;
    }
}
