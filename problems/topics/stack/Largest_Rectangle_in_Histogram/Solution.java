import java.util.*;

/**
 * 84. Largest Rectangle in Histogram
 * 
 * Approach: Monotonic Stack (Optimal O(N) single pass)
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        // Iterate through heights, including a virtual zero height at index 'n'
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];

            // Maintain a monotonic increasing stack
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;

                if (stack.isEmpty()) {
                    // All bars to the left were taller or equal
                    width = i;
                } else {
                    // Width is current index - left boundary index - 1
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("Test Case 1 Output: " + solution.largestRectangleArea(heights1)); 
        // Expected: 10

        // Test Case 2
        int[] heights2 = {2, 4};
        System.out.println("Test Case 2 Output: " + solution.largestRectangleArea(heights2)); 
        // Expected: 4

        // Test Case 3: Decreasing heights
        int[] heights3 = {5, 4, 3, 2, 1};
        System.out.println("Test Case 3 Output: " + solution.largestRectangleArea(heights3)); 
        // Expected: 9 (3x3 at the middle or similar based on geometry)
    }
}
