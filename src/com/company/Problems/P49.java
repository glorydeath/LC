package com.company.Problems;

import java.util.*;

public class P49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i=0; i<strs.length; i++) {
            String str = strs[i];
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            if (!map.containsKey(sortedStr)) {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(sortedStr, list);
            } else {
                map.get(sortedStr).add(strs[i]);
            }
        }
        results.addAll(map.values());
        return results;
    }
}
