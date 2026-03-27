# 179. Largest Number

[LeetCode Problem Link](https://leetcode.com/problems/largest-number/)

## Description

Given a list of non-negative integers `nums`, arrange them such that they form the largest number and return it.

Since the result may be very large, you need to return a string instead of an integer.

## Examples

**Example 1:**
```
Input: nums = [10,2]
Output: "210"
```

**Example 2:**
```
Input: nums = [3,30,34,5,9]
Output: "9534330"
```

## Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 10^9`

## Approach: Greedy Sorting

The goal is to arrange numbers such that their concatenation results in the largest possible value. A simple lexicographical sort of the strings won't work (e.g., "10" vs "2"). Instead, we need a custom comparator.

### Intuition

1. **Custom Comparator**: For any two numbers $a$ and $b$, we compare the strings $(a+b)$ and $(b+a)$. If $(b+a) > (a+b)$, then $b$ should come before $a$ in the final arrangement to make the total number larger.
2. **Handling Zeros**: If after sorting, the largest number is "0", it means all numbers in the array are zero. In this case, we should return "0" instead of multiple zeros (like "000").
3. **StringBuilder**: Since the array can have up to 100 numbers, and each number can be up to $10^9$, the result can be very long. Use `StringBuilder` for efficient concatenation.

### Complexity Analysis

- **Time Complexity:** $O(N \log N \cdot L)$, where $N$ is the number of elements and $L$ is the average length of the strings. String concatenation and comparison take $O(L)$ time.
- **Space Complexity:** $O(N \cdot L)$ to store the string representations of the numbers.

## Code (Java)

```java
import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert int[] to String[]
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        
        // Custom sort: compare (b+a) with (a+b)
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        // Handle all-zero case
        if (arr[0].equals("0")) return "0";
        
        // Build result
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }
        
        return result.toString();
    }
}
```
