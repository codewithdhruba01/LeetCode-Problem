# 1752. Check if Array Is Sorted and Rotated

[LeetCode Problem Link](https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/)

## Description

Given an array `nums`, return `true` *if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero)*. Otherwise, return `false`.

There may be **duplicates** in the original array.

**Note:** An array `A` rotated by `x` positions results in an array `B` of the same length such that `B[i] == A[(i+x) % A.length]` for every valid index `i`.

## Examples

**Example 1:**
```
Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].
```

**Example 2:**
```
Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
```

**Example 3:**
```
Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
```

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`

## Approach: Single Pass (Circular Check)

An array that was once sorted and then rotated can have at most **one** place where the next element is smaller than the current element (an "inversion").

### Intuition

1. Iterate through the array and compare each element `nums[i]` with the next element `nums[(i + 1) % n]`.
2. The modulo `% n` allows us to compare the last element with the first element, effectively checking the array as a circle.
3. Count how many times `nums[i] > nums[(i + 1) % n]`.
4. If the array is sorted and rotated, this count will be:
   - **0**: If the array is sorted and not rotated (e.g., `[1, 2, 3]`).
   - **1**: If the array is sorted and rotated (e.g., `[3, 4, 1, 2]`).
5. If the count is greater than 1, it's not a rotated sorted array.

### Complexity Analysis

- **Time Complexity:** `O(N)`, where `N` is the length of the array. We traverse the array exactly once.
- **Space Complexity:** `O(1)`, as we only use a single counter variable.

## Code (Java)

```java
class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Check if the current element is greater than the next (circularly)
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        // A sorted and rotated array can have at most one such "drop"
        return count <= 1;
    }
}
```
