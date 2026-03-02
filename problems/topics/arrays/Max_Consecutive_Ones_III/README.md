# 1004. Max Consecutive Ones III

[LeetCode Problem Link](https://leetcode.com/problems/max-consecutive-ones-iii/)

## Description

Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`'s in the array if you can flip at most `k` `0`'s.

## Examples

**Example 1:**
```
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
```

**Example 2:**
```
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `nums[i]` is either `0` or `1`.
- `0 <= k <= nums.length`

## Approach: Sliding Window

The problem can be translated to: "Find the longest subarray with at most `k` zeros."

### Intuition

1. Maintain a window `[left, right]` where we count the number of zeros (`zeroCount`).
2. Expand the window by moving `right` from `0` to `n-1`.
3. If `nums[right]` is `0`, increment `zeroCount`.
4. If `zeroCount` exceeds `k`, shrink the window from the `left` until `zeroCount` is back to `k` or less. If `nums[left]` was `0`, decrement `zeroCount`.
5. At each step, update the maximum length found so far: `maxLen = Math.max(maxLen, right - left + 1)`.

### Complexity Analysis

- **Time Complexity:** `O(N)`, where `N` is the length of the array. Each element is visited at most twice (once by `right`, once by `left`).
- **Space Complexity:** `O(1)`, as we only use a few integer variables.

## Code (Java)

```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            // Include right element
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Shrink window from left if zero count exceeds k
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Calculate max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
```
