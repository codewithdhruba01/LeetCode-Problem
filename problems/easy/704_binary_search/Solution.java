/**
 * 704. Binary Search
 * 
 * Approach: Iterative Binary Search
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Use this formula to prevent potential integer overflow
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                // Target must be in the right half
                left = mid + 1;
            } else {
                // Target must be in the left half
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println("Test Case 1 Output: " + solution.search(nums1, target1)); // Expected: 4

        // Test Case 2
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        System.out.println("Test Case 2 Output: " + solution.search(nums2, target2)); // Expected: -1
    }
}
