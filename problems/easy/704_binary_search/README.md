# 704. Binary Search

[LeetCode Problem Link](https://leetcode.com/problems/binary-search/)

## Description

Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`.

You must write an algorithm with `O(log n)` runtime complexity.

## Examples

**Example 1:**
```
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```

**Example 2:**
```
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
```

## Constraints

- `1 <= nums.length <= 10^4`
- `-10^4 < nums[i], target < 10^4`
- All the integers in `nums` are **unique**.
- `nums` is sorted in ascending order.

## Approach: Standard Binary Search

Since the array is already sorted, we can use the classic Binary Search algorithm to find the target in $O(\log N)$ time.

### Intuition

1. Initialize two pointers, `left` at the beginning (`0`) and `right` at the end (`nums.length - 1`) of the array.
2. Loop while `left <= right`:
   - Calculate the middle index: `mid = left + (right - left) / 2`. Avoiding `(left + right) / 2` prevents potential integer overflow for very large arrays.
   - If `nums[mid] == target`, we found the element, return `mid`.
   - If `nums[mid] < target`, the target must reside in the right half. Update `left = mid + 1`.
   - If `nums[mid] > target`, the target must reside in the left half. Update `right = mid - 1`.
3. If the loop completes without finding the target, it doesn't exist in the array. Return `-1`.

### Complexity Analysis

- **Time Complexity:** `O(log n)`. In each step, we divide the search space by half.
- **Space Complexity:** `O(1)`. We only use a few integer variables (`left`, `right`, `mid`) for pointers.

## Code (Java)

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            // Prevent potential integer overflow
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // Target is in the right half
                left = mid + 1;
            } else {
                // Target is in the left half
                right = mid - 1;
            }
        }
        
        return -1;
    }
}
```
