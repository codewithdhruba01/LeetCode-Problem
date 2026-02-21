/**
 * 231. Power of Two
 * 
 * Approach: Bit Manipulation
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        // A power of two must be positive and have only one bit set to 1.
        // (n & (n - 1)) == 0 is a trick to check if only one bit is set.
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Cases
        System.out.println("n = 1: " + solution.isPowerOfTwo(1)); // true
        System.out.println("n = 16: " + solution.isPowerOfTwo(16)); // true
        System.out.println("n = 3: " + solution.isPowerOfTwo(3)); // false
        System.out.println("n = 0: " + solution.isPowerOfTwo(0)); // false
        System.out.println("n = -16: " + solution.isPowerOfTwo(-16)); // false
    }
}
