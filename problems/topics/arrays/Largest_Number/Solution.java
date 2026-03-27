import java.util.*;

/**
 * 179. Largest Number
 * 
 * Approach: Greedy Sorting with Custom Comparator
 * Time Complexity: O(N log N * L) where L is the avg length of numbers
 * Space Complexity: O(N * L)
 */
class Solution {
    public String largestNumber(int[] nums) {
        // Step 1: Convert integers to strings
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Step 2: Custom sort
        // We want strings 'a' and 'b' such that concatenating b then a is larger than a then b
        // This ensures the largest global concatenation.
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Step 3: Handle edge case where the largest number is 0
        // (e.g., [0, 0] should return "0", not "00")
        if (arr[0].equals("0")) {
            return "0";
        }

        // Step 4: Concatenate sorted strings
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {10, 2};
        System.out.println("Test Case 1 Output: " + solution.largestNumber(nums1)); 
        // Expected: "210"

        // Test Case 2
        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println("Test Case 2 Output: " + solution.largestNumber(nums2)); 
        // Expected: "9534330"

        // Test Case 3: All zeros
        int[] nums3 = {0, 0};
        System.out.println("Test Case 3 Output: " + solution.largestNumber(nums3)); 
        // Expected: "0"
    }
}
