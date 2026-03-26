/**
 * 2481. Minimum Cuts to Divide a Circle
 * 
 * Approach: Mathematical Parity
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
class Solution {
    public int numberOfCuts(int n) {
        // If we only need 1 slice, we already have it.
        if (n == 1) {
            return 0;
        }

        // If n is even, each diameter cut through the center creates 2 slices.
        // So n / 2 full-line cuts will result in n slices.
        if (n % 2 == 0) {
            return n / 2;
        } 
        // If n is odd, we need to make n radius-based cuts from center to edge.
        else {
            return n;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Test Case n=4: " + solution.numberOfCuts(4)); // Expected: 2

        // Test Case 2
        System.out.println("Test Case n=3: " + solution.numberOfCuts(3)); // Expected: 3

        // Test Case 3
        System.out.println("Test Case n=1: " + solution.numberOfCuts(1)); // Expected: 0
    }
}
