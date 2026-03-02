package problems.topics.arrays.Max_Consecutive_Ones_III;

/**
 * 1004. Max Consecutive Ones III
 * 
 * Approach: Sliding Window
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            // If we encounter a 0, increment the count of zeros in the current window
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If zero count exceeds k, move left pointer to shrink the window
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update maxLen as the window [left, right] is valid (has <= k zeros)
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k1 = 2;
        System.out.println("Test Case 1 Output: " + solution.longestOnes(nums1, k1)); // Expected: 6

        // Test Case 2
        int[] nums2 = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k2 = 3;
        System.out.println("Test Case 2 Output: " + solution.longestOnes(nums2, k2)); // Expected: 10
    }
}
