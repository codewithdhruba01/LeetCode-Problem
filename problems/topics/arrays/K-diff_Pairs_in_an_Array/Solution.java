import java.util.*;

/**
 * 532. K-diff Pairs in an Array
 * 
 * Approach: HashMap Frequency tracking
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int num : map.keySet()) {
            if (k == 0) {
                // For difference 0, we need at least two instances of the same number
                if (map.get(num) > 1) {
                    count++;
                }
            } else {
                // Check for num + k to avoid double counting (since we iterate keys)
                if (map.containsKey(num + k)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 3, 1, 4, 1, 5 };
        int k1 = 2;
        System.out.println("Test Case 1 Output: " + solution.findPairs(nums1, k1)); // Expected: 2

        // Test Case 2
        int[] nums2 = { 1, 2, 3, 4, 5 };
        int k2 = 1;
        System.out.println("Test Case 2 Output: " + solution.findPairs(nums2, k2)); // Expected: 4

        // Test Case 3
        int[] nums3 = { 1, 3, 1, 5, 4 };
        int k3 = 0;
        System.out.println("Test Case 3 Output: " + solution.findPairs(nums3, k3)); // Expected: 1
    }
}
