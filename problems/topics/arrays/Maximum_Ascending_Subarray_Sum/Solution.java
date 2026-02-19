package problems.topics.arrays.Maximum_Ascending_Subarray_Sum;

class Solution {
    public int maxAscendingSum(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 10, 20, 30, 5, 10, 50 };
        System.out.println("Test Case 1: " + (solution.maxAscendingSum(nums1) == 65 ? "Passed" : "Failed")); // Expected:
                                                                                                             // 65

        // Test Case 2
        int[] nums2 = { 10, 20, 30, 40, 50 };
        System.out.println("Test Case 2: " + (solution.maxAscendingSum(nums2) == 150 ? "Passed" : "Failed")); // Expected:
                                                                                                              // 150

        // Test Case 3
        int[] nums3 = { 12, 17, 15, 13, 10, 11, 12 };
        System.out.println("Test Case 3: " + (solution.maxAscendingSum(nums3) == 33 ? "Passed" : "Failed")); // Expected:
                                                                                                             // 33
    }
}
