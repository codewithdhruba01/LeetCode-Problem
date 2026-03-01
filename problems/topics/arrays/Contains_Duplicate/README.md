# 217. Contains Duplicate

[LeetCode Problem Link](https://leetcode.com/problems/contains-duplicate/)

## Description

Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

## Examples

**Example 1:**
```
Input: nums = [1,2,3,1]
Output: true
Explanation: The element 1 occurs at the indices 0 and 3.
```

**Example 2:**
```
Input: nums = [1,2,3,4]
Output: false
Explanation: All elements are distinct.
```

**Example 3:**
```
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
```

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

## Approach: HashSet

This is a classic problem that can be solved efficiently using a Hash-based data structure to keep track of elements we've already seen.

### Intuition

We traverse the array and store each element in a `HashSet`. Before adding an element, we check if it already exists in the set:
- If it does, we've found a duplicate and return `true`.
- If we finish the loop without finding any duplicates, we return `false`.

### Complexity Analysis

- **Time Complexity:** `O(N)`, where `N` is the length of the array. We traverse the array once, and HashSet operations (add, contains) take `O(1)` on average.
- **Space Complexity:** `O(N)`, in the worst case where all elements are distinct, we store all `N` elements in the set.

## Code (Java)

```java
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
```
