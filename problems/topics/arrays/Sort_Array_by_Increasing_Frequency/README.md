# 1636. Sort Array by Increasing Frequency

[LeetCode Problem Link](https://leetcode.com/problems/sort-array-by-increasing-frequency/)

## Description

Given an array of integers `nums`, sort the array in **increasing** order based on the frequency of the values. If multiple values have the same frequency, sort them in **decreasing** order.

Return the *sorted array*.

## Examples

**Example 1:**
```
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
```

**Example 2:**
```
Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
```

**Example 3:**
```
Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
```

## Constraints

- `1 <= nums.length <= 100`
- `-100 <= nums[i] <= 100`

## Approach: HashMap & Custom Sorting

Since we need to sort based on frequency count, the first step is to count how many times each number appears.

### Intuition

1. **Frequency Count**: Use a `HashMap<Integer, Integer>` to store the frequency of each number in `nums`.
2. **Box Primitives**: Java's `Arrays.sort()` on primitives doesn't support custom comparators. We need to convert the `int[]` to an `Integer[]` (boxed type).
3. **Custom Sort**:
   - Primary Sort Key: **Frequency (Ascending)**.
   - Secondary Sort Key (Ties): **Value (Descending)**.
4. **Unbox**: Convert the sorted `Integer[]` back to `int[]` for the result.

### Complexity Analysis

- **Time Complexity:** $O(N \log N)$. Counting frequencies takes $O(N)$, sorting $N$ elements takes $O(N \log N)$, and updating the original array takes $O(N)$.
- **Space Complexity:** $O(N)$. We use a HashMap to store frequencies and an extra array for sorting.

## Code (Java)

```java
import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count frequency
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Convert to Integer array for sorting
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        
        // Step 3: Custom sort
        Arrays.sort(arr, (a, b) -> {
            int f1 = freq.get(a);
            int f2 = freq.get(b);
            
            if (f1 != f2) {
                return f1 - f2; // Ascending frequency
            } else {
                return b - a; // Descending value
            }
        });
        
        // Step 4: Convert back to primitive array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
        
        return nums;
    }
}
```
