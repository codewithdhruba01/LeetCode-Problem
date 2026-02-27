# 239. Sliding Window Maximum

[LeetCode Problem Link](https://leetcode.com/problems/sliding-window-maximum/)

## Description

You are given an array of integers `nums`, there is a sliding window of size `k` which is moving from the very left of the array to the very right. You can only see the `k` numbers in the window. Each time the sliding window moves right by one position.

Return the *max sliding window*.

## Examples

**Example 1:**
```
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```

**Example 2:**
```
Input: nums = [1], k = 1
Output: [1]
```

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^4 <= nums[i] <= 10^4`
- `1 <= k <= nums.length`

## Approach: Monotonic Deque

We use a doubly-ended queue (Deque) to store indices of elements that are candidates for being the maximum in the current sliding window.

### Intuition

1. **Maintain a Decreasing Queue**: Store indices such that the values in `nums` corresponding to these indices are in strictly decreasing order.
2. **Remove Out-of-Window Indices**: When moving the window, remove indices from the front of the deque if they are no longer inside the current window.
3. **Keep Deque Optimized**: When adding a new element, remove all indices from the back of the deque whose corresponding values are smaller than the new element. They can never be the maximum for any window starting from the current index.
4. **Result Extraction**: The front of the deque always contains the index of the maximum element for the current window.

### Complexity Analysis

- **Time Complexity:** `O(N)`, where `N` is the length of the array. Each element is added to and removed from the deque at most once.
- **Space Complexity:** `O(K)`, where `K` is the size of the window. The deque stores at most `K` indices.

## Code (Java)

```java
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove indices out of window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Window ready
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
```
