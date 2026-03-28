# 1748. Sum of Unique Elements

[LeetCode Problem Link](https://leetcode.com/problems/sum-of-unique-elements/)

## Description

You are given an integer array `nums`. The unique elements of an array are the elements that appear **exactly once** in the array.

Return *the sum of all the unique elements of `nums`*.

## Examples

**Example 1:**
```
Input: nums = [1,2,3,2]
Output: 4
Explanation: The unique elements are [1,3], and the sum is 4.
```

**Example 2:**
```
Input: nums = [1,1,1,1,1]
Output: 0
Explanation: There are no unique elements, and the sum is 0.
```

**Example 3:**
```
Input: nums = [1,2,3,4,5]
Output: 15
Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
```

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`

## Approach: Frequency Counting (Hashing)

A unique element is one that has a frequency of exactly 1 in the array.

### Intuition

1. **Frequency Counting**: Use a `HashMap<Integer, Integer>` to store the count of each number in `nums`.
2. **Summation**: Iterate through the keys of the map. If the value associated with a key is `1`, add that key to our total sum.
3. **Alternative (Frequency Array)**: Since the constraints are small ($nums[i] \le 100$), an `int[101]` array can also be used as a faster hash table.

### Complexity Analysis

- **Time Complexity:** $O(N)$, where $N$ is the number of elements in `nums`. We traverse the array to count and then the map to sum.
- **Space Complexity:** $O(N)$ for the HashMap (or $O(100)$ for a frequency array).

## Code (Java)

```java
import java.util.*;

class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int sum = 0;
        // Sum elements that appear exactly once
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                sum += num;
            }
        }
        
        return sum;
    }
}
```
