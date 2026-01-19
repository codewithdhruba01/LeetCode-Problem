import java.util.*;

/**
 * LeetCode Problem: Two Sum
 *
 * Problem Number: 1
 * Problem Name: Two Sum
 * Difficulty: Easy
 * Topics: Array, Hash Table
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Approach: Use hash map to store seen numbers and check for complement
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}

// Test cases
public class TwoSumTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        int[] expected1 = { 0, 1 };
        assert Arrays.equals(result1, expected1)
                : "Test 1 failed: expected " + Arrays.toString(expected1) + ", got " + Arrays.toString(result1);

        // Test case 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        int[] expected2 = { 1, 2 };
        assert Arrays.equals(result2, expected2)
                : "Test 2 failed: expected " + Arrays.toString(expected2) + ", got " + Arrays.toString(result2);

        // Test case 3
        int[] nums3 = { 3, 3 };
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        int[] expected3 = { 0, 1 };
        assert Arrays.equals(result3, expected3)
                : "Test 3 failed: expected " + Arrays.toString(expected3) + ", got " + Arrays.toString(result3);

        System.out.println("All tests passed!");
    }
}