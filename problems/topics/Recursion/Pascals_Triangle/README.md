# 118. Pascal's Triangle

[LeetCode Problem Link](https://leetcode.com/problems/pascals-triangle/)

## Description

Given an integer `numRows`, return the first `numRows` of **Pascal's triangle**.

In **Pascal's triangle**, each number is the sum of the two numbers directly above it as shown:

![Pascal's Triangle](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

## Examples

**Example 1:**
```
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
```

**Example 2:**
```
Input: numRows = 1
Output: [[1]]
```

## Constraints

- `1 <= numRows <= 30`

## Approach: Iterative Dynamic Programming

The problem can be solved by generating each row one by one, where each row is constructed based on the values in the previous row.

### Intuition

1. **First Row**: The first row is always `[1]`.
2. **Subsequent Rows**: For any row `i` (0-indexed):
    - The first and last elements are always `1`.
    - Any middle element at index `j` is the sum of elements at index `j-1` and `j` from the previous row `i-1`.
    - `val = prevRow.get(j-1) + prevRow.get(j)`.

### Complexity Analysis

- **Time Complexity:** $O(numRows^2)$. We generate $numRows$ rows, and each row $i$ has $i+1$ elements.
- **Space Complexity:** $O(numRows^2)$ to store the entire triangle in the result list.

## Code (Java)

```java
import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // First or last element of the row is always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Middle elements are sum of two elements above
                    int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    row.add(val);
                }
            }
            result.add(row);
        }
        
        return result;
    }
}
```
