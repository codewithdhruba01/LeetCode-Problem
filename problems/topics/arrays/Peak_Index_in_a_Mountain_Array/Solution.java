/**
 * 852. Peak Index in a Mountain Array
 * 
 * Approach: Binary Search to find the point where ascending becomes descending.
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If arr[mid] is less than the next element, peak is ahead
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                // Otherwise, peak is here or behind
                right = mid;
            }
        }

        // Both left and right point to the peak index
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] arr1 = {0, 1, 0};
        System.out.println("Test Case 1 Output: " + solution.peakIndexInMountainArray(arr1)); 
        // Expected: 1

        // Test Case 2
        int[] arr2 = {0, 2, 1, 0};
        System.out.println("Test Case 2 Output: " + solution.peakIndexInMountainArray(arr2)); 
        // Expected: 1

        // Test Case 3
        int[] arr3 = {0, 10, 5, 2};
        System.out.println("Test Case 3 Output: " + solution.peakIndexInMountainArray(arr3)); 
        // Expected: 1
    }
}
