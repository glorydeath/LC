package com.company.Problems;

import java.util.List;

/**
 * 524. Longest Word in Dictionary through Deleting
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 *
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * Output:
 * "apple"
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * Output:
 * "a"
 * Note:
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 */
public class P524 {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String str : d) {
            if (str.length() < longest.length() || str.equals(longest) || (str.length() == longest.length() && str.compareTo(longest) >= 0)) {
                continue;
            }
            if (canDelete(s, str)) {
                longest = str;
            }
        }
        return longest;
    }

    public boolean canDelete(String s, String str) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < str.length()) {
            if (s.charAt(i) == str.charAt(j)) {
                j++;
            }
            i++;
        }
        return (j == str.length());
    }
}
