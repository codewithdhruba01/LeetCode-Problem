# 349. Intersection of Two Arrays

[LeetCode Problem Link](https://leetcode.com/problems/intersection-of-two-arrays/)

## Description

Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must be **unique** and you may return the result in **any order**.

## Examples

**Example 1:**
```
Input: nums1 = [1,2,2,1], nums2 = [2]
Output: [2]
```

**Example 2:**
```
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
```

## Constraints

- `1 <= nums1.length, nums2.length <= 1000`
- `0 <= nums1[i], nums2[i] <= 1000`

## Approach: Hashing (HashSet)

Since we need unique elements that appear in both arrays, a `HashSet` is the most straightforward tool.

### Intuition

1. **Unique Elements of First Array**: Add all elements from `nums1` into a `HashSet` (let's call it `set1`). This automatically handles duplicates in `nums1` and allows for $O(1)$ average time lookups.
2. **Finding Common Elements**: Iterate through `nums2`. If an element is present in `set1`, it's part of the intersection.
3. **Handle Result Uniqueness**: To ensure the result itself contains unique elements even if `nums2` has duplicates, we can add found intersection elements into another `HashSet` (`intersectSet`).
4. **Conversion**: Convert `intersectSet` back to a primitive `int[]`.

### Complexity Analysis

- **Time Complexity:** $O(N + M)$, where $N$ and $M$ are lengths of the two arrays. We traverse each array once.
- **Space Complexity:** $O(N + M)$ in the worst case to store the elements in sets.

## Code (Java)

```java
import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        
        Set<Integer> intersectSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersectSet.add(num);
            }
        }
        
        // Convert to int array
        int[] result = new int[intersectSet.size()];
        int index = 0;
        for (int num : intersectSet) {
            result[index++] = num;
        }
        
        return result;
    }
}
```
