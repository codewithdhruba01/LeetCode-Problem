# 80. Remove Duplicates from Sorted Array II

[LeetCode Problem Link](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)

## Description

Given an integer array `nums` sorted in **non-decreasing order**, remove some duplicates **in-place** such that each unique element appears **at most twice**. The **relative order** of the elements should be kept the **same**.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the **first part** of the array `nums`. More formally, if there are `k` elements after removing the duplicates, then the first `k` elements of `nums` should hold the final result. It does not matter what you leave beyond the first `k` elements.

Return `k` after placing the final result in the first `k` slots of `nums`.

Do not allocate extra space for another array. You must do this by **modifying the input array in-place** with O(1) extra memory.

## Examples

**Example 1:**
```
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
```

**Example 2:**
```
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k.
```

## Constraints

- `1 <= nums.length <= 3 * 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `nums` is sorted in **non-decreasing** order.

## Approach: Two Pointers (Overwrite Method)

We can maintain a pointer `index` that represents the position where the next valid element should be placed. Since we allow up to two occurrences, we only compare the current element with the element at `index - 2`.

### Intuition

1. The first two elements (if they exist) are always valid regardless of whether they are duplicates.
2. For elements from index 2 onwards, if `nums[i]` is different from `nums[index - 2]`, it means we haven't reached more than two occurrences of that value at the destination.
3. We overwrite `nums[index]` with `nums[i]` and increment `index`.

### Complexity Analysis

- **Time Complexity:** `O(N)`, where `N` is the length of the array. We scan the array once.
- **Space Complexity:** `O(1)`. Modifications are done in-place.

## Code (Java)

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        
        int index = 2; // Start from the third position
        for (int i = 2; i < nums.length; i++) {
            // Compare current element with the element two positions back in the modified part
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
```
