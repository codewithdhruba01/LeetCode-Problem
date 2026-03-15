# 34. Find First and Last Position of Element in Sorted Array

[LeetCode Problem Link](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

## Description

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.

If `target` is not found in the array, return `[-1, -1]`.

You must write an algorithm with `O(log n)` runtime complexity.

## Examples

**Example 1:**
```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

**Example 2:**
```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

**Example 3:**
```
Input: nums = [], target = 0
Output: [-1,-1]
```

## Constraints

- `0 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- `nums` is a non-decreasing array.
- `-10^9 <= target <= 10^9`

## Approach: Two-Pass Binary Search

Since the array is sorted and we need an $O(\log N)$ algorithm, Binary Search is the obvious choice. To find the *range*, we can perform binary search twice: once to find the very first occurrence of the target, and once to find the very last occurrence.

### Intuition

1. **Find First Occurrence (`findFirst`)**:
   - Standard binary search.
   - When `nums[mid] == target`, instead of returning immediately, we record `ans = mid` and **continue searching in the left half** (`right = mid - 1`) to see if there's an earlier occurrence.
2. **Find Last Occurrence (`findLast`)**:
   - Standard binary search.
   - When `nums[mid] == target`, instead of returning immediately, we record `ans = mid` and **continue searching in the right half** (`left = mid + 1`) to see if there's a later occurrence.
3. Combine the results of these two searches into a `[first, last]` array.

### Complexity Analysis

- **Time Complexity:** `O(log N)`. We perform two separate binary searches, each taking $O(\log N)$ time. $O(\log N) + O(\log N) = O(\log N)$.
- **Space Complexity:** `O(1)`. The iterative binary search uses constant extra space.

## Code (Java)

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        
        return new int[]{first, last};
    }
    
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1; // keep searching left for earlier occurrences
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
    
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1; // keep searching right for later occurrences
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
}
```
