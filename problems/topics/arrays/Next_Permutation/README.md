# 31. Next Permutation

[LeetCode Problem Link](https://leetcode.com/problems/next-permutation/)

## Description

A **permutation** of an array of integers is an arrangement of its members into a sequence or linear order.

The **next permutation** of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the **next permutation** of that array is the permutation that follows it in the sorted container.

If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

The replacement must be **in place** and use only **constant extra memory**.

## Examples

**Example 1:**
```
Input: nums = [1,2,3]
Output: [1,3,2]
```

**Example 2:**
```
Input: nums = [3,2,1]
Output: [1,2,3]
```

**Example 3:**
```
Input: nums = [1,1,5]
Output: [1,5,1]
```

## Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 100`

## Approach: $O(N)$ Peak-to-Swap Algorithm

The algorithm finds the next lexicographical permutation by identifying the "rightmost peak" and reordering.

### Intuition

1. **Find the Breach**: Scan from right to left to find the first index `i` such that `nums[i] < nums[i+1]`. This is the point where the descending sequence from the right is broken.
2. **Find the Successor**: If such `i` exists, scan from right to left again to find the first index `j` such that `nums[j] > nums[i]`. This `j` is the smallest value greater than `nums[i]` in the right suffix.
3. **Swap**: Swap `nums[i]` and `nums[j]`.
4. **Reverse**: Reverse the entire suffix starting from index `i + 1`. Since the suffix was guaranteed to be descending, reversing it makes it ascending (minimizing the increment).

### Complexity Analysis

- **Time Complexity:** $O(N)$. We perform at most 3 linear passes over the array.
- **Space Complexity:** $O(1)$. All operations are done in-place.

## Code (Java)

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        
        // 1. Find the first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // 2. If such element is found, find successor and swap
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        // 3. Reverse the suffix to get the smallest next permutation
        reverse(nums, i + 1, n - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
```
