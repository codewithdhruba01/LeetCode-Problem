/**
 * 34. Find First and Last Position of Element in Sorted Array
 * 
 * Approach: Two-Pass Binary Search
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        
        return new int[]{first, last};
    }
    
    // Binary search optimized to find the leftmost boundary
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                ans = mid;           // Record current found index
                right = mid - 1;     // Keep searching left for the *first* one
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
    
    // Binary search optimized to find the rightmost boundary
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                ans = mid;           // Record current found index
                left = mid + 1;      // Keep searching right for the *last* one
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = solution.searchRange(nums1, target1);
        System.out.println("Test Case 1 Output: [" + result1[0] + ", " + result1[1] + "]"); // Expected: [3, 4]

        // Test Case 2
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println("Test Case 2 Output: [" + result2[0] + ", " + result2[1] + "]"); // Expected: [-1, -1]

        // Test Case 3
        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = solution.searchRange(nums3, target3);
        System.out.println("Test Case 3 Output: [" + result3[0] + ", " + result3[1] + "]"); // Expected: [-1, -1]
    }
}
