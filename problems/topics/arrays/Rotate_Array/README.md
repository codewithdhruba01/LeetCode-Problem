# 189. Rotate Array

[LeetCode Problem Link](https://leetcode.com/problems/rotate-array/)

## Description

Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

## Examples

**Example 1:**

```
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

**Example 2:**

```
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
```

## Constraints

-   `1 <= nums.length <= 10^5`
-   `-2^31 <= nums[i] <= 2^31 - 1`
-   `0 <= k <= 10^5`

## Approach: Reversal Algorithm

The most optimal in-place solution with `O(1)` extra space is the Reversal Algorithm.

### Intuition

The idea is based on the observation that rotating an array by `k` steps is equivalent to:
1.  Reversing the entire array.
2.  Reversing the first `k` elements.
3.  Reversing the remaining `n - k` elements.

**Example**: `nums = [1,2,3,4,5,6,7]`, `k = 3`
1.  Original: `1 2 3 4 5 6 7`
2.  Reverse All: `7 6 5 4 3 2 1`
3.  Reverse first `k` (3 elements): `5 6 7 4 3 2 1`
4.  Reverse remaining `n-k` (4 elements): `5 6 7 1 2 3 4` -> Result!

**Key Step**: Always perform `k = k % n` first, because rotating by `n` steps brings the array back to the original state.

### Complexity Analysis

-   **Time Complexity:** `O(N)`. We reverse the array essentially three times, which is linear.
-   **Space Complexity:** `O(1)`. We only use a constant amount of extra space for swapping.

## Code (Java)

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```
