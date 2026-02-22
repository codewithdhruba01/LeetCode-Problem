# 26. Remove Duplicates from Sorted Array

[LeetCode Problem Link](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

## Description

Given an integer array `nums` sorted in **non-decreasing order**, remove the duplicates **in-place** such that each unique element appears only **once**. The **relative order** of the elements should be kept the **same**. Then return the number of unique elements in `nums`.

Consider the number of unique elements of `nums` to be `k`, to get accepted, you need to do the following things:
1. Modify the array `nums` such that the first `k` elements of `nums` contain the unique elements in the order they were present in `nums` initially. The remaining elements of `nums` are not important as well as the size of `nums`.
2. Return `k`.

## Examples

**Example 1:**
```
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
```

**Example 2:**
```
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k.
```

## Constraints

- `1 <= nums.length <= 3 * 10^4`
- `-100 <= nums[i] <= 100`
- `nums` is sorted in **non-decreasing** order.

## Approach: Two Pointers

Since the array is already sorted, we can use two pointers to keep track of the unique elements and the position where the next unique element should be placed.

### Intuition

1. We use a pointer `i` (the slow pointer) to keep track of the last unique element found.
2. We use another pointer `j` (the fast pointer) to iterate through the array.
3. Every time we encounter a new unique element (`nums[j] != nums[i]`), we increment `i` and update `nums[i]` with the new element.
4. Finally, the number of unique elements will be `i + 1`.

### Complexity Analysis

- **Time Complexity:** `O(N)`, where `N` is the length of the array. We visit each element exactly once.
- **Space Complexity:** `O(1)`. We perform the removal in-place without any extra space.

## Code (Java)

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
```
