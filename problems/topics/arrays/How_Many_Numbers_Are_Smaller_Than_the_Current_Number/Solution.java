import java.util.Arrays;

/**
 * 1365. How Many Numbers Are Smaller Than the Current Number
 * 
 * Approach: Frequency Array with Prefix Sums
 * Time Complexity: O(N) where N is the length of nums (since max value is fixed at 100)
 * Space Complexity: O(1) extra space (since frequency array is fixed size 101)
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]; // frequency array for values 0-100
        
        // Step 1: count frequency of each number
        for (int num : nums) {
            count[num]++;
        }
        
        // Step 2: calculate prefix sum
        // count[i] will store the number of elements <= i
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }
        
        // Step 3: build result array
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // If the number is 0, there are no smaller numbers (since 0 <= nums[i])
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                // The number of elements strictly smaller than nums[i] is count[nums[i] - 1]
                result[i] = count[nums[i] - 1];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {8, 1, 2, 2, 3};
        System.out.println("Test Case 1 Output: " + Arrays.toString(solution.smallerNumbersThanCurrent(nums1)));
        // Expected: [4, 0, 1, 1, 3]

        // Test Case 2
        int[] nums2 = {6, 5, 4, 8};
        System.out.println("Test Case 2 Output: " + Arrays.toString(solution.smallerNumbersThanCurrent(nums2)));
        // Expected: [2, 1, 0, 3]

        // Test Case 3
        int[] nums3 = {7, 7, 7, 7};
        System.out.println("Test Case 3 Output: " + Arrays.toString(solution.smallerNumbersThanCurrent(nums3)));
        // Expected: [0, 0, 0, 0]
    }
}
