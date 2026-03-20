import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * 
 * Approach: Prefix and Suffix Products (Space Optimized)
 * Time Complexity: O(N)
 * Space Complexity: O(1) (excluding output array)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate prefix products and store them in the result array
        // result[i] will contain the product of all elements to the left of index i
        result[0] = 1; // Base case: nothing to the left of the 0th element
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products on the fly and multiply with prefix products
        int suffix = 1; // Running product of elements to the right
        for (int i = n - 1; i >= 0; i--) {
            // result[i] currently holds the prefix product. Multiply it by the suffix product.
            result[i] = result[i] * suffix;
            // Update the suffix product for the next element to the left
            suffix *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.println("Test Case 1 Output: " + Arrays.toString(result1)); // Expected: [24, 12, 8, 6]

        // Test Case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.println("Test Case 2 Output: " + Arrays.toString(result2)); // Expected: [0, 0, 9, 0, 0]
    }
}
