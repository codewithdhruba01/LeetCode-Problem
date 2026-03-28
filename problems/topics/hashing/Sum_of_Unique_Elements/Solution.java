import java.util.*;

/**
 * 1748. Sum of Unique Elements
 * 
 * Approach: Frequency Counting (Hashing)
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class Solution {
    public int sumOfUnique(int[] nums) {
        // Map to store frequency of each number
        Map<Integer, Integer> map = new HashMap<>();

        // Fill the frequency map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        // Iterate through map keys and add those with frequency 1
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                sum += num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 2, 3, 2};
        System.out.println("Test Case 1 Output: " + solution.sumOfUnique(nums1)); 
        // Expected: 4

        // Test Case 2
        int[] nums2 = {1, 1, 1, 1, 1};
        System.out.println("Test Case 2 Output: " + solution.sumOfUnique(nums2)); 
        // Expected: 0

        // Test Case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 3 Output: " + solution.sumOfUnique(nums3)); 
        // Expected: 15
    }
}
