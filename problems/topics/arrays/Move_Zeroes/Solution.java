import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos] = num;
                insertPos++;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 0, 1, 0, 3, 12 };
        solution.moveZeroes(nums1);
        System.out
                .println("Test Case 1: " + (Arrays.equals(nums1, new int[] { 1, 3, 12, 0, 0 }) ? "Passed" : "Failed")); // Expected:
                                                                                                                        // [1,
                                                                                                                        // 3,
                                                                                                                        // 12,
                                                                                                                        // 0,
                                                                                                                        // 0]

        // Test Case 2
        int[] nums2 = { 0 };
        solution.moveZeroes(nums2);
        System.out.println("Test Case 2: " + (Arrays.equals(nums2, new int[] { 0 }) ? "Passed" : "Failed")); // Expected:
                                                                                                             // [0]
    }
}
