/**
 * 540. Single Element in a Sorted Array
 * 
 * Approach: Binary Search on Index Pairs
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            // Property: Before the single element, pairs start at even indices.
            // If mid is odd, we decrement it to look at the start of the potential pair.
            if (mid % 2 == 1) {
                mid--;
            }

            // Check if the pair starting at 'mid' is correct
            if (nums[mid] == nums[mid + 1]) {
                // If pair is correct, single element is on the right side
                left = mid + 2;
            } else {
                // If pair is broken, single element is on this side (including mid)
                right = mid;
            }
        }

        // 'left' will point to the single element
        return nums[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("Test Case 1 Output: " + solution.singleNonDuplicate(nums1)); 
        // Expected: 2

        // Test Case 2
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println("Test Case 2 Output: " + solution.singleNonDuplicate(nums2)); 
        // Expected: 10
    }
}
