package problems.topics.arrays.Remove_Duplicates_from_Sorted_Array;

import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 * 
 * Approach: Two Pointers
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Pointer for the last unique element found
        int i = 0;
        
        // Iterate through the array starting from the second element
        for (int j = 1; j < nums.length; j++) {
            // If the current element is different from the last unique element
            if (nums[j] != nums[i]) {
                i++; // Move to the next position for a unique element
                nums[i] = nums[j]; // Update that position with the new unique element
            }
        }
        
        // Return the count of unique elements (index + 1)
        return i + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Test Case 1: k=" + k1 + ", Array=" + Arrays.toString(Arrays.copyOf(nums1, k1)));
        // Expected: k=2, Array=[1, 2]

        // Test Case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("Test Case 2: k=" + k2 + ", Array=" + Arrays.toString(Arrays.copyOf(nums2, k2)));
        // Expected: k=5, Array=[0, 1, 2, 3, 4]
    }
}
