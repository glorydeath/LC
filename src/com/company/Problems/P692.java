package com.company.Problems;

import java.util.*;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */

public class P692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> results = new ArrayList<String>();
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        for (String word : words) {
            if (countMap.containsKey(word)) {
                countMap.put(word, countMap.get(word) + 1);
            } else {
                countMap.put(word, 0);
            }
        }
        int size = words.length;
        PriorityQueue<QueueEle> queue = new PriorityQueue<QueueEle>(size, queueEleComparator);
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            queue.add(new QueueEle(entry.getKey(), entry.getValue()));
        }

        for (int i=0; i<k; i++) {
            QueueEle ele = queue.poll();
            results.add(ele.word);
        }


        return results;
    }

    public static Comparator<QueueEle> queueEleComparator = new Comparator<QueueEle>() {
        @Override
        public int compare(QueueEle o1, QueueEle o2) {
            if (o1.count != o2.count) {
                return o2.count - o1.count;
            }
            return o1.word.compareTo(o2.word);
        }
    };

    class QueueEle {
        String word;
        int count;

        public QueueEle(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
