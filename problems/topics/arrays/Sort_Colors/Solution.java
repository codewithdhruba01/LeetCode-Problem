package problems.topics.arrays.Sort_Colors;

import java.util.Arrays;

/**
 * 75. Sort Colors
 * 
 * Approach: Dutch National Flag Algorithm (Three-Pointer)
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // If it's a 0, move it to the low section
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // If it's a 1, just move past it
                mid++;
            } else { // nums[mid] == 2
                // If it's a 2, move it to the high section
                swap(nums, mid, high);
                // Note: We don't increment mid here because the
                // element swapped from high needs to be evaluated.
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 2, 0, 2, 1, 1, 0 };
        solution.sortColors(nums1);
        System.out.println("Test Case 1: " + Arrays.toString(nums1));
        // Expected: [0, 0, 1, 1, 2, 2]

        // Test Case 2
        int[] nums2 = { 2, 0, 1 };
        solution.sortColors(nums2);
        System.out.println("Test Case 2: " + Arrays.toString(nums2));
        // Expected: [0, 1, 2]
    }
}
