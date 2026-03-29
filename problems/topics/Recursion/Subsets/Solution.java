import java.util.*;

/**
 * 78. Subsets
 * 
 * Approach: Backtracking (Power Set generation)
 * Time Complexity: O(N * 2^N)
 * Space Complexity: O(N) (recursion depth)
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start backtracking from index 0 with an empty temporary list
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        // Every state in backtracking is a valid subset
        // We add a new copy of 'temp' because 'temp' is modified in future steps
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            // Include nums[i] in the current subset
            temp.add(nums[i]);

            // Move to the next element
            backtrack(i + 1, nums, temp, result);

            // Backtrack: Remove the element to explore other subsets
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 2, 3};
        System.out.println("Test Case 1 Output: " + solution.subsets(nums1));
        // Expected: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

        // Test Case 2
        int[] nums2 = {0};
        System.out.println("Test Case 2 Output: " + solution.subsets(nums2));
        // Expected: [[], [0]]
    }
}
