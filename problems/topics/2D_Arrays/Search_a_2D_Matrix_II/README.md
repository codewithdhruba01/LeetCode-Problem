# 240. Search a 2D Matrix II

[LeetCode Problem Link](https://leetcode.com/problems/search-a-2d-matrix-ii/)

## Description

Write an efficient algorithm that searches for a value `target` in an `m x n` integer matrix `matrix`. This matrix has the following properties:

- Integers in each row are sorted in ascending from left to right.
- Integers in each column are sorted in ascending from top to bottom.

## Examples

**Example 1:**
![Example 1](https://assets.leetcode.com/uploads/2020/11/11/searchgrid2.jpg)
```
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
```

**Example 2:**
![Example 2](https://assets.leetcode.com/uploads/2020/11/11/searchgrid.jpg)
```
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
```

## Constraints

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= n, m <= 300`
- `-10^9 <= matrix[i][j] <= 10^9`
- All the integers in each row are **sorted** in ascending order.
- All the integers in each column are **sorted** in ascending order.
- `-10^9 <= target <= 10^9`

## Approach: Top-Right Pointer Traversal

We can take advantage of the matrix's sorted properties (rows sorted left-to-right, columns sorted top-to-bottom) to find the target efficiently without scanning every element.

### Intuition

Imagine starting at the **top-right** corner of the matrix (`matrix[0][cols - 1]`). 
At this position:
- All elements to the **left** in the same row are strictly **smaller**.
- All elements **below** in the same column are strictly **larger**.

This creates a perfect binary decision tree:
1. Initialize pointers `r = 0` (top row) and `c = cols - 1` (rightmost column).
2. Loop while `r < rows` and `c >= 0` (we haven't fallen off the matrix boundaries):
   - If `matrix[r][c] == target`, we found it! Return `true`.
   - If `matrix[r][c] > target`, the current element is too large. Since everything below it is even larger, the target *must* be to the left. We move left: `c--`.
   - If `matrix[r][c] < target`, the current element is too small. Since everything to its left is even smaller, the target *must* be below. We move down: `r++`.
3. If the loop terminates without finding the target, it doesn't exist. Return `false`.

*(Note: Starting at the bottom-left corner works equally well with inverted logic, but top-left or bottom-right do not give deterministic paths).*

### Complexity Analysis

- **Time Complexity:** `O(m + n)` where $m$ is the number of rows and $n$ is the number of columns. At each step, we either decrement `c` or increment `r`. We can decrement `c` at most $n$ times and increment `r` at most $m$ times before going out of bounds.
- **Space Complexity:** `O(1)`. We only use two integer pointers.

## Code (Java)

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int r = 0;
        int c = cols - 1;
        
        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--; // move left
            } else {
                r++; // move down
            }
        }
        
        return false;
    }
}
```
