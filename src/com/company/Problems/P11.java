package com.company.Problems;

/**
 * 11. Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines
 * are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class P11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;

        int square = 0;
        while(left < right) {
            int tmpSquare = Math.min(height[left], height[right]) * (right - left);
            if (tmpSquare > square) {
                square = tmpSquare;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return square;
    }
}
