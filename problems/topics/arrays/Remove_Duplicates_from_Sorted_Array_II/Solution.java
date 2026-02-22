package problems.topics.arrays.Remove_Duplicates_from_Sorted_Array_II;

import java.util.Arrays;

/**
 * 80. Remove Duplicates from Sorted Array II
 * 
 * Approach: Two Pointers (Overwrite)
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        // If array has 0, 1, or 2 elements, no duplicates can exceed the limit of 2
        if (nums == null || nums.length <= 2) {
            return nums == null ? 0 : nums.length;
        }

        // 'index' is where we will place the next valid element
        // The first two elements are always kept as is
        int index = 2;

        for (int i = 2; i < nums.length; i++) {
            // If the current element is different from the element
            // placed two positions ago, it's valid (appears at most twice so far)
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index; // New length of the array
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 1, 1, 1, 2, 2, 3 };
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Test Case 1: k=" + k1 + ", Array=" + Arrays.toString(Arrays.copyOf(nums1, k1)));
        // Expected: k=5, Array=[1, 1, 2, 2, 3]

        // Test Case 2
        int[] nums2 = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("Test Case 2: k=" + k2 + ", Array=" + Arrays.toString(Arrays.copyOf(nums2, k2)));
        // Expected: k=7, Array=[0, 0, 1, 1, 2, 3, 3]
    }
}
