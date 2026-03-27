# 540. Single Element in a Sorted Array

[LeetCode Problem Link](https://leetcode.com/problems/single-element-in-a-sorted-array/)

## Description

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return *the single element that appears only once*.

Your solution must run in $O(\log n)$ time and $O(1)$ space.

## Examples

**Example 1:**
```
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
```

**Example 2:**
```
Input: nums = [3,3,7,7,10,11,11]
Output: 10
```

## Constraints

- `1 <= nums.length <= 10^5`
- `0 <= nums[i] <= 10^5`

## Approach: Binary Search

To achieve $O(\log n)$ time complexity on a sorted array, the intended approach is **Binary Search**.

### Intuition

In the given array, all elements before the single element appear in pairs starting at an even index (0, 2, 4...). For these pairs, `nums[i] == nums[i+1]` where `i` is even.
After the single element, this pattern is broken. For pairs after the single element, `nums[i] == nums[i-1]` where `i` is even.

1. **Search Space**: `left = 0`, `right = nums.length - 1`.
2. **Mid Calculation**: Calculate `mid`.
3. **Index Parity**: To check if we are on the "left" side (before the single element), we want to compare `nums[mid]` with its pair.
   - If `mid` is odd, its potential pair should be at `mid - 1`.
   - If `mid` is even, its potential pair should be at `mid + 1`.
   - A neat trick is `if (mid % 2 == 1) mid--`. Now `mid` is always even, and we can just check `if (nums[mid] == nums[mid + 1])`.
4. **Adjustment**:
   - If `nums[mid] == nums[mid + 1]`, the single element is further to the right. Set `left = mid + 2`.
   - Otherwise, the single element is at `mid` or further to the left. Set `right = mid`.
5. **Return**: When `left == right`, we've found the single element.

### Complexity Analysis

- **Time Complexity:** $O(\log N)$. We halve the search space in each step of the binary search.
- **Space Complexity:** $O(1)$. We only use a few constant pointers.

## Code (Java)

```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            // Ensure mid is even to check the [even, odd] pair pattern
            if (mid % 2 == 1) mid--;
            
            // If the pair is intact, the single element is further right
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                // If it's broken, the single element is here or to the left
                right = mid;
            }
        }
        
        return nums[left];
    }
}
```
