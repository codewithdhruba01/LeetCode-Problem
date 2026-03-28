# 852. Peak Index in a Mountain Array

[LeetCode Problem Link](https://leetcode.com/problems/peak-index-in-a-mountain-array/)

## Description

An array `arr` is a **mountain** if the following properties hold:
- `arr.length >= 3`
- There exists some `i` with `0 < i < arr.length - 1` such that:
    - `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
    - `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`

Given a mountain array `arr`, return the index `i` such that `arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`.

You must solve it in $O(\log n)$ time complexity.

## Examples

**Example 1:**
```
Input: arr = [0,1,0]
Output: 1
```

**Example 2:**
```
Input: arr = [0,2,1,0]
Output: 1
```

**Example 3:**
```
Input: arr = [0,10,5,2]
Output: 1
```

## Constraints

- `3 <= arr.length <= 10^5`
- `0 <= arr[i] <= 10^6`
- `arr` is guaranteed to be a mountain array.

## Approach: Binary Search ($O(\log N)$)

Since the array has a increasing-then-decreasing structure, we can use binary search to find the "peak" where the direction changes.

### Intuition

1. **Search Space**: `left = 0`, `right = arr.length - 1`.
2. **Comparison**: In each step, we check the relation between `arr[mid]` and the next element `arr[mid + 1]`.
    - If `arr[mid] < arr[mid + 1]`, we are currently on the **ascending** slope. The peak must be to the right. So, `left = mid + 1`.
    - If `arr[mid] >= arr[mid + 1]`, we are either at the **peak** or on the **descending** slope. The peak could be `mid` or to its left. So, `right = mid`.
3. **Termination**: When `left == right`, we have narrowed down to the peak index.

### Complexity Analysis

- **Time Complexity:** $O(\log N)$, where $N$ is the length of the array.
- **Space Complexity:** $O(1)$, as we only use pointers.

## Code (Java)

```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if we are on the increasing slope
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                // We are at the peak or on the decreasing slope
                right = mid;
            }
        }
        
        return left; // or return right;
    }
}
```
