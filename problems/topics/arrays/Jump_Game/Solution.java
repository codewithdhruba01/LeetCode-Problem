package problems.topics.arrays.Jump_Game;

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            // If current index is not reachable, then we can't move forward
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);

            // Optimization: If we can already reach the end, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 2, 3, 1, 1, 4 };
        System.out.println("Test Case 1: " + (solution.canJump(nums1) == true ? "Passed" : "Failed")); // Expected: true

        // Test Case 2
        int[] nums2 = { 3, 2, 1, 0, 4 };
        System.out.println("Test Case 2: " + (solution.canJump(nums2) == false ? "Passed" : "Failed")); // Expected:
                                                                                                        // false

        // Test Case 3: Single element
        int[] nums3 = { 0 };
        System.out.println("Test Case 3: " + (solution.canJump(nums3) == true ? "Passed" : "Failed")); // Expected: true
    }
}
