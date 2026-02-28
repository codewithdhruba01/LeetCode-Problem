/**
 * 202. Happy Number
 * 
 * Approach: Floyd's Cycle-Finding Algorithm (Slow and Fast Pointers)
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        // Continue until fast reaches 1 (happy) or fast meets slow (cycle)
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    /**
     * Helper to calculate the sum of the squares of the digits of n.
     */
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Input: 19, Is Happy: " + solution.isHappy(19)); // Expected: true

        // Test Case 2
        System.out.println("Input: 2, Is Happy: " + solution.isHappy(2)); // Expected: false

        // Test Case 3
        System.out.println("Input: 7, Is Happy: " + solution.isHappy(7)); // Expected: true (7 -> 49 -> 97 -> 130 -> 10
                                                                          // -> 1)
    }
}
