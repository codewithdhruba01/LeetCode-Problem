# 766. Toeplitz Matrix

[LeetCode Problem Link](https://leetcode.com/problems/toeplitz-matrix/)

## Description

Given an `m x n` `matrix`, return `true` *if the matrix is Toeplitz. Otherwise, return* `false`.

A matrix is **Toeplitz** if every diagonal from top-left to bottom-right has the same elements.

## Examples

**Example 1:**
![Example 1](https://assets.leetcode.com/uploads/2020/11/04/ex1.jpg)
```
Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: true
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
```

**Example 2:**
![Example 2](https://assets.leetcode.com/uploads/2020/11/04/ex2.jpg)
```
Input: matrix = [[1,2],[2,2]]
Output: false
Explanation:
The diagonal "[1, 2]" has different elements.
```

## Constraints

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 20`
- `0 <= matrix[i][j] <= 99`

## Follow up:
- What if the `matrix` is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
- What if the `matrix` is so large that you can only load up a partial row into the memory at once?

## Approach: Compare with Top-Left Neighbor

To verify if every diagonal has the same elements, we don't actually need to traverse the matrix diagonally, which can be complex to code.

### Intuition

A simpler property of a Toeplitz matrix is that every element `matrix[i][j]` must be equal to its top-left neighbor `matrix[i-1][j-1]` (if that neighbor exists). By verifying this property for every element starting from the second row and second column, we indirectly verify all diagonals.

1. Loop through the matrix starting from row `i = 1` and column `j = 1`.
2. For each element `matrix[i][j]`, compare it with `matrix[i-1][j-1]`.
3. If any comparison fails (they are not equal), the matrix is not Toeplitz, return `false`.
4. If the loop completes without finding any inequalities, the matrix is Toeplitz, return `true`.

### Complexity Analysis

- **Time Complexity:** `O(M * N)`, where $M$ is the number of rows and $N$ is the number of columns. We visit almost every element in the matrix exactly once.
- **Space Complexity:** `O(1)`. We only use a few loop variables, requiring constant extra space.

## Code (Java)

```java
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Start from row 1 and col 1, compare each element with its top-left neighbor
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
```
