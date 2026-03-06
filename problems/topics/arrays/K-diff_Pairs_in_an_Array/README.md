# 532. K-diff Pairs in an Array

[LeetCode Problem Link](https://leetcode.com/problems/k-diff-pairs-in-an-array/)

## Description

Given an array of integers `nums` and an integer `k`, return *the number of **unique** k-diff pairs in the array*.

A **k-diff** pair is an integer pair `(nums[i], nums[j])`, where the following are true:

- `0 <= i, j < nums.length`
- `i != j`
- `|nums[i] - nums[j]| == k`

**Notice** that `|val|` denotes the absolute value of `val`.

## Examples

**Example 1:**
```
Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
```

**Example 2:**
```
Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
```

**Example 3:**
```
Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
```

## Constraints

- `1 <= nums.length <= 10^4`
- `-10^7 <= nums[i] <= 10^7`
- `0 <= k <= 10^7`

## Approach: HashMap Frequency

The problem asks for unique pairs. A HashMap is ideal for tracking frequencies and efficiently searching for the required "partner" element for each number.

### Intuition

1. **Edge Case**: If `k < 0`, return `0` (absolute difference can't be negative).
2. Count the frequency of each number using a `HashMap<Integer, Integer>`.
3. Iterate through the keys of the map:
   - **Case `k > 0`**: For each number `num`, if `num + k` exists in the map, we've found a unique pair `(num, num + k)`.
   - **Case `k == 0`**: For each number `num`, if its frequency is $\ge 2$, we've found a unique pair `(num, num)`.
4. Return the total count of such unique pairs.

### Complexity Analysis

- **Time Complexity:** `O(N)`, where `N` is the length of the array. We iterate through the array once to build the map, and then once through the keys of the map.
- **Space Complexity:** `O(N)` to store the frequencies in the HashMap.

## Code (Java)

```java
import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int num : map.keySet()) {
            if (k == 0) {
                // For k=0, we need at least two occurrences of the same number
                if (map.get(num) > 1) {
                    count++;
                }
            } else {
                // For k > 0, we check if num + k exists
                if (map.containsKey(num + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
```
