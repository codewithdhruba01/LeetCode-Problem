# 54. Spiral Matrix

[LeetCode Problem Link](https://leetcode.com/problems/spiral-matrix/)

## Description

Given an `m x n` `matrix`, return *all elements of the* `matrix` *in spiral order*.

## Examples

**Example 1:**
![Example 1](https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg)
```
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
```

**Example 2:**
![Example 2](https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg)
```
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```

## Constraints

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 10`
- `-100 <= matrix[i][j] <= 100`

## Approach: Boundary Shrinking

The most intuitive way to traverse a matrix in spiral order is to keep track of four boundaries: `top`, `bottom`, `left`, and `right`.

### Intuition

1. Initialize `top = 0`, `bottom = m-1`, `left = 0`, `right = n-1`.
2. While `top <= bottom` and `left <= right`:
   - Traverse from **left to right** along the `top` row, then increment `top`.
   - Traverse from **top to bottom** along the `right` column, then decrement `right`.
   - If `top <= bottom`:
     - Traverse from **right to left** along the `bottom` row, then decrement `bottom`.
   - If `left <= right`:
     - Traverse from **bottom to top** along the `left` column, then increment `left`.
3. The conditions `if (top <= bottom)` and `if (left <= right)` are crucial inside the loop for non-square matrices to avoid re-traversing rows or columns already processed.

### Complexity Analysis

- **Time Complexity:** `O(M * N)`, where `M` is the number of rows and `N` is the number of columns. Every element is visited exactly once.
- **Space Complexity:** `O(1)` extra space (ignoring the space required for the output list).

## Code (Java)

```java
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            
            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // Traverse from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            // Traverse from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}
```
