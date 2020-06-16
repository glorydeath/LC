package com.company.Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 451. Sort Characters By Frequency
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class P451 {
    public String frequencySort(String s) {
        int n = s.length();
        List<Character>[] bucket = new List[n+1];
        Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        for (Character c : freqMap.keySet()) {
            int value = freqMap.get(c);
            if (bucket[value] == null) {
                bucket[value] = new ArrayList<Character>();
            }
            bucket[value].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=n; i>0; i--) {
            if (bucket[i] != null) {
                for (Character c : bucket[i]) {
                    for (int j=0; j<i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
