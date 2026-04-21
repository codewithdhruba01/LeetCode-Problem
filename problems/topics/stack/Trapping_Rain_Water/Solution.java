import java.util.*;

/**
 * 42. Trapping Rain Water
 * 
 * Approaches:
 * 1. Two Pointers (Optimal) - Time: O(N), Space: O(1)
 * 2. Monotonic Stack - Time: O(N), Space: O(N)
 */

class Solution {
    
    // Approach 1: Two Pointers (As shown in screenshot)
    // Most optimized approach for Space
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int l = 0, r = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= leftMax) {
                    leftMax = height[l];
                } else {
                    water += leftMax - height[l];
                }
                l++;
            } else {
                if (height[r] >= rightMax) {
                    rightMax = height[r];
                } else {
                    water += rightMax - height[r];
                }
                r--;
            }
        }
        return water;
    }

    // Approach 2: Monotonic Stack
    // Horizontal calculation approach
    public int trapStack(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                water += distance * boundedHeight;
            }
            stack.push(i);
        }
        return water;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Test Case 1 (Two Pointers): " + solution.trap(height1)); // Expected: 6
        System.out.println("Test Case 1 (Stack): " + solution.trapStack(height1));   // Expected: 6

        // Test Case 2
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("\nTest Case 2 (Two Pointers): " + solution.trap(height2)); // Expected: 9
        System.out.println("Test Case 2 (Stack): " + solution.trapStack(height2));   // Expected: 9
    }
}
