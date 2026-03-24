/**
 * 169. Majority Element
 * 
 * Approach: Boyer-Moore Voting Algorithm
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            // When count becomes 0, we pick a new candidate
            if (count == 0) {
                candidate = num;
            }

            // Voting mechanism
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {3, 2, 3};
        System.out.println("Test Case 1 Output: " + solution.majorityElement(nums1)); // Expected: 3

        // Test Case 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Test Case 2 Output: " + solution.majorityElement(nums2)); // Expected: 2
    }
}
