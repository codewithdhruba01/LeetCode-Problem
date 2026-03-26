import java.util.*;

/**
 * 1636. Sort Array by Increasing Frequency
 * 
 * Approach: HashMap & Custom Sorting
 * Time Complexity: O(N log N)
 * Space Complexity: O(N)
 */
class Solution {
    public int[] frequencySort(int[] nums) {
        // Map to store frequency of each element
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Convert int[] to Integer[] to use custom comparator
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        // Custom comparator: 
        // 1. Sort by frequency in ascending order
        // 2. If frequencies equal, sort by value in descending order
        Arrays.sort(arr, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return b - a; // Value descending
            }
            return freq.get(a) - freq.get(b); // Freq ascending
        });

        // Convert back to primitive array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        System.out.println("Test Case 1 Output: " + Arrays.toString(solution.frequencySort(nums1)));
        // Expected: [3, 1, 1, 2, 2, 2]

        // Test Case 2
        int[] nums2 = {2, 3, 1, 3, 2};
        System.out.println("Test Case 2 Output: " + Arrays.toString(solution.frequencySort(nums2)));
        // Expected: [1, 3, 3, 2, 2]

        // Test Case 3
        int[] nums3 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        System.out.println("Test Case 3 Output: " + Arrays.toString(solution.frequencySort(nums3)));
        // Expected: [5, -1, 4, 4, -6, -6, 1, 1, 1]
    }
}
