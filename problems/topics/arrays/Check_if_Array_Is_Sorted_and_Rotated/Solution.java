package problems.topics.arrays.Check_if_Array_Is_Sorted_and_Rotated;

/**
 * 1752. Check if Array Is Sorted and Rotated
 * 
 * Approach: Single Pass circular check
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Compare current element with the next one circularly
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        // If the array is sorted and rotated, there can be at most one "drop"
        return count <= 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 3, 4, 5, 1, 2 };
        System.out.println("Test Case 1 ([3,4,5,1,2]): " + solution.check(nums1)); // Expected: true

        // Test Case 2
        int[] nums2 = { 2, 1, 3, 4 };
        System.out.println("Test Case 2 ([2,1,3,4]): " + solution.check(nums2)); // Expected: false

        // Test Case 3
        int[] nums3 = { 1, 2, 3 };
        System.out.println("Test Case 3 ([1,2,3]): " + solution.check(nums3)); // Expected: true
    }
}
