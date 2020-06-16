package com.company.Problems;

/**
 * 84. Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class P84 {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return heights[0];
        }
        int[] leftExpand = new int[n];
        int[] rightExpand = new int[n];
        rightExpand[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            if (heights[i] > heights[i+1]) {
                rightExpand[i] = 1;
            } else {
                int j = i + 1;
                while (j < n && heights[j] >= heights[i]) {
                    j += rightExpand[j];
                }
                rightExpand[i] = j - i;
            }
        }

        leftExpand[0] = 1;
        for (int i=1; i<n; i++) {
            if (heights[i] > heights[i-1]) {
                leftExpand[i] = 1;
            } else {
                int j = i-1;
                while (j >= 0 && heights[j] >= heights[i]) {
                    j -= leftExpand[j];
                }
                leftExpand[i] = i - j;
            }
        }

        int maxArea = 0;
        for(int i=0; i<n; i++) {
            maxArea = Math.max((heights[i] * (leftExpand[i] + rightExpand[i] - 1)), maxArea);
        }
        return maxArea;
    }
}
