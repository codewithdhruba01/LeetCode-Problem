package problems.topics.arrays.Contains_Duplicate;

import java.util.HashSet;

/**
 * 217. Contains Duplicate
 * 
 * Approach: HashSet
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store numbers we have already seen
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            // If the set already contains the number, we found a duplicate
            if (set.contains(num)) {
                return true;
            }
            // Otherwise, add the number to the set
            set.add(num);
        }

        // If no duplicates are found after checking all numbers
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 1, 2, 3, 1 };
        System.out.println("Test Case 1 [1,2,3,1]: " + solution.containsDuplicate(nums1)); // Expected: true

        // Test Case 2
        int[] nums2 = { 1, 2, 3, 4 };
        System.out.println("Test Case 2 [1,2,3,4]: " + solution.containsDuplicate(nums2)); // Expected: false

        // Test Case 3
        int[] nums3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        System.out.println("Test Case 3 [1,1,1,3,3,4,3,2,4,2]: " + solution.containsDuplicate(nums3)); // Expected: true
    }
}
