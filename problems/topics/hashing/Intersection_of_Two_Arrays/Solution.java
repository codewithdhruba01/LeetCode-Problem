import java.util.*;

/**
 * 349. Intersection of Two Arrays
 * 
 * Approach: Hashing with HashSet
 * Time Complexity: O(N + M)
 * Space Complexity: O(N + M)
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Set to store unique elements of nums1 for O(1) lookup
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // Set to store unique elements and intersection result
        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }

        // Convert the result Set to an int array
        int[] ans = new int[result.size()];
        int i = 0;
        for (int num : result) {
            ans[i++] = num;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1_a = {1, 2, 2, 1};
        int[] nums1_b = {2, 2};
        System.out.println("Test Case 1 Output: " + Arrays.toString(solution.intersection(nums1_a, nums1_b))); 
        // Expected: [2]

        // Test Case 2
        int[] nums2_a = {4, 9, 5};
        int[] nums2_b = {9, 4, 9, 8, 4};
        System.out.println("Test Case 2 Output: " + Arrays.toString(solution.intersection(nums2_a, nums2_b))); 
        // Expected: [4, 9] (order can vary)
    }
}
