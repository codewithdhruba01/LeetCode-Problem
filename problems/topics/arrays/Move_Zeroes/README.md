# 283. Move Zeroes

[LeetCode Problem Link](https://leetcode.com/problems/move-zeroes/)

## Description

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

**Note** that you must do this in-place without making a copy of the array.

## Examples

**Example 1:**

```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```

**Example 2:**

```
Input: nums = [0]
Output: [0]
```

## Constraints

-   `1 <= nums.length <= 10^4`
-   `-2^31 <= nums[i] <= 2^31 - 1`

## Approach: Two Pointers (Insert Index)

The idea is to keep track of the position (`insertPos`) where the next non-zero element should be placed.

### Intuition

1.  Iterate through the array. If the current element is non-zero, place it at `insertPos` and increment `insertPos`.
2.  After the iteration, all non-zero elements are at the beginning of the array in their original relative order.
3.  Fill the remaining positions (from `insertPos` to the end) with `0`s.

This effectively "shifts" all non-zero elements to the left and fills the rest with zeros.

### Complexity Analysis

-   **Time Complexity:** `O(n)`, where `n` is the length of `nums`. We traverse the array twice (once to move non-zeros, once to fill zeros).
-   **Space Complexity:** `O(1)`, as we modify the array in-place.

## Code (Java)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos] = num;
                insertPos++;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }
}
```
