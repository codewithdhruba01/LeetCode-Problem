# 75. Sort Colors

[LeetCode Problem Link](https://leetcode.com/problems/sort-colors/)

## Description

Given an array `nums` with `n` objects colored red, white, or blue, sort them **in-place** so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

## Examples

**Example 1:**
```
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

**Example 2:**
```
Input: nums = [2,0,1]
Output: [0,1,2]
```

## Constraints

- `n == nums.length`
- `1 <= n <= 300`
- `nums[i]` is either `0`, `1`, or `2`.

## Approach: Dutch National Flag Algorithm

This problem can be solved in a single pass using three pointers.

### Intuition

We maintain three pointers:
1. `low`: Points to the position where the next `0` should be placed.
2. `mid`: Current element being processed.
3. `high`: Points to the position where the next `2` should be placed.

As we traverse with `mid`:
- If `nums[mid] == 0`: Swap `nums[low]` and `nums[mid]`, then increment both `low` and `mid`.
- If `nums[mid] == 1`: Just increment `mid`.
- If `nums[mid] == 2`: Swap `nums[mid]` and `nums[high]`, then decrement `high`. (Do not increment `mid` yet, as the swapped element needs to be checked).

### Complexity Analysis

- **Time Complexity:** `O(N)`, where `N` is the length of the array. We visit each element at most once.
- **Space Complexity:** `O(1)`. We only use a constant amount of extra space for the pointers.

## Code (Java)

```java
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
