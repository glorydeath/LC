package com.company.Problems;

import java.util.*;

public class P210 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> table = new ArrayList<Set<Integer>>();
        int n = prerequisites.length;
        int[] results = new int[numCourses];
        List<Integer> in = new ArrayList<Integer>();
        for(int i=0; i<numCourses; i++) {
            table.add(new HashSet<Integer>());
            in.add(0);
        }
        for (int i=0; i<n; i++) {
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            table.get(start).add(end);
            in.set(end, in.get(end) + 1);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++) {
            if (in.get(i) == 0) {
                queue.add(i);
            }
        }
        int index = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            results[index++] = course;
            Set<Integer> set = table.get(course);
            for(Integer c : set) {
                in.set(c, in.get(c) - 1);
                if (in.get(c) == 0) {
                    queue.add(c);
                }
            }
        }
        for(int i=0; i<in.size(); i++) {
            if (in.get(i) > 0) {
                return new int[] {};
            }
        }
        return results;
    }
}
