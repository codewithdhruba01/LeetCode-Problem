import java.util.Arrays;

/**
 * 31. Next Permutation
 * 
 * Approach: O(N) Peak-to-Swap Algorithm
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find the rightmost index 'i' where nums[i] < nums[i+1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If we found such an index, find the successor of nums[i] in the suffix
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Step 3: Swap nums[i] and nums[j]
            swap(nums, i, j);
        }

        // Step 4: Reverse the suffix starting at i + 1 to get the smallest possible order
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 2, 3};
        solution.nextPermutation(nums1);
        System.out.println("Test Case 1 Output: " + Arrays.toString(nums1)); 
        // Expected: [1, 3, 2]

        // Test Case 2
        int[] nums2 = {3, 2, 1};
        solution.nextPermutation(nums2);
        System.out.println("Test Case 2 Output: " + Arrays.toString(nums2)); 
        // Expected: [1, 2, 3]

        // Test Case 3
        int[] nums3 = {1, 1, 5};
        solution.nextPermutation(nums3);
        System.out.println("Test Case 3 Output: " + Arrays.toString(nums3)); 
        // Expected: [1, 5, 1]
    }
}
