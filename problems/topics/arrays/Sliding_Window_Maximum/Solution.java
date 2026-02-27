package problems.topics.arrays.Sliding_Window_Maximum;

import java.util.*;

/**
 * 239. Sliding Window Maximum
 * 
 * Approach: Monotonic Deque
 * Time Complexity: O(N)
 * Space Complexity: O(K)
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Base case
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Deque stores indices of elements
        // The values corresponding to indices in deque are always in decreasing order
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window (left side)
            // Window range is [i - k + 1, i]. If deque front is i - k, it's out.
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // 2. Remove indices of smaller elements from the back (right side)
            // If the current element is larger than elements in deque, those elements
            // will never be the maximum for any future window.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. Add current index to the back
            deque.offerLast(i);

            // 4. If window is fully formed (at least k elements processed)
            // The front of the deque is the index of the maximum element.
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k1 = 3;
        System.out.println("Test Case 1: " + Arrays.toString(solution.maxSlidingWindow(nums1, k1)));
        // Expected: [3, 3, 5, 5, 6, 7]

        // Test Case 2
        int[] nums2 = { 1 };
        int k2 = 1;
        System.out.println("Test Case 2: " + Arrays.toString(solution.maxSlidingWindow(nums2, k2)));
        // Expected: [1]
    }
}
