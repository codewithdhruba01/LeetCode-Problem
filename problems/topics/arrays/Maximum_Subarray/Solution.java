class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Test Case 1: " + (solution.maxSubArray(nums1) == 6 ? "Passed" : "Failed")); // Expected: 6

        // Test Case 2
        int[] nums2 = {1};
        System.out.println("Test Case 2: " + (solution.maxSubArray(nums2) == 1 ? "Passed" : "Failed")); // Expected: 1

        // Test Case 3
        int[] nums3 = {5,4,-1,7,8};
        System.out.println("Test Case 3: " + (solution.maxSubArray(nums3) == 23 ? "Passed" : "Failed")); // Expected: 23
    }
}
