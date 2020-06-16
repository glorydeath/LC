package com.company.Problems;

/**
 * 42. Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class P42 {
    public static int trap(int[] height) {
        int n = height.length;
        int[] leftHeight = new int[n];
        int[] rightHeight = new int[n];
        leftHeight[0] = height[0];
        for (int i=1; i<n; i++) {
            leftHeight[i] = Math.max(leftHeight[i-1], height[i]);
        }
        rightHeight[n-1] = height[n-1];
        for (int i=n-2; i>=0; i--) {
            rightHeight[i] = Math.max(rightHeight[i+1], height[i]);
        }
        int trapArea = 0;
        for(int i=0; i<n; i++) {
            trapArea += Math.min(leftHeight[i], rightHeight[i]) - height[i];
        }
        return trapArea;
    }
}
