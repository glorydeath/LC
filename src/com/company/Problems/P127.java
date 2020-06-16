package com.company.Problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 127. Word Ladder
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class P127 {

    class QueueEle{
        String word;
        Integer length;

        public QueueEle(String word, Integer length) {
            this.word = word;
            this.length = length;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<QueueEle> queue = new LinkedList();
        wordList.add(beginWord);
        int n = wordList.size();
        boolean[] visited = new boolean[n];
        queue.offer(new QueueEle(beginWord, 1));
        visited[n-1] = true;
        while(!queue.isEmpty()) {
            QueueEle ele = queue.poll();
            String curWord = ele.word;
            int length = ele.length;
            if (curWord.compareTo(endWord) == 0) {
                return length;
            }
            for(int i=0; i<n; i++) {
                if (!visited[i] && canTransform(curWord, wordList.get(i))) {
                    queue.offer(new QueueEle(wordList.get(i), length + 1));
                    visited[i] = true;
                }
            }
        }
        return -1;
    }

    boolean canTransform(String word1, String word2) {
        int differs = 0;
        for(int i=0; i<word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                differs++;
            }
        }
        return (differs == 1);
    }
}
