/**
 * 152. Maximum Product Subarray
 * 
 * Approach: Dynamic Programming (Tracking both Max and Min products)
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // If current number is negative, swap max and min 
            // because multiplying by a negative flips the sign.
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // The new max/min should either start at current or continue previous
            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            // Update global result
            result = Math.max(result, maxSoFar);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Test Case 1 Output: " + solution.maxProduct(nums1)); 
        // Expected: 6

        // Test Case 2
        int[] nums2 = {-2, 0, -1};
        System.out.println("Test Case 2 Output: " + solution.maxProduct(nums2)); 
        // Expected: 0
    }
}
