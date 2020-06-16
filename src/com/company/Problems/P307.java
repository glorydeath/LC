package com.company.Problems;

import java.util.ArrayList;
import java.util.List;

// todo: use 树状数组
public class P307 {
    List<Integer> sumBefore;

    int n;

    public P307(int[] nums) {
        n = nums.length;
        sumBefore = new ArrayList<Integer>();
        sumBefore.add(nums[0]);
        for(int i=1; i<n; i++) {
            sumBefore.add(nums[i] + sumBefore.get(i-1));
        }
    }

    public void update(int i, int val) {
        int oldVal;
        if (i != 0) {
            oldVal = sumBefore.get(i) - sumBefore.get(i-1);
        } else {
            oldVal = sumBefore.get(i);
        }
        int difference = val - oldVal;
        for(int j=i; j<n; j++) {
            int newVal = sumBefore.get(j) + difference;
            sumBefore.set(j, newVal);
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sumBefore.get(j);
        } else {
            return sumBefore.get(j) - sumBefore.get(i-1);
        }
    }
}
