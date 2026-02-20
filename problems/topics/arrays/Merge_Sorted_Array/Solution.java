package problems.topics.arrays.Merge_Sorted_Array;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // Pointer for last element in nums1's valid section
        int j = n - 1;       // Pointer for last element in nums2
        int k = m + n - 1;   // Pointer for last position in nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // Copy any remaining elements from nums2 into nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
        // No need to copy remaining nums1 elements as they're already in place
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println("Test Case 1: " + (Arrays.equals(nums1, new int[]{1, 2, 2, 3, 5, 6}) ? "Passed" : "Failed")); // Expected: [1,2,2,3,5,6]

        // Test Case 2
        int[] nums2 = {1};
        solution.merge(nums2, 1, new int[]{}, 0);
        System.out.println("Test Case 2: " + (Arrays.equals(nums2, new int[]{1}) ? "Passed" : "Failed")); // Expected: [1]

        // Test Case 3
        int[] nums3 = {0};
        solution.merge(nums3, 0, new int[]{1}, 1);
        System.out.println("Test Case 3: " + (Arrays.equals(nums3, new int[]{1}) ? "Passed" : "Failed")); // Expected: [1]
    }
}
