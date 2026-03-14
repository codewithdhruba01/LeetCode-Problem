import java.util.*;

/**
 * 898. Bitwise ORs of Subarrays
 * 
 * Approach: HashSet with Dynamic Programming (Tracking Subarrays Ending at i)
 * Time Complexity: O(N * 30) => O(N) practically
 * Space Complexity: O(N) for the result set
 */
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        // 'result' will store all the unique OR values we find
        Set<Integer> result = new HashSet<>();
        
        // 'prev' stores the unique OR values of contiguous subarrays ending exactly at the previous index
        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {
            // 'curr' will store the unique OR values of contiguous subarrays ending exactly at the current index
            Set<Integer> curr = new HashSet<>();
            
            // A subarray can just be the current element itself
            curr.add(num);

            // Extend all subarrays that ended at the previous index to include the current element
            for (int val : prev) {
                curr.add(val | num);
            }

            // Add all unique ORs found ending at this step to the global result
            result.addAll(curr);
            
            // Move 'curr' to 'prev' for the next iteration
            prev = curr;
        }

        return result.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] arr1 = {0};
        System.out.println("Test Case 1 Output: " + solution.subarrayBitwiseORs(arr1)); // Expected: 1

        // Test Case 2
        int[] arr2 = {1, 1, 2};
        System.out.println("Test Case 2 Output: " + solution.subarrayBitwiseORs(arr2)); // Expected: 3

        // Test Case 3
        int[] arr3 = {1, 2, 4};
        System.out.println("Test Case 3 Output: " + solution.subarrayBitwiseORs(arr3)); // Expected: 6
    }
}
